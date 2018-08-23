/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingLinesExample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ulalu
 */
public class DrawingLines extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
         primaryStage.setTitle("Rysuj linie");
         
         Group root = new Group();
         Scene scene = new Scene(root, 300, 200, Color.TURQUOISE);
         
         Line vline = new Line(10,10,200,10);
         
         vline.setStroke(Color.VIOLET);
         vline.setStrokeWidth(15);
         vline.setStrokeLineCap(StrokeLineCap.BUTT);
         
         vline.getStrokeDashArray().addAll(10d, 5d,15d,20d);
         vline.setStrokeDashOffset(0);
         
         root.getChildren().add(vline);
         
         Line white= new Line(10,30,200,30);
          white.setStroke(Color.WHITE);
         white.setStrokeWidth(15);
        white.setStrokeLineCap(StrokeLineCap.ROUND);
         
      white.getStrokeDashArray().addAll(10d, 5d,15d,20d);
        white.setStrokeDashOffset(0);
         
                 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
