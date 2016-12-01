package acid.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Grego on 27-11-16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
