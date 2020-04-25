package ac.kr.smu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table
@Getter
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String passwd;

    @Column
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Builder
    public User(String id, String passwd, String name, String email){
        this.id=id;
        this.name=name;
        this.passwd=passwd;
        this.email=email;
    }
}
