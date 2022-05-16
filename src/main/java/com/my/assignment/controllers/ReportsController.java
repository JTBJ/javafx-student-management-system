package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import com.my.assignment.model.Student;
import com.my.assignment.model.Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    @FXML
    private TableView<Student> tableView = new TableView<>();
    @FXML
    private TableColumn<Student, String> name = new TableColumn<>();
    @FXML
    private TableColumn<Student, Double> totalFee = new TableColumn<>();
    @FXML
    private TableColumn<Student, Double> scholarship = new TableColumn<>();
    @FXML
    private TableColumn<Student, Double> deduction = new TableColumn<>();
    @FXML
    private TableColumn<Student, Double> netFee = new TableColumn<>();

    @FXML
    private Label totalFeeLbl;

    @FXML
    private Label scholarshipLbl;

    @FXML
    private Label netFeeLbl;

    @FXML
    private Label deductionsLbl;

    @FXML
    private Label basLbl;

    public ObservableList<Student> list = FXCollections.observableArrayList(new Students().getCurrentList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        totalFee.setCellValueFactory(new PropertyValueFactory<Student, Double>("totalFee"));
        scholarship.setCellValueFactory(new PropertyValueFactory<Student, Double>("scholarship"));
        deduction.setCellValueFactory(new PropertyValueFactory<Student, Double>("deduction"));
        netFee.setCellValueFactory(new PropertyValueFactory<Student, Double>("netFee"));
        tableView.setItems(list);
        initLabels();
    }

    @FXML
    public void close() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/adminController", "Admin", 615, 440);
    }

    public void initLabels() {
        double tuition_total = 0;
        double scholarship_total = 0;
        double deduction_total = 0;
        double net_total = 0;

        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                switch (i) {
                    case 1:
                        tuition_total += Double.parseDouble(tableView.getColumns().get(i).getCellData(j).toString());
                        break;
                    case 2:
                        scholarship_total += Double.parseDouble(tableView.getColumns().get(i).getCellData(j).toString());
                        break;
                    case 3:
                        deduction_total += Double.parseDouble(tableView.getColumns().get(i).getCellData(j).toString());
                        break;
                    case 4:
                        net_total += Double.parseDouble(tableView.getColumns().get(i).getCellData(j).toString());
                        break;
                    default:
                        return;
                }
            }
        }
//        System.out.print("Tuition: " + tuition_total + "\nScholarship: " + scholarship_total + "\nDeduction: " + deduction_total + "\nNet: " + net_total);
        totalFeeLbl.setText(Double.toString(tuition_total));
        scholarshipLbl.setText(Double.toString(scholarship_total));
        deductionsLbl.setText(Double.toString(deduction_total));
        netFeeLbl.setText(Double.toString(net_total));
        basLbl.setText(Double.toString(tuition_total - net_total));
    }
}
