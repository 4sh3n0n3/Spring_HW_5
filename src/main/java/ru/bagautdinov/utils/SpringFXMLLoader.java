package ru.bagautdinov.utils;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.bagautdinov.beans.base.controllers.Controller;
import ru.bagautdinov.config.AppConfig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class SpringFXMLLoader {

    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);

    public static Controller load(String url) {
        InputStream fxmlStream = null;
        try {
            fxmlStream = SpringFXMLLoader.class.getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(APPLICATION_CONTEXT::getBean);

            Node view = (Node) loader.load(fxmlStream);
            Controller controller = loader.getController();
            controller.setView(view);

            return controller;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}