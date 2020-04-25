package ac.kr.smu.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@NoArgsConstructor
@Getter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private Long gid;

    @Column
    private String name;

    @Column
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User manager_id;

    @Column
    @OneToMany(mappedBy = "group")
    private List<User> userList = new ArrayList<>();

    @Column
    private String group_code;
}
