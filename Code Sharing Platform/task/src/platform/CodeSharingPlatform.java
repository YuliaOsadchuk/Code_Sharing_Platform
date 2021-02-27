package platform;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    List<Response> list = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code/{N}")
    public String getCode(HttpServletResponse servletResponse, @PathVariable int N) {
        servletResponse.addHeader("Content-Type", "text/html");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Response response = list.get(N - 1);
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

    @GetMapping("/api/code/{N}")
    public String getApiCode(HttpServletResponse servletResponse, @PathVariable int N) throws JsonProcessingException {
        servletResponse.addHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(list.get(N - 1));
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
    public String postApiCode(@RequestBody String s) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(s, Response.class);
        response.setDate(LocalDateTime.now());
        response.setId(list.size() + 1);
        list.add(response);
        return "{\"id\":" + response.getId() + "\"}";
    }

    @GetMapping("/api/code/latest")
    public List getApiCodeLatest() {
        List<Response> responses = new ArrayList<>();
        int lastElement = list.size() - 1;
        int tenFromEnd = list.size() > 10 ? list.size() - 10 : 0;
        for (int i = lastElement; i >= tenFromEnd; i--) {
            responses.add(list.get(i));
        }
        return responses;
    }


}
