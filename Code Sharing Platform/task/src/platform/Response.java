package platform;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Response {
    private String code = "public static void main(String[] args) {\n    " +
            "SpringApplication.run(CodeSharingPlatform.class, args);\n}";

    LocalDateTime date = LocalDateTime.now();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code.replaceAll("\\{\"\"code\":","");
        this.code = code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDate() {
        return date;
    }
}
