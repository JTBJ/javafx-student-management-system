package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import com.my.assignment.controllers.admin.AddNewStudentAdminController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable {

    @FXML public Label errorLabel = new Label();
    @FXML private Button btn;

    @FXML
    public void backToAddStudent() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/addNewStudentAdminController", "Add New Student", 610, 730);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setText(AddNewStudentAdminController.errorMessage.toString());
        System.out.println(AddNewStudentAdminController.errorMessage.toString());
    }
}
