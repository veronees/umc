package umc.assign.apiPayload.exception.handler;

import umc.assign.apiPayload.code.BaseErrorCode;
import umc.assign.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
