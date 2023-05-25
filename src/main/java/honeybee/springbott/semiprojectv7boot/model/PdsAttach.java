package honeybee.springbott.semiprojectv7boot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pdsattach")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PdsAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pano;
    private String fname;
    private String ftype;
    private String fsize;
    @Column(insertable = false,updatable = false)
    private String fdowns;
//    @ManyToOne
//    @JoinColumn(name = "pno")
    private Integer pno;

}
