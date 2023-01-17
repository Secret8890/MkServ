package mk.studio.mkserv.apis.code.dto;


import lombok.Getter;
import lombok.Setter;

public class CodeDto {
    private CodeDto() {

    }
    @Getter
    public static class Create {
        private String keyCode;
        private String secretKey;
    }

    @Getter
    @Setter
    public static class Response {
        private String keyCode;
        private String secretKey;
    }
}
