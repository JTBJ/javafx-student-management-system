package com.my.assignment.controllers.admin;

import com.my.assignment.assignment2.App;
import com.my.assignment.controllers.AdminController;
import com.my.assignment.controllers.Validator;
import com.my.assignment.model.Student;
import com.my.assignment.model.Students;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewStudentAdminController implements Initializable {

    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
    @FXML
    private TextField studentPhone;
    @FXML
    private TextField studentAddress;
    @FXML
    private TextField studentId;
    @FXML
    private TextField studentTuitionType;
    @FXML
    private TextField studentCredits;
    @FXML
    private TextField studentScholarship;
    @FXML
    private TextField studentDeduction;
    @FXML
    private Button addStudentBtn = new Button();
    @FXML
    private Button updateBtn = new Button();
    @FXML
    private Button closeBtn = new Button();

    private final AdminController adminController = new AdminController().getCurrentInstance();
    private Students students;
//    private Validator validator;

    public static StringBuilder errorMessage;

    @FXML
    public void validateAndAddNewStudent() throws IOException {
        Validator validator = new Validator();

        if(validator.isValid(studentName.getText(), studentEmail.getText(), studentPhone.getText(),
                studentAddress.getText(), studentTuitionType.getText(), studentId.getText(),
                Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()))) {

            adminController.getList().add(new Student(studentName.getText(), studentEmail.getText(),
                    studentPhone.getText(), studentAddress.getText(), studentId.getText(), studentTuitionType.getText(),
                    Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()), studentDeduction.getText()));

//            students.getCurrentList().add(new Student(studentName.getText(), studentEmail.getText(),
//                    studentPhone.getText(), studentAddress.getText(), studentId.getText(), studentTuitionType.getText(),
//                    Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()), studentDeduction.getText()));

            adminController.getTableView().setItems(adminController.getList());
            System.out.println("Valid");
            App.changeRoot("/com/my/assignment/assignment2/view/adminController", "Admin", 615, 440);
        }else {
            System.out.println("Invalid");
            validator.generateErrors(studentName.getText(), studentEmail.getText(), studentPhone.getText(),
                    studentAddress.getText(), studentTuitionType.getText(), studentId.getText(),
                    Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()));

            errorMessage = new StringBuilder();
            for(String str : validator.errors()){
                errorMessage.append(str);
            }
            App.changeRoot("/com/my/assignment/assignment2/view/errorPage", "Error Page", 630, 430);
        }
    }

    @FXML
    public void backToAdminView() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/adminController", "Admin", 615, 440);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateBtn.setDisable(true);
    }
}
