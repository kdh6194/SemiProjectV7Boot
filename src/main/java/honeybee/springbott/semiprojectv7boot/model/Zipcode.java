package honeybee.springbott.semiprojectv7boot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table (name = "zipcode")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Zipcode {

    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String ri;
    private String bunji;

    @Id
    private Long seq;
}
