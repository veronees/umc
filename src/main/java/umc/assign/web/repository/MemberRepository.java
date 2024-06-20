package umc.assign.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.assign.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
