package honeybee.springbott.semiprojectv7boot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "board1")
@Data
public class Board {
    @Id
    private String bno;
    private String title;
    private String userid;
    private String thumbs;
    private String views;
    private String content;
    private String regdate;
}
