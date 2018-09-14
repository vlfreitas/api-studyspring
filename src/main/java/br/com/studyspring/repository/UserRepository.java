package br.com.studyspring.repository;

import br.com.studyspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(@Param("name") String name);

    Optional<User> findById(@Param("id") Integer id);

//    @Query("SELECT new br.com.studyspring.dto.UserDTO(u.id, u.name, u.lastName, u.email, u.cellphone, r) FROM User u INNER JOIN u.reminders r where r.user =:id")
//    User findRemindersByUserId(@Param("id") Integer id);
}
