package br.com.studyspring.repository;

import br.com.studyspring.model.Reminder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "reminder", path = "reminders")
public interface ReminderRepository extends PagingAndSortingRepository<Reminder, Long>{

    List<Reminder> findByActive(@Param("active") boolean active);
}
