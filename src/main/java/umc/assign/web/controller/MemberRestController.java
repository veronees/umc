package umc.assign.web.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.assign.apiPayload.ApiResponse;
import umc.assign.converter.RegionConverter;
import umc.assign.web.dto.request.MemberRequestDTO;
import umc.assign.web.dto.response.MemberResponseDTO;
import umc.assign.web.repository.RegionRepository;
import umc.assign.web.service.MemberCommandService;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final RegionRepository regionRepository;

    @PostMapping("/members")
    public ApiResponse<String> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        memberCommandService.joinMember(request);
        return ApiResponse.onSuccess("회원가입 완료");
    }

    @Transactional
    @PostMapping("/regions")
    public ApiResponse<String> saveRegion(@RequestBody RegionRequestDTO regionRequestDTO) {
        regionRepository.save(RegionConverter.toRegion(regionRequestDTO));
        return ApiResponse.onSuccess("지역 등록 완료");
    }

    @Getter
    public static class RegionRequestDTO {
        private String name;
    }
}