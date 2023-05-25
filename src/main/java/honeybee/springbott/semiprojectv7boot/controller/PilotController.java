package honeybee.springbott.semiprojectv7boot.controller;

import org.apache.coyote.Response;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
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
import java.util.UUID;


@Controller
@RequestMapping("/pilot")
public class PilotController {
    @GetMapping("/list")
    public String list() {
        return "pilot/list";
    }
    @GetMapping("/write") // 입력폼
    public String write() {
        return "pilot/write";
    }
    @PostMapping ("/write") // 전송된 데이터 처리
    public String writeok(String title, String content, MultipartFile attach, Model m) throws IOException {

        // 일반 폼 요소 처리 (텍스트 타입 데이터)
        m.addAttribute("title",title);
        m.addAttribute("content",content);

        // 멀티파트 폼 요소 처리
        if(attach.isEmpty()){
            m.addAttribute("attach","첨부 파일이 없습니다.");
        }
        else{
            String fname = attach.getOriginalFilename();
            //업로드한 파일이름 알아내기
            m.addAttribute("filename",fname);
            // 업로드한 파일종류 알아내기
            m.addAttribute("filetype",attach.getContentType());
            // 업로드한 파일크기 알아내기
            m.addAttribute("filesize",attach.getSize()/1024);
            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성1
            // 파일이름 + uuid + 확장자
            // abc.jpg -> abcqwefadsfa-asdfas-4452-9asdf423-465as16dfas.jpg
            String uuid = UUID.randomUUID().toString().replace("-",""); // uuid에서 '-'제거
            m.addAttribute("uuid",uuid);
            // 파일이름과 확장자 분리하기
            String fileName = fname.split("[.]")[0];
            String fileExt = fname.split("[.]")[1];
            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성2
            String fmt = "yyyyMMddHHmmss";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            uuid = sdf.format(new Date());
            m.addAttribute("uuid",uuid);
            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성3
            uuid = LocalDateTime.now() + "" + LocalTime.now();
            uuid = uuid.replace("-","").replace(":","").replace("-","");
            m.addAttribute("uuid",uuid);

            // 업로드한 파일 저장하기
            attach.transferTo(new File("C:/Java/bootUpload/" + fileName + uuid + "." + fileExt));
        }

        return "redirect:/pilot/list";
    }

    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) throws IOException {
        String savePath = "C:/Java/bootUpload/";
        String fname = "";
        if (pno == 1) {
            fname = "zip.zip";
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
