package platform;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Response {
    int id;
    private String code;
    LocalDateTime date;
    /*public Response() {
    }

    public Response(String code) {
        this.code = code;
    }

    public Response(String code, LocalDateTime date, int id) {
        this.code = code;
        this.date = date;
        this.id = id;
    }*/

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
