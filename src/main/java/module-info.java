module com.mariangel.lab3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mariangel.lab3 to javafx.fxml;
    exports com.mariangel.lab3;
}
