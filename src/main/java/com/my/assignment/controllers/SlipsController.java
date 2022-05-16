package com.my.assignment.controllers;

import com.my.assignment.assignment2.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SlipsController implements Initializable {

    @FXML private Label creditsLbl;
    @FXML private Label tfLbl;
    @FXML private Label nfLbl;
    @FXML private Label ppcLbl;
    @FXML private Label scholoshipLbl;
    @FXML private Label deductionLbl;

    @FXML private Button btn;

    private final AdminController adminController = new AdminController().getCurrentInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        creditsLbl.setText(Integer.toString(adminController.getListHelper().get(0).getCredits()));
        tfLbl.setText(Double.toString(adminController.getListHelper().get(0).getTotalFee()));
        nfLbl.setText(Double.toString(adminController.getListHelper().get(0).getNetFee()));
        ppcLbl.setText(Double.toString(adminController.getListHelper().get(0).getPayPerCredit()));
        scholoshipLbl.setText(Double.toString(adminController.getListHelper().get(0).getScholarship()));
        deductionLbl.setText(Double.toString(adminController.getListHelper().get(0).getDeduction()));
    }

    @FXML
    public void backToAdminView() throws IOException {
        App.changeRoot("/com/my/assignment/assignment2/view/adminController", "Admin", 615, 440);
    }
}
