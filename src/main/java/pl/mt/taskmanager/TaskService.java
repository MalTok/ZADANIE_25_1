package pl.mt.taskmanager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    @Modifying
    public void finishTask(Long id) {
        Optional<Task> task = findTask(id);
        if (task.isPresent()) {
            Task foundTask = task.get();
            foundTask.setStatus(Status.FINISHED);
            taskRepository.save(foundTask);
        }
    }

    private Optional<Task> findTask(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findUnfinishedTasks() {
        return taskRepository.findByStatusIsOrderByDeadlineAsc(Status.NEW);
    }

    public List<Task> findFinishedTasks() {
        return taskRepository.findByStatusIsOrderByDeadlineAsc((Status.FINISHED));
    }
}
