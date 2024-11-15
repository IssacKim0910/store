package test.store.dto.Post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostDTO {
    private Integer postId;          // 게시글 ID
    private String postTitle;        // 게시글 제목
    private String postDescription;  // 게시글 설명
    private String location;         // 매장 위치
    private String hashTags;   // 해시태그 목록
    private String address;          // 매장 주소
    private String phoneNumber;      // 연락처
    private String price;            // 가격
    private String paymentRate;      // 결제 비율
    private List<MultipartFile> postFile;
}
