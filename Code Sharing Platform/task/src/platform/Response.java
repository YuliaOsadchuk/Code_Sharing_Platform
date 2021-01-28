package platform;

public class Response {
    String code = "public static void main(String[] args) {\n    " +
            "SpringApplication.run(CodeSharingPlatform.class, args);\n}";

    public String getCode() {
        return code;
    }
}
