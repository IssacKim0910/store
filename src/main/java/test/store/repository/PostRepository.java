package test.store.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import test.store.dto.Post.PostDTO;
import test.store.dto.Post.PostFileDTO;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final SqlSessionTemplate sql;

    public PostDTO insertPost(PostDTO post) {
        sql.insert("post.insertPost", post);
        return post;
    }

    public void saveFile(PostFileDTO postFile) {
        sql.insert("post.saveFile", postFile);
    }
}
