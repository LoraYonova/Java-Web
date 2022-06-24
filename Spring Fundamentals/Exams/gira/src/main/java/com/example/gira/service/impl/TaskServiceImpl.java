package com.example.gira.service.impl;

import com.example.gira.model.entity.TaskEntity;
import com.example.gira.model.entity.enums.ProgressEnum;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.view.TaskViewModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final ClassificationService classificationService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, UserService userService, ClassificationService classificationService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.classificationService = classificationService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel) {

        TaskEntity task = modelMapper.map(taskServiceModel, TaskEntity.class);
        task.setUser(userService.findById(currentUser.getId()));
        task.setClassification(classificationService.findByName(taskServiceModel.getClassification()));
        task.setProgress(ProgressEnum.OPEN);

        taskRepository.save(task);

    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        return taskRepository.getAllBy().stream()
                .map(taskEntity -> {
                    TaskViewModel taskViewModel = modelMapper.map(taskEntity, TaskViewModel.class);
                    taskViewModel.setAssignedTo(taskEntity.getUser().getUsername());
                    taskViewModel.setClassification(taskEntity.getClassification().getClassificationName());
                    taskViewModel.setProgress(taskEntity.getProgress());
                    return taskViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void changeProgress(Long id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        assert task != null;
        String progress = task.getProgress().name();

        switch (progress) {
            case "OPEN" -> {
                task.setProgress(ProgressEnum.IN_PROGRESS);
                taskRepository.save(task);
            }
            case "IN_PROGRESS" -> {
                task.setProgress(ProgressEnum.COMPLETED);
                taskRepository.save(task);
            }
            case "COMPLETED" -> taskRepository.delete(task);
        }


    }
}
