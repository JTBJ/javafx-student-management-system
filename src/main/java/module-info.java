module com.my.assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.my.assignment.assignment2 to javafx.fxml;
    exports com.my.assignment.assignment2;
    exports com.my.assignment.controllers;
    exports com.my.assignment.model;
    exports com.my.assignment.controllers.admin;
    opens com.my.assignment.controllers.admin to javafx.fxml;
    opens com.my.assignment.controllers to javafx.fxml;
    opens com.my.assignment.assignment2.view to javafx.fxml;
}