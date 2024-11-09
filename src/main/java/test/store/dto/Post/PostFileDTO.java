package test.store.dto.Post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostFileDTO {
    private Integer fileId;
    private Integer postId;  // postId는 Integer로 설정 (게시글과 연결)
    private String fileUuid; // 파일의 고유 UUID 값
    private String filePath; // 파일 경로
    private List<MultipartFile> fileList; // 여러 파일을 처리할 수 있는 리스트
}
