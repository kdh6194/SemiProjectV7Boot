package honeybee.springbott.semiprojectv7boot.service;

import honeybee.springbott.semiprojectv7boot.model.Board;
import honeybee.springbott.semiprojectv7boot.model.Pds;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {

    Map<String, Object> showPds(int cpage);
    Map<String, Object> showPds(int cpage,String ftype, String fkey);
    int newPds(Pds pds);
    boolean newPdsAttach(MultipartFile attach, int pno);
    Board readOneBoard(int bno);

}