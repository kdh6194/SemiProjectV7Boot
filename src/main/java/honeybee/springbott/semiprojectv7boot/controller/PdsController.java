package honeybee.springbott.semiprojectv7boot.controller;


import honeybee.springbott.semiprojectv7boot.model.Pds;
import honeybee.springbott.semiprojectv7boot.model.PdsAttach;
import honeybee.springbott.semiprojectv7boot.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/pds")
public class PdsController {

    @Autowired
    private PdsService pdssrv;

    @GetMapping("/list")
    public String list() {
        return "pds/list";
    }

    @GetMapping("/write") // 입력폼
    public String write(Model m) {
        // validation을 위한 코드
        m.addAttribute("pds",new Pds());
        return "pds/write";
    }
    @PostMapping("/write") // 전송된 데이터 처리
    public String writeok(Pds pds, MultipartFile attach) {
        String viewPage = "error";

        Map<String, Object> pinfo = pdssrv.newPds(pds);
        if (!attach.isEmpty()) { // 첨부파일이 존재한다면
            pdssrv.newPdsAttach(attach, pinfo);
            viewPage = "redirect:/pds/list";
        }
        return viewPage;
    }

    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) throws IOException {
        String savePath = "C:/Java/bootUpload/";
        String fname = "";
        if (pno == 1) {
            fname = "Exam.zip";
        }
        else if (pno == 2) {
            fname = "smile.png";
        }
        else if (pno == 3) {
            fname = "write.html";
        }
        // 파일이름에 한글이 포홤된 경우 적절한 인코딩 작업 수행
        fname = UriUtils.encode(fname, StandardCharsets.UTF_8);

        // 다운로드할 파일 객체 생성
        UrlResource resource = new UrlResource("file:" + (savePath+fname));

        // MIME타입 지정
        // 브라우저에 다운로드할 파일에 대한 정보 제공
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", Files.probeContentType(Paths.get(savePath+fname)));
        header.add("Content-Disposition","attachment; filename=" + fname );

        // 브라우저로 파일 전송하기
        return ResponseEntity.ok().headers(header).body(resource);

    }

    @GetMapping("/showimg")
    @ResponseBody // view 없이 본문 내용 출력 용도
    public Resource showimg() throws MalformedURLException {
        String fname = "C:/Java/bootUpload/" + "smile.png";

        return new UrlResource("file:" + fname);
    }

}
