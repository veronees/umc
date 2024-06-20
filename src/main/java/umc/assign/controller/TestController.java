package umc.assign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.assign.apiPayload.ApiResponse;
import umc.assign.apiPayload.code.status.SuccessStatus;
import umc.assign.apiPayload.dto.TempExceptionDTO;
import umc.assign.service.TempQueryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseEntity<ApiResponse> test() {
        return ResponseEntity.ok().body(ApiResponse.of(SuccessStatus._OK, "테스트 입니다."));
    }


    @GetMapping("/exception")
    public ResponseEntity<ApiResponse> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseEntity.ok().body(ApiResponse.of(SuccessStatus._OK, new TempExceptionDTO(flag)));
    }
}
