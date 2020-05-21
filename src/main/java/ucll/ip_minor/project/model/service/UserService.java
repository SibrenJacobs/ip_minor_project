package ucll.ip_minor.project.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ucll.ip_minor.project.model.DTO.CreateUserDTO;
import ucll.ip_minor.project.model.DTO.UserDTO;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
}
