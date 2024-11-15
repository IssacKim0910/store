package test.store.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import test.store.dto.AjaxDataDTO;
import test.store.dto.Post.PostDTO;
import test.store.service.PostService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @ResponseBody
    @PostMapping("/insertPost")
    public AjaxDataDTO insertPost(PostDTO postDTO) throws IOException {
        AjaxDataDTO ajaxDataDTO = new AjaxDataDTO();
        try {
            // fileName이 ""일때 제거 하기 위함
            List<MultipartFile> filteredFile = postDTO.getPostFile().stream()
                    .filter(fileName -> fileName != null && !fileName.isEmpty())
                    .collect(Collectors.toList());


            postDTO.setPostFile(filteredFile);
            postService.save(postDTO);
            ajaxDataDTO.setSuccess(true);
        } catch (Exception e) {
            ajaxDataDTO.setSuccess(false);
            ajaxDataDTO.setMessage("포스트 저장에 실패했습니다: " + e.getMessage());
        }

        return ajaxDataDTO;
    }


}
