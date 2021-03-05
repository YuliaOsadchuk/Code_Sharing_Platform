package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

@SpringBootApplication
@Controller
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code/{N}")
    public String getCode(HttpServletResponse servletResponse, @PathVariable("N") int n, Model model) {
        servletResponse.addHeader("Content-Type", "text/html");
        Response response = RestControllerClass.list.get(n - 1);
        model.addAttribute("response", response);
        return "GetCode";
    }

    @GetMapping("/code/new")
    public String postCode() {
        return "PostCode";
    }

    @GetMapping("/code/latest")
    public String getCodeLatest(ModelMap model) {
        List<Response> responses = RestControllerClass.getLatestList();
        model.addAttribute("responses", responses);
        return "GetCodeLatest";
    }

}
