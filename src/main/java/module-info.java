module com.example.tp1_v2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.tp1_v2 to javafx.fxml;
    exports com.example.tp1_v2;
    exports graphe_main;
}