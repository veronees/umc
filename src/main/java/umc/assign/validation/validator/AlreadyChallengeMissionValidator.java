package umc.assign.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.assign.domain.Member;
import umc.assign.domain.Mission;
import umc.assign.validation.annotation.AlreadyChallengeMission;
import umc.assign.web.repository.MemberMissionRepository;
import umc.assign.web.repository.MemberRepository;
import umc.assign.web.repository.MissionRepository;

import java.lang.reflect.Field;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AlreadyChallengeMissionValidator implements ConstraintValidator<AlreadyChallengeMission, Object> {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private String memberIdField;
    private String missionIdField;

    @Override
    public void initialize(AlreadyChallengeMission constraintAnnotation) {
        this.memberIdField = constraintAnnotation.memberIdField();
        this.missionIdField = constraintAnnotation.missionIdField();    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Class<?> clazz = value.getClass();
            Field memberIdField = clazz.getDeclaredField(this.memberIdField);
            Field missionIdField = clazz.getDeclaredField(this.missionIdField);

            memberIdField.setAccessible(true);
            missionIdField.setAccessible(true);

            Long memberId = (Long) memberIdField.get(value);
            Long missionId = (Long) missionIdField.get(value);

            Member member = memberRepository.findById(memberId).orElseThrow();
            Mission mission = missionRepository.findById(missionId).orElseThrow();

            return !memberMissionRepository.existsByMemberAndMission(member, mission);
        } catch (Exception e) {
            return false;
        }
    }
}