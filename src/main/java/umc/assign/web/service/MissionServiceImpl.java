package umc.assign.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.assign.converter.MemberMissionConverter;
import umc.assign.converter.MissionConverter;
import umc.assign.domain.Member;
import umc.assign.domain.MemberMission;
import umc.assign.domain.Mission;
import umc.assign.domain.Restaurant;
import umc.assign.web.dto.request.MissionRequestDTO;
import umc.assign.web.repository.MemberMissionRepository;
import umc.assign.web.repository.MemberRepository;
import umc.assign.web.repository.MissionRepository;
import umc.assign.web.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService {

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    @Override
    public void saveMission(Long restaurantId, MissionRequestDTO missionRequestDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();

        Mission mission = MissionConverter.toMission(missionRequestDTO);
        mission.addRestaurant(restaurant);

        missionRepository.save(mission);
    }

    @Transactional
    @Override
    public void challengeMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Mission mission = missionRepository.findById(missionId).orElseThrow();

        MemberMission memberMission = MemberMissionConverter.toMemberMission();

        memberMission.addMemberMission(member, mission);

        memberMissionRepository.save(memberMission);
    }
}