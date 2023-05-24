package honeybee.springbott.semiprojectv7boot.controller;

import honeybee.springbott.semiprojectv7boot.model.Board;
import honeybee.springbott.semiprojectv7boot.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService bsrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board/list");
        if (cpg == null || cpg == 0) cpg = 1;

        Map<String, Object> libs = bsrv.showBoard(cpg);

        mv.addObject("bd", libs.get("bd"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", libs.get("cntpg"));
        return mv;
    }

    @GetMapping("/find") // 검색하기
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();

        Map<String, Object> libs = bsrv.showBoard(cpg, ftype, fkey);

        mv.addObject("bd", libs.get("bd"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", libs.get("cntpg"));
        mv.setViewName("board/list");

        return mv;
    }

    @GetMapping("/write")
    public String write(Model m) {

        // validation을 위한 첫번째 코드
        m.addAttribute("board",new Board());

        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(@Valid Board board, BindingResult br) {
        String view = "redirect:/board/list?cpg=1";

        if (br.hasErrors()) { // 유효성 검사시 오류가 발생하면
            view = "board/write";
        }
        else {bsrv.newBoard(board);}

        return view;
    }

    @GetMapping("/view")
//    public ModelAndView view(long bno) { // long으로 바꿔서도 한번해보자
    public ModelAndView view(int bno) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("bd", bsrv.readOneBoard(bno));
        mv.setViewName("board/view");

        return mv;


    }
}
