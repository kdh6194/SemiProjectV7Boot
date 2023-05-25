package honeybee.springbott.semiprojectv7boot.service;


import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {

    Map<String, Object> showPds(Integer cpage);
    Map<String, Object> showPds(Integer cpage,String ftype, String fkey);
    Map<String, Object> newPds(Pds pds);
    boolean newPdsAttach(MultipartFile attach, Map<String, Object> pinfo);
    Pds readOnePds(int pno);
    PdsAttach readOnePdsAttach(int pno);

    HttpHeaders getHeader(String fname, String uuid);

    UrlResource getResource(String fname, String uuid);
}
