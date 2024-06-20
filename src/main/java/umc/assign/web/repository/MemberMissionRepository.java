package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Member;
import umc.assign.domain.MemberMission;
import umc.assign.domain.Mission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberAndMission(Member member, Mission mission);
}
