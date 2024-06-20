package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
