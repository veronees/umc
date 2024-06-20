package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
