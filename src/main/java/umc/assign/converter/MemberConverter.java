package umc.assign.converter;

import umc.assign.domain.Member;
import umc.assign.domain.enums.Gender;
import umc.assign.web.dto.request.MemberRequestDTO;
import umc.assign.web.dto.response.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MAN;
                break;
            case 2:
                gender = Gender.WONAM;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .nickname(request.getNickname())
                .build();
    }
}