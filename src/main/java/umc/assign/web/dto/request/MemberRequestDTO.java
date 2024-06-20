package umc.assign.web.dto.request;

import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        String nickname;
        Integer gender;
        String birthday;
        String address;
        String email;
        String phoneNumber;

    }
}
