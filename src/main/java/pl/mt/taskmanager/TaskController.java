package pl.mt.taskmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("task", new Task());
        List<Task> unfinishedTasksList = taskService.findUnfinishedTasks();
        if (unfinishedTasksList.isEmpty()) {
            model.addAttribute("text", "Brak zadań do wykonania.");
        } else {
            model.addAttribute("unfinishedTasksList", unfinishedTasksList);
        }
        return "index";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        task.setStatus(Status.NEW);
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/archives")
    public String showArchive(Model model) {
        List<Task> finishedTasksList = taskService.findFinishedTasks();
        if (finishedTasksList.isEmpty()) {
            model.addAttribute("text", "Brak zadań do wykonania.");
        } else {
            model.addAttribute("finishedTasksList", finishedTasksList);
        }
        return "archives";
    }

    @GetMapping("/finish")
    public String finishTask(@RequestParam Long id) {
        taskService.finishTask(id);
        return "redirect:/";
    }
}
