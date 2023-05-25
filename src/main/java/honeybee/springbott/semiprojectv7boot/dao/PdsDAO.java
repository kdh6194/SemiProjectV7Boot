package honeybee.springbott.semiprojectv7boot.dao;

import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsDAO {
    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);

}
