package br.com.studyspring.repository;

import br.com.studyspring.dto.ReminderDTO;
import br.com.studyspring.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "reminder", path = "reminders")
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {

    List<Reminder> findByActive(@Param("active") boolean active);

    List<Reminder> findByUserId(@Param("user_id") Integer id);

    @Query("SELECT new br.com.studyspring.dto.ReminderDTO(r.id, r.active, r.hour, r.days, u) FROM Reminder r INNER JOIN r.user u ")
    List<ReminderDTO> find();
}
