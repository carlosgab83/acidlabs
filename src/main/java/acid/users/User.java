package acid.users;

import javax.persistence.*;

/**
 * Created by Grego on 27-11-16.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String username;

    @Column(length=100000000)
    String image;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(String username, String image)
    {
        this.username = username;
        this.image = image;
    }

    public User(){}

}
