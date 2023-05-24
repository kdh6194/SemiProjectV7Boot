package honeybee.springbott.semiprojectv7boot.utils;

import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.LocalTime;

@Component("pdsUtils")
public class PdsUtils {

    public String makeUUID() {
        String uuid = LocalDateTime.now() + "" + LocalTime.now();
        uuid = uuid.replace("-","").replace(":","").replace("-","");

        return uuid;
    }
}
