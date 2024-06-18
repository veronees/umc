package umc.assign.service;

import org.springframework.stereotype.Service;
import umc.assign.apiPayload.code.status.ErrorStatus;
import umc.assign.apiPayload.exception.handler.TempHandler;

@Service
public class TempQueryService {

    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
