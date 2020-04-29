package ac.kr.smu.repository;

import ac.kr.smu.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Object> {
    Optional<Group> findByCode(String code);
}
