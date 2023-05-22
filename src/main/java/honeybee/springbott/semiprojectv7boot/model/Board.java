package honeybee.springbott.semiprojectv7boot.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "board1")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String userid;
    @Column(insertable = false,updatable = false)
    private Integer thumbs;
    @Column(insertable = false,updatable = false)
    private Integer views;
    private String content;
    @CreatedDate
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;
}
