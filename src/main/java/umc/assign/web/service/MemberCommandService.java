package umc.assign.web.service;

import umc.assign.domain.Member;
import umc.assign.web.dto.request.MemberRequestDTO;

public interface MemberCommandService {

    public void joinMember(MemberRequestDTO.JoinDto request);
}
