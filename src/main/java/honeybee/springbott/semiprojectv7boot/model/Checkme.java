package honeybee.springbott.semiprojectv7boot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Checkme {
    @NotBlank(message = "이름은 반드시 입력하셔야 합니다!!")
    private String name2;
    @NotBlank(message = "주민번호는 반드시 입력하셔야 합니다!!")
    private String jumin1;
    @NotBlank(message = "주민번호는 반드시 입력하셔야 합니다!!")
    private String jumin2;
}
