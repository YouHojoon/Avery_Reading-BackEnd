package ac.kr.smu.service;

import ac.kr.smu.config.jwt.JwtTokenProvider;
import ac.kr.smu.domain.Schedule;
import ac.kr.smu.domain.User;
import ac.kr.smu.repository.GroupRepository;
import ac.kr.smu.repository.ScheduleRepository;
import ac.kr.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Service
@RequiredArgsConstructor
public class ScheduleService{
    private final ScheduleRepository scheduleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public void register(Schedule schedule) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = jwtTokenProvider.resolveToken(request);
        User user = userRepository.findById(Long.valueOf(jwtTokenProvider.getUid(token))).orElseThrow();
        schedule.setUser(user);
        schedule.setGroup(user.getGroup());
        scheduleRepository.save(schedule);
    }
}
