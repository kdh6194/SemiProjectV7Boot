package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.dao.PdsDAO;
import honeybee.springbott.semiprojectv7boot.model.Board;
import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.utils.PdsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service("pdssrv")
public class PdsServiceImpl implements PdsService{
    @Autowired
    PdsDAO pdsdao;
    @Autowired
    PdsUtils pdsUtils;
    @Override
    public Map<String, Object> showPds(int cpage) {
        return null;
    }

    @Override
    public Map<String, Object> showPds(int cpage, String ftype, String fkey) {
        return null;
    }

    @Override
    public int newPds(Pds pds) {
        pds.setUuid(pdsUtils.makeUUID());
        return pdsdao.insertPds(pds);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {
        return true;
    }

    @Override
    public Board readOneBoard(int bno) {
        return null;
    }
}
