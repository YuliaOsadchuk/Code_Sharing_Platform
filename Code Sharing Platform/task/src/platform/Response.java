package platform;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Response {
    private String code;// = "public static void main(String[] args) {\n    " +
            //"SpringApplication.run(CodeSharingPlatform.class, args);\n}";

    LocalDateTime date;// = LocalDateTime.now();

    public Response() {
    }

    public Response(String code, LocalDateTime date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
