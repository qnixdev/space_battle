package dev.qnix.Service.User;

import dev.qnix.Entity.User;
import dev.qnix.Repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByXidOrCreate(@NonNull String xid) {
        var existUser = this.userRepository.findByXid(xid);

        if (existUser.isPresent()) {
            return existUser.get();
        }

        var newUser = User.builder()
            .xid(xid)
            .build()
        ;
        this.userRepository.save(newUser);

        return newUser;
    }
}