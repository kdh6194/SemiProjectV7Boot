package honeybee.springbott.semiprojectv7boot.repository;


import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PdsaRepository extends JpaRepository<PdsAttach, Long> {
    PdsAttach findByPno(int pno);


}
