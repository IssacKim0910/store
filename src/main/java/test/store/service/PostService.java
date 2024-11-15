package test.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import test.store.dto.Post.PostDTO;
import test.store.dto.Post.PostFileDTO;
import test.store.repository.PostRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public void save(PostDTO post) throws IOException {
        // 포스트에서 파일 리스트를 가져옵니다.
        PostDTO info = postRepository.insertPost(post);
        System.out.println("info 값: " + info);
        try {
            List<MultipartFile> files = post.getPostFile();  // post.getPostFiles()로 MultipartFile 리스트 가져오기
            System.out.println(files);
            if (files == null || files.isEmpty()) {
                System.out.println("files 변수가 null이거나 비어 있습니다.");
//                null이면 처리를 중지하고 메서드를 종료
                return;
            }

            for (MultipartFile file : files) {
                // 파일 정보 설정
                PostFileDTO postFile = new PostFileDTO();
                postFile.setPostId(info.getPostId());
                String fileUuid = UUID.randomUUID().toString();
                postFile.setFileUuid(fileUuid);
                String uploadDir = "C:\\Users\\USER\\Desktop\\test";
                Path path = Paths.get(uploadDir + file.getOriginalFilename());

                // 디렉토리가 존재하지 않으면 생성
                Files.createDirectories(path.getParent());

                // 파일을 지정한 경로에 저장
                Files.copy(file.getInputStream(), path);
                // 파일 경로를 "/uploads/" + 파일명으로 설정
                postFile.setFilePath("/uploads/" + file.getOriginalFilename());  // getOriginalFilename() 사용

                // postFile을 데이터베이스에 저장
                postRepository.saveFile(postFile);
            }
        } catch (Exception e) {
            System.out.println("포스트를 데이터베이스에 추가하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }


    private String saveFileToServer(MultipartFile file) {
        // 파일을 서버에 저장하는 로직을 구현하여 파일 경로를 반환합니다.
        // 예를 들어, 파일을 업로드할 디렉토리를 지정하고 파일을 해당 디렉토리에 저장한 후 파일 경로를 반환할 수 있습니다.
        // 이는 프로젝트의 요구사항에 따라 다르므로 적절한 로직을 구현하십시오.
        return "/uploads/" + file.getOriginalFilename();
    }
}
