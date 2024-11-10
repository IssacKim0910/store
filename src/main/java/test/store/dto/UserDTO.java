package test.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// User 클래스 (사용자 관리)
public class UserDTO {
    private String username;
    private String password;
    private String role;

}
