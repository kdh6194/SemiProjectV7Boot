package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import honeybee.springbott.semiprojectv7boot.repository.PdsRepository;
import honeybee.springbott.semiprojectv7boot.repository.PdsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;


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

    @Override
    public Map<String,Object> selectPds(int cpage) {
        // 페이징시 정렬하는 방식
        Pageable paging = PageRequest.of(cpage,25, Sort.by("pno").descending());

        Map<String, Object> libs = new HashMap<>();
        libs.put("pdslist",pdsRepository.findAll(paging).getContent());
        libs.put("cntpg",pdsRepository.findAll(paging).getTotalPages());

        return libs;
    }
}
