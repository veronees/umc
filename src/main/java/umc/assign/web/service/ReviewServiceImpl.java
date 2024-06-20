package umc.assign.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.assign.converter.ReviewConverter;
import umc.assign.domain.Restaurant;
import umc.assign.domain.Review;
import umc.assign.web.dto.request.ReviewRequestDTO;
import umc.assign.web.repository.RestaurantRepository;
import umc.assign.web.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public void saveReview(Long restaurantId, ReviewRequestDTO reviewRequestDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        Review review = ReviewConverter.toReview(reviewRequestDTO);
        review.addRestaurant(restaurant);
        reviewRepository.save(review);
    }
}