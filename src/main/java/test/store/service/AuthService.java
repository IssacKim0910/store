package test.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.store.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final Map<String, UserDTO> users;

    // 임시 관리자 ID
    public AuthService() {
        users = new HashMap<>();
        users.put("admin", new UserDTO("admin", "admin1595@@", "ADMIN"));
    }

    public boolean authenticate(String username, String password) {
        UserDTO user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public String getRole(String username) {
        UserDTO user = users.get(username);
        return user != null ? user.getRole() : null;
    }
}
