package umc.assign.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.assign.apiPayload.ApiResponse;
import umc.assign.web.dto.request.ChallengeMissionRequestDTO;
import umc.assign.web.dto.request.MissionRequestDTO;
import umc.assign.web.dto.request.RestaurantRequestDTO;
import umc.assign.web.dto.request.ReviewRequestDTO;
import umc.assign.web.service.MissionService;
import umc.assign.web.service.RestaurantService;
import umc.assign.web.service.ReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/umc/9th")
public class Controller {

    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final MissionService missionService;

    // 특정 지역에 가게 추가하기
    @PostMapping("/regions/{regionId}/restaurants")
    public ApiResponse<String> saveRestaurantOnRegion(@PathVariable Long regionId, @RequestBody RestaurantRequestDTO restaurantRequestDTO) {
        restaurantService.saveRestaurant(regionId, restaurantRequestDTO);
        return ApiResponse.onSuccess("식당 등록 완료");
    }

    // 가게에 리뷰 추가하기
    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ApiResponse<String> saveReview(@PathVariable Long restaurantId, @RequestBody @Valid ReviewRequestDTO reviewRequestDTO) {
        reviewService.saveReview(restaurantId, reviewRequestDTO);
        return ApiResponse.onSuccess("리류 작성 완료");
    }

    // 가게에 미션 추가하기 API
    @PostMapping("/restaurants/{restaurantId}/missions")
    public ApiResponse<String> saveMission(@PathVariable Long restaurantId, MissionRequestDTO missionRequestDTO) {
        missionService.saveMission(restaurantId, missionRequestDTO);
        return ApiResponse.onSuccess("미션 추가 완료");
    }

    // 가게의 미션을 도전 중인 미션에 추가하기(미션 도전하기) API
    @PostMapping("/members/missions")
    public ApiResponse<String> challengeMission(@RequestBody @Valid ChallengeMissionRequestDTO challengeMissionRequestDTO) {
        missionService.challengeMission(challengeMissionRequestDTO.getMemberId(), challengeMissionRequestDTO.getMissionId());
        return ApiResponse.onSuccess("미션 도전하기 완료");
    }
}