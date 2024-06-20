package umc.assign.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.assign.domain.common.BaseEntity;
import umc.assign.domain.enums.Gender;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birthday;
    private String address;
    private String email;
    private String phoneNumber;

    @ColumnDefault("0")
    private Integer pointAmount;

    // 미션 전부 양방향 매핑
    @OneToMany(mappedBy = "member")
    private List<Food> foods = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Point> points = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Term> terms = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMissions = new ArrayList<>();

    public void addMemberMission(MemberMission memberMission) {
        memberMissions.add(memberMission);
    }
}