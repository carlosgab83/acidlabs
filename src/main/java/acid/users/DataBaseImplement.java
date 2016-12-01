package acid.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grego on 27-11-16.
 */
@Component
public class DataBaseImplement implements CommandLineRunner{

    private UserRepository userRepository;

    @Autowired
    public DataBaseImplement(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<User> users = new ArrayList<>();

       /* users = new ArrayList<>();
        users.add(new User("Pedro","img1"));
        users.add(new User("Gregory","img2"));

        userRepository.save(users);*/
    }
}
