package pl.mt.taskmanager;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository  extends CrudRepository<Task, Long> {
    List<Task> findByStatusIsOrderByDeadlineAsc(Status status);
}
