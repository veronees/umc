package umc.assign.web.service;

import umc.assign.web.dto.request.ReviewRequestDTO;

public interface ReviewService {

    public void saveReview(Long restaurantId, ReviewRequestDTO reviewRequestDTO);
}
