package umc.assign.web.dto.request;

import lombok.Getter;
import umc.assign.validation.annotation.AlreadyChallengeMission;

@Getter
@AlreadyChallengeMission(memberIdField = "memberId", missionIdField = "missionId")
public class ChallengeMissionRequestDTO {
    private Long memberId;
    private Long missionId;
}
