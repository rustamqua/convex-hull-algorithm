package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.crypto.Cipher;


public class fx extends Application {
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            convexHull test = new convexHull(200,600);
            Color color = Color.rgb(255,0,255);
            for(Point y:test.points){
                Circle circle = new Circle(y.x,y.y,3);
                if(test.conv.contains(y)){
                    circle.setFill(color);
                }
                root.getChildren().add(circle);
            }
            Scene scene = new Scene(root,200,200);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
