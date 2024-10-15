package org.mycarenet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        SessionHandler sessionHandler = new SessionHandler();
        EHealthApiInvoker serviceInvoker = new EHealthApiInvoker();

        // Button to create session
        
        Button createSessionButton = new Button("Create Session");
        createSessionButton.setOnAction(e -> sessionHandler.setupSession());

        // Button to unload session
        Button unloadSessionButton = new Button("Unload Session");
        unloadSessionButton.setOnAction(e -> sessionHandler.unloadSession());

        // Button to invoke business service
        Button invokeServiceButton = new Button("Invoke Service");
        invokeServiceButton.setOnAction(e -> serviceInvoker.invokeService());

        VBox vbox = new VBox(10, createSessionButton, invokeServiceButton, unloadSessionButton);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setTitle("eHealth Connector UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("app started");
        log.info("app started");
        launch(args);
    }
}