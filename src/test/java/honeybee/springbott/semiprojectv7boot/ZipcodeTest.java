package honeybee.springbott.semiprojectv7boot;

import honeybee.springbott.semiprojectv7boot.model.Zipcode;
import honeybee.springbott.semiprojectv7boot.repoesitory.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ZipcodeTest {

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Test
    @DisplayName("zipcode")
    public void findZipByDong() {
        List<Zipcode> addr = zipcodeRepository.findZipcodeByDong("구로동");
        System.out.println(addr);
    }

}
