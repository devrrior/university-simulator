package com.example.schoolsimulator;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;

public class SchoolSimulatorApplication extends GameApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(450);
        gameSettings.setTitle("School Simulator");
        gameSettings.setVersion("0.1");
    }

    @Override
    protected void initGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("simulator-view.fxml"));
            AnchorPane root = loader.load();
            FXGL.getGameScene().addUINode(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getGameScene().setBackgroundRepeat("background.jpg");
    }
}