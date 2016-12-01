package acid.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Grego on 28-11-16.
 */
@Controller
public class ViewController {

   @RequestMapping("/")
    public String index(){
       return "index";
    }
}


