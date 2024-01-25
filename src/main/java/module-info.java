module com.mycompany.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.employeemanagementsystem to javafx.fxml;
    exports com.mycompany.employeemanagementsystem;
}
