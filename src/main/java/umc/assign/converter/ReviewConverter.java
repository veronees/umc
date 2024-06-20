package umc.assign.converter;

import umc.assign.domain.Review;
import umc.assign.web.dto.request.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO reviewRequestDTO) {
        return Review.builder()
                .content(reviewRequestDTO.getContent())
                .build();
    }
}
