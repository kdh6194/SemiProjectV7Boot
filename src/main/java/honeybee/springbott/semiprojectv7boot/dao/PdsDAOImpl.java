package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import honeybee.springbott.semiprojectv7boot.repository.PdsRepository;
import honeybee.springbott.semiprojectv7boot.repository.PdsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Repository("pdsdao")
public class PdsDAOImpl implements PdsDAO{
    @Autowired
    private PdsRepository pdsRepository;
    @Autowired
    private PdsaRepository pdsaRepository;
    @Override
    public int insertPds(Pds pds) {
        // 제목, 작성자, 본문을 pds테이블에 저장한 뒤
        // 저장시 생성된 pno를 리턴함 - pdsattach 저장시 사용
        return Math.toIntExact(pdsRepository.save(pds).getPno());
    }

    @Override
    public int insertPdsAttach(PdsAttach pa) {
        return Math.toIntExact(pdsaRepository.save(pa).getPano());
    }
}
