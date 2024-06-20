package umc.assign.converter;

import umc.assign.domain.MemberMission;
import umc.assign.domain.enums.MissionStatus;

public class MemberMissionConverter {

    public static MemberMission toMemberMission() {
        return MemberMission.builder()
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }
}
