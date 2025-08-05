package app.todo.todoapp.security;

import app.todo.todoapp.models.User;
import app.todo.todoapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // email is principal
                .password(user.getPasswordHash())
                .authorities("USER") // default role
                .build();
    }
}
