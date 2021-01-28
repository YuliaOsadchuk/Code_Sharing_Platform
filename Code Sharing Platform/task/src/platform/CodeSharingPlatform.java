package platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code")
    public String getCode(HttpServletResponse servletResponse) {
        servletResponse.addHeader("Content-Type", "text/html");
        Response response = new Response();
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                response.getCode() +
                "</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("/api/code")
    public String getApiCode(HttpServletResponse servletResponse) throws JsonProcessingException {
        servletResponse.addHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new Response());
    }

}
