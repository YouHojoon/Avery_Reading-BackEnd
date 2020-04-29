package ac.kr.smu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table
@NoArgsConstructor
@Getter
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date D_day;

    @Column
    private String location;

    @Column
    private String content;

    @Column
    private String book;

    @Column
    private String presentation;

    @ManyToOne
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "GID")
    private Group group;

    @Builder
    Schedule(String title, Date D_day, String location, String content, String book, String presentation) {
        this.title = title;
        this.D_day = D_day;
        this.location = location;
        this.content = content;
        this.book = book;
        this.presentation = presentation;
    }
    public void setUser(User user){
        this.user=user;
    }
    public void setGroup(Group group){
        this.group=group;
    }
}
