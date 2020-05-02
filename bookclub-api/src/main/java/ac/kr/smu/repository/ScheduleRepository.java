package ac.kr.smu.repository;

import ac.kr.smu.domain.Group;
import ac.kr.smu.domain.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Object> {
    Page<Schedule> findByGroup(Group group, Pageable pageable);
}
