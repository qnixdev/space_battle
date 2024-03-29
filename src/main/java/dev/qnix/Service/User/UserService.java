package dev.qnix.Service.User;

import dev.qnix.Entity.User;
import dev.qnix.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByXid(String xid) {
        var existUser = this.userRepository.findByXid(xid);

        return existUser.orElseThrow(IllegalArgumentException::new);
    }

    public User getUserByXidOrCreate(String xid) {
        var existUser = this.userRepository.findByXid(xid);

        if (existUser.isPresent()) {
            return existUser.get();
        }

        var newUser = User.builder()
            .xid(xid)
            .stories(new ArrayList<>())
            .build()
        ;
        this.userRepository.save(newUser);

        return newUser;
    }
}