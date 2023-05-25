package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;


import java.util.List;
import java.util.Map;

public interface PdsDAO {
    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);
    Map<String,Object> selectPds(int cpage);

    Pds selectOnePds(int pno);

    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<String> selectFtype();
}
