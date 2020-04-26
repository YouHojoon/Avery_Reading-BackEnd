package ac.kr.smu.service;

import ac.kr.smu.domain.Group;
import ac.kr.smu.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public void register(Group group){
        String code;
        while(true){
            code=makeCode();
            Optional<Group> check=groupRepository.findByCode(code);
            if(check.isEmpty())
                break;
        }
        group.setCode(code);
        groupRepository.save(group);
    }
    private String makeCode(){
        StringBuffer code=new StringBuffer();
        for (int i=0; i<6; i++)
            code.insert(i,(char)((int)(Math.random()*26)+65));
        return code.toString();
    }
}
