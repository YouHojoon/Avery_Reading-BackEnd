package ac.kr.smu.service;

import ac.kr.smu.config.jwt.JwtTokenProvider;
import ac.kr.smu.controller.ScheduleController;
import ac.kr.smu.domain.Schedule;
import ac.kr.smu.domain.User;
import ac.kr.smu.repository.ScheduleRepository;
import ac.kr.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.hateoas.PagedModel.PageMetadata;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public CollectionModel<Schedule> selectScheduleList(Pageable pageable) {
        User user = getUser();
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        Page<Schedule> scheduleList = scheduleRepository.findByGroup(user.getGroup(), pageable);
        PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), scheduleList.getNumber(), scheduleList.getTotalElements());
        PagedModel<Schedule> resource = new PagedModel<>(scheduleList.getContent(), pageMetadata);
        resource.add(linkTo(methodOn(ScheduleController.class).getSchedule(pageable)).withSelfRel());
        return resource;
    }

    public void register(Schedule schedule) {
        User user = getUser();
        schedule.setUser(user);
        schedule.setGroup(user.getGroup());
        scheduleRepository.save(schedule);
    }

    private User getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = jwtTokenProvider.resolveToken(request);
        return userRepository.findByUid(Long.valueOf(jwtTokenProvider.getUid(token))).orElseThrow();
    }
}
