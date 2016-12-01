package acid.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grego on 27-11-16.
 */

@RestController
public class UsersController {

    UserRepository userRepository;

    @Autowired
    public UsersController (UserRepository userRepository){

     this.userRepository = userRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<?>  getUser(@PathVariable long id){

        if(userRepository.findOne(id) == null) {
            String errorMessage;
            errorMessage = " error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        else {
            User user = new User();
            user = userRepository.findOne(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user){
        String succesMessage, unAuthorizedMessage, badRequestMessage;
        succesMessage = "Created";
        unAuthorizedMessage = "Unauthorized";
        badRequestMessage = "BadRequest";

        System.out.println("Creating User " + user.getUsername());
        System.out.println("Creating Image " + user.getImage());





        if(user != null &&
                !user.getUsername().isEmpty() &&
                !user.getImage().isEmpty() &&
                user.getUsername().equals("username1")
                )
        {
            userRepository.save(user);
            return new ResponseEntity<>(succesMessage, HttpStatus.OK);
        }
        else {

            if(user.getUsername().isEmpty() ||
                    user.getImage().isEmpty())
                {
                    return new ResponseEntity<>(badRequestMessage, HttpStatus.BAD_REQUEST);
                }

            if(!user.getUsername().equals("username1"))
            {
                return new ResponseEntity<>(unAuthorizedMessage, HttpStatus.UNAUTHORIZED);
            }
        }

        return null;
    }
}
