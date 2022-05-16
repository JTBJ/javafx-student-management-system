package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        App.setRoot("/com/my/assignment/assignment2/view/login-view", "Login");
    }

    @FXML
    public void closeApp() {
        System.exit(0);
    }
}