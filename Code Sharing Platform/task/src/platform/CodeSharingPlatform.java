package platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    Response response = new Response();

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code")
    public String getCode(HttpServletResponse servletResponse) {
        servletResponse.addHeader("Content-Type", "text/html");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<span id=\"load_date\">" + response.date.format(formatter) + "</span>" +
                "    <pre id=\"code_snippet\">\n" +
                response.getCode() +
                "</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("/api/code")
    public String getApiCode(HttpServletResponse servletResponse) throws JsonProcessingException {
        servletResponse.addHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(response);
    }

    @GetMapping("/code/new")
    public String postCode() {
        return "<html>\n" +
                "<head>\n" +
                "    <title>Create</title>\n" +
                "    <script>function send() {\n" +
                "    let object = {\n" +
                "        \"code\": document.getElementById(\"code_snippet\").value\n" +
                "    };\n" +
                "    \n" +
                "    let json = JSON.stringify(object);\n" +
                "    \n" +
                "    let xhr = new XMLHttpRequest();\n" +
                "    xhr.open(\"POST\", '/api/code/new', false)\n" +
                "    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "    xhr.send(json);\n" +
                "    \n" +
                "    if (xhr.status == 200) {\n" +
                "      alert(\"Success!\");\n" +
                "    }\n" +
                "}\n" +
                "    </script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<form action=\"\" method=\"post\">\n" +
                "    <p>\n" +
                "        <textarea textarea id=\"code_snippet\">\n" +
                "        </textarea>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        <button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>\n" +
                "    </p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping("/api/code/new")
    public String postApiCode(@RequestBody String s) {
        s = s.substring(9, s.length() - 2);
        response.setCode(s);
        response.setDate(LocalDateTime.now());
        return "{}";
    }


}
