module com.example.schoolsimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens assets.textures;

    opens com.example.schoolsimulator to javafx.fxml;
    exports com.example.schoolsimulator;

    opens com.example.schoolsimulator.controllers to javafx.fxml;
    exports com.example.schoolsimulator.controllers;

    opens com.example.schoolsimulator.factories to javafx.fxml;
    exports com.example.schoolsimulator.factories;
}