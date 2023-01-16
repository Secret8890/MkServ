package mk.studio.mkserv.apis.account.dto;

import lombok.Getter;
import lombok.Setter;

public class AccountDto {
    private AccountDto() {

    }

    @Getter
    @Setter
    public static class Create {
        private String email;
        private String name;
        private String password;

        @Override
        public String toString() {
            return "email : "+ email + " password : " + password + " name : " + name;
        }
    }

    @Getter
    @Setter
    public static class Response {
        private String email;
        private String name;
        private String refreshToken;
        private String accessToken;
    }

    @Getter
    @Setter
    public static class Login {
        private String email;
        private String password;
    }
}
