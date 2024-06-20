package umc.assign.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.assign.converter.MemberConverter;
import umc.assign.domain.Member;
import umc.assign.web.dto.request.MemberRequestDTO;
import umc.assign.web.repository.MemberRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public void joinMember(MemberRequestDTO.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        memberRepository.save(member);

    }
}