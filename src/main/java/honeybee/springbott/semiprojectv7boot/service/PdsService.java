package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.model.Board;
import honeybee.springbott.semiprojectv7boot.model.Pds;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {

    Map<String, Object> showPds(Integer cpage);
    Map<String, Object> showPds(Integer cpage,String ftype, String fkey);
    Map<String, Object> newPds(Pds pds);
    boolean newPdsAttach(MultipartFile attach, Map<String, Object> pinfo);
    Board readOneBoard(int bno);

}
