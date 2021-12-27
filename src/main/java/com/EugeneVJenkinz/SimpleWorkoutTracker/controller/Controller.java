package com.EugeneVJenkinz.SimpleWorkoutTracker.controller;

import com.EugeneVJenkinz.SimpleWorkoutTracker.dao.ExerciseDAO;
import com.EugeneVJenkinz.SimpleWorkoutTracker.dao.UniqueTrainingDAO;
import com.EugeneVJenkinz.SimpleWorkoutTracker.dao.UserDAO;
import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@org.springframework.stereotype.Controller
public class Controller {
    private UniqueTrainingDAO uniqueTrainingDAO;
    private UserDAO userDAO;
    private ExerciseDAO exerciseDAO;
    private UniqueTraining currentUniqueTraining;

    @Autowired
    public void setUniqueTrainingDAO(UniqueTrainingDAO uniqueTrainingDAO) {
        this.uniqueTrainingDAO = uniqueTrainingDAO;
    }
    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Autowired
    public void setExerciseDAO(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    @GetMapping("/")
    public String showDetails(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "welcome-page";
    }

    @RequestMapping("/newTraining")
    public String newTraining(Model model, @ModelAttribute("uniqueTraining") UniqueTraining uniqueTraining,
                              Principal principal) {
        //Получение сущности текущего пользователя
        User user = userDAO.getUserByUsername(principal.getName());

        //Создание новой тренировки, добавление текущей даты и времени, имплементация зависимости
        //к текущему пользователю
        uniqueTraining = new UniqueTraining();
        model.addAttribute("uniqueTraining", uniqueTraining);
        Date date = new Date();
        String dateFormatString = "EEE, MMM d, ''yy h:mm a";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString, new Locale("en"));
        String currentDate = dateFormat.format(date);
        uniqueTraining.setDate(currentDate);
        uniqueTraining.setUser(user);
        uniqueTrainingDAO.saveUniqueTraining(uniqueTraining);
        currentUniqueTraining = uniqueTraining;
        return "new-training";
    }

    //Метод получает текущего пользователя и его последнюю созданную тренировку
    //Создаётся упражнение
    //Добавить: сохранение упражнения в БД, внутри тренировки пользователя, проверить цикличность добавления
    @RequestMapping("/newExercise")
    public String newExercise(Model model, Principal principal) {
        UniqueExercise uniqueExercise = new UniqueExercise();
        model.addAttribute("uniqueExercise", uniqueExercise);
        List<Exercise> exerciseList = exerciseDAO.getExerciseList();
        //Заменить на лямбду
        List<String> exerciseNames = new LinkedList<>();
        for (Exercise exercise : exerciseList) {
            exerciseNames.add(exercise.getName());
        }
        model.addAttribute("exerciseNames", exerciseNames);
        User user = userDAO.getUserByUsername(principal.getName());
        UniqueTraining uniqueTraining = uniqueTrainingDAO.getUniqueTraining(currentUniqueTraining.getId());
        return "add-exercises-to-current-training";
    }
}
