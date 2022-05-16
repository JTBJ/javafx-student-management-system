package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import com.my.assignment.model.Faculties;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Label invalidCredentialLabel;

    private Faculties faculties;

    @FXML
    public void validateAndLogin() throws IOException {
        faculties = new Faculties();

        if(faculties.hasFaculty(txtFieldUserName.getText(), txtFieldPassword.getText())) {
            App.setRoot("/com/my/assignment/assignment2/view/adminController", "Admin");
        }else if(txtFieldUserName.getText().equals("admin") && txtFieldPassword.getText().equals("password")) {
            App.setRoot("/com/my/assignment/assignment2/view/adminController", "Admin");
        }else {
            invalidCredentialLabel.setText("Invalid Login Credentials");
            invalidCredentialLabel.setDisable(false);
        }
    }

    @FXML
    public void backToMain() throws IOException {
        App.setRoot("/com/my/assignment/assignment2/view/hello-view", "TMSFX - Faculty Mode");
    }
}
