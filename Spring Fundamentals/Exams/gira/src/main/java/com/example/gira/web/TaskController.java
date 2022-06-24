package com.example.gira.web;

import com.example.gira.model.binding.AddTackBindingModel;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {

        if (currentUser.getId() == null) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("addTackBindingModel")) {
            model.addAttribute("addTackBindingModel", new AddTackBindingModel());
        }

        return "add-task";
    }

    @PostMapping("add")
    public String addTask(@Valid AddTackBindingModel addTackBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTackBindingModel", addTackBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTackBindingModel", bindingResult);

            return "redirect:add";
        }

        taskService.add(modelMapper.map(addTackBindingModel, TaskServiceModel.class));


        return "redirect:/";

    }

    @GetMapping("/setProgress/{id}")
    public String setProgress(@PathVariable Long id) {
        taskService.changeProgress(id);
        return "redirect:/";
    }


}
