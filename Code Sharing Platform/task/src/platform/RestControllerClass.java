package platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class RestControllerClass {

    public static List<Response> list = new ArrayList<>();

    @GetMapping("/api/code/{N}")
    public String getApiCode(HttpServletResponse servletResponse, @PathVariable("N") int n) throws JsonProcessingException {
        servletResponse.addHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list.get(n - 1));
    }

    @PostMapping("/api/code/new")
    public String postApiCode(@RequestBody String s) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(s, Response.class);
        response.setDate(LocalDateTime.now());
        list.add(response);
        return "{\"id\":\"" + list.size() + "\"}";
    }

    @GetMapping("/api/code/latest")
    public List getApiCodeLatest() {
        return getLatestList();
    }

    public static List getLatestList(){
        List<Response> responses = new ArrayList<>();
        int lastElementIndex = list.size() - 1;
        int tenFromEnd = list.size() > 10 ? list.size() - 10 : 0;
        for (int i = lastElementIndex; i >= tenFromEnd; i--) {
            responses.add(list.get(i));
        }
        return responses;
    }
}
