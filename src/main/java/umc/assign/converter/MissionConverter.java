package umc.assign.converter;

import umc.assign.domain.Mission;
import umc.assign.web.dto.request.MissionRequestDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO missionRequestDTO) {
        return Mission.builder()
                .missionPrice(missionRequestDTO.getMissionPrice())
                .successPoint(missionRequestDTO.getSuccessPoint())
                .dDay(missionRequestDTO.getDDay())
                .build();
    }
}
