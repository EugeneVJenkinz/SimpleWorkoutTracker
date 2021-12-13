package com.EugeneVJenkinz.SimpleWorkoutTracker.controller;

import com.EugeneVJenkinz.SimpleWorkoutTracker.dao.UniqueTrainingDAO;
import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;
import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.Query;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UniqueTrainingDAO uniqueTrainingDAO;

    @GetMapping("/")
    public String showDetails(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "welcome-page";
    }

    @RequestMapping("/newTraining")
    public String newTraining(Model model) {
        UniqueTraining uniqueTraining = new UniqueTraining();
        Date date = new Date();
        String dateFormatString = "EEE, MMM d, ''yy";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        String currentDate = dateFormat.format(date);
        uniqueTraining.setDate(currentDate);
        uniqueTrainingDAO.saveUniqueTraining(uniqueTraining);
        model.addAttribute("trainingTime", uniqueTraining.getDate());
        return "new-training";
    }
}
