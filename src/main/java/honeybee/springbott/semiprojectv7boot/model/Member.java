package honeybee.springbott.semiprojectv7boot.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date; // 무슨 의미고


@Entity
@Data
@Table(name = "member1")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbno;
    private String name;
    private String jumin1;
    private String jumin2;
    private String userid;
    private String passwd;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String email;
    private String phone;

    //@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;

    private String userid1;
    private String passwd1;



}
