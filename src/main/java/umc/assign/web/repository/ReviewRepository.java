package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
