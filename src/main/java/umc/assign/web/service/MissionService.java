package umc.assign.web.service;

import umc.assign.web.dto.request.MissionRequestDTO;

public interface MissionService {
    public void saveMission(Long restaurantId, MissionRequestDTO missionRequestDTO);

    public void challengeMission(Long memberId, Long missionId);
}
