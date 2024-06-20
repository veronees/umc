package umc.assign.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.assign.apiPayload.code.BaseErrorCode;
import umc.assign.apiPayload.code.status.ErrorStatus;
import umc.assign.apiPayload.exception.GeneralException;
import umc.assign.converter.RestaurantConverter;
import umc.assign.domain.Region;
import umc.assign.domain.Restaurant;
import umc.assign.web.dto.request.RestaurantRequestDTO;
import umc.assign.web.repository.RegionRepository;
import umc.assign.web.repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public void saveRestaurant(Long regionId, RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = RestaurantConverter.toRestaurant(restaurantRequestDTO);
        Region region = regionRepository.findById(regionId).orElseThrow(
                () -> new GeneralException(ErrorStatus.NOT_FOUND_REGION)
        );
        restaurant.addRegion(region);
        restaurantRepository.save(restaurant);
    }
}