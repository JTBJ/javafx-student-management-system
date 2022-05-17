package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import com.my.assignment.model.Student;
import com.my.assignment.model.Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML private TextField emailFilter;
    @FXML private TextField nameFilter;

    @FXML private TableView<Student> tableView = new TableView<>();
    @FXML private TableColumn<Student, String> name = new TableColumn<>();
    @FXML private TableColumn<Student, String> email = new TableColumn<>();
    @FXML private TableColumn<Student, String> phone = new TableColumn<>();

    @FXML private Button add;
    @FXML private Button delete;
    @FXML private Button select;
    @FXML private Button slip;

    private Students students;
    private static List<Student> listHelper;

    public static ObservableList<Student> list = FXCollections.observableArrayList(new Students().getCurrentList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.getItems().clear();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableView.setItems(list);
        System.out.println("Is this called each view");
    }

    @FXML
    public void onRowClick() {
        delete.setDisable(false);
        select.setDisable(false);
        slip.setDisable(false);
    }

    @FXML
    public void twoWayBindingNameFilter() {
        emailFilter.setText("");
        students = new Students();

        if(!(nameFilter.getText() == null)) {
            students.filterListByName(nameFilter.getText());
            tableView.setItems(students.getCurrentList());
        }
    }

    @FXML
    public void twoWayBindingEmailFilter() {
        nameFilter.setText("");
        students = new Students();

        if(!(nameFilter.getText() == null)) {
            students.filterListByEmail(emailFilter.getText());
            tableView.setItems(students.getCurrentList());
        }
    }

    @FXML
    public void addStudentToTable() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/addNewStudentAdminController", "Add New Student", 610, 730);
    }

//    @FXML
//    public void validateAndAddNewStudent() throws IOException {
//        validator = new Validator();
//
//        if(validator.isValid(studentName.getText(), studentEmail.getText(), studentPhone.getText(),
//                studentAddress.getText(), studentTuitionType.getText(), studentId.getText(),
//                Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()))) {
//
//            students.getCurrentList().add(new Student(studentName.getText(), studentEmail.getText(),
//                    studentPhone.getText(), studentAddress.getText(), studentId.getText(), studentTuitionType.getText(),
//                    Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()), studentDeduction.getText()));
//
//            tableView.setItems(students.getCurrentList());
//            System.out.println("Valid");
//            App.changeRoot("/com/my/assignment/assignment2/view/adminController", "Admin", 600, 400);
//        }else {
//            validator.generateErrors(studentName.getText(), studentEmail.getText(), studentPhone.getText(),
//                    studentAddress.getText(), studentTuitionType.getText(), studentId.getText(),
//                    Integer.parseInt(studentCredits.getText()), Double.parseDouble(studentScholarship.getText()));
//
//            errorMessage = new StringBuilder();
//            for(String str : validator.errors()){
//                errorMessage.append(str);
//            }
////            App.changeRoot("/com/my/assignment/assignment2/view/errorPage", "Admin", 600, 400);
//            App.changeRoot("/com/my/assignment/assignment2/view/errorPage", "Error Page", 630, 430);
////            new ErrorController().updateErrorMessage(errorMessage);
////            errorLabel.setText(errorMessage.toString());
////            errorLabel = new Label(errorMessage.toString());
////            System.out.println(errorLabel.getText());
////            App.changeRoot("/com/my/assignment/assignment2/view/errorPage", "Error Page", 630, 430);
//        }
//    }

    @FXML
    public void deleteItemFromTable() {
        list.remove(tableView.getSelectionModel().getSelectedItem());
//        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        tableView.setItems(list);
        delete.setDisable(true);
        select.setDisable(true);
        slip.setDisable(true);
    }

    @FXML
    public void selectCurrentStudent() throws IOException {
        listHelper = new ArrayList<>();
        listHelper.add(tableView.getSelectionModel().getSelectedItem());
//        System.out.println(tableView.getSelectionModel().getSelectedItem());
        App.changeRoot("/com/my/assignment/assignment2/view/updateExistingStudent", "Update Student", 610, 730);
    }

    @FXML
    public void showSlip() throws IOException {
        listHelper = new ArrayList<>();
        listHelper.add(tableView.getSelectionModel().getSelectedItem());
        App.changeRoot("/com/my/assignment/assignment2/view/slips-view", "Admin", 600, 440);
    }

    @FXML
    public void pullReports() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/reports-view", "Admin", 615, 655);
    }

    @FXML
    public void close() throws IOException {
        App.setRoot("/com/my/assignment/assignment2/view/login-view", "Login");
    }

    public AdminController getCurrentInstance() {
        return this;
    }

    public TableView<Student> getTableView() {
        return this.tableView;
    }

    public ObservableList<Student> getList() {
        return list;
    }

    public List<Student> getListHelper() {
        return listHelper;
    }
}
