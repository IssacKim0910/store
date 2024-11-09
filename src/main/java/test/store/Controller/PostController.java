package test.store.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.store.dto.AjaxDataDTO;

@Controller
@RequiredArgsConstructor
public class PostController {


    @ResponseBody
    @PostMapping("/insertPost")
    public AjaxDataDTO insertPost() {
        AjaxDataDTO ajaxDataDTO = new AjaxDataDTO();

        ajaxDataDTO.setSuccess(true);
        return ajaxDataDTO;
    }


}
