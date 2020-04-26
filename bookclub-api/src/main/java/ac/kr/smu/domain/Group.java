package ac.kr.smu.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column
    private String name;


    @Column
    @OneToMany(mappedBy = "group")
    private List<User> userList = new ArrayList<>();

    @Column
    private String group_code;
}
