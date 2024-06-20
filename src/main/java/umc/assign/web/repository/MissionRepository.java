package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
