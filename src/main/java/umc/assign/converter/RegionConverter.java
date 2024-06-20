package umc.assign.converter;

import umc.assign.domain.Region;
import umc.assign.web.controller.MemberRestController;

public class RegionConverter {

    public static Region toRegion(MemberRestController.RegionRequestDTO regionRequestDTO) {
        return Region.builder()
                .name(regionRequestDTO.getName())
                .build();
    }
}