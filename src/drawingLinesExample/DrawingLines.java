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
         Scene scene = new Scene(root, 400, 300, Color.TURQUOISE);
         
         Line vline = new Line(10,10,400,10);
         
         vline.setStroke(Color.VIOLET);
         vline.setStrokeWidth(15);
         vline.setStrokeLineCap(StrokeLineCap.BUTT);
         
         vline.getStrokeDashArray().addAll(10d, 5d,15d,20d);
         vline.setStrokeDashOffset(0);
         
         root.getChildren().add(vline);
         
         Line white= new Line(10,30,400,30);
         
          white.setStroke(Color.WHITE);
         white.setStrokeWidth(15);
        white.setStrokeLineCap(StrokeLineCap.ROUND);
         
      white.getStrokeDashArray().addAll(10d, 5d,15d,20d);
        white.setStrokeDashOffset(0);
         
        root.getChildren().add(white);
        
        Slider slider= new Slider(0,100,0);
        slider.setLayoutX(150);
        slider.setLayoutY(100);
        
        // BEANS BINDS >
        
        vline.strokeDashOffsetProperty().bind(slider.valueProperty());
        
        root.getChildren().add(slider);
        
        Text offsettext= new Text("Stroke dash "+ slider.getValue());
        offsettext.setX(15);
        offsettext.setY(80);
        offsettext.setStroke(Color.PLUM);
        
        slider.valueProperty().addListener((ov, curVal, newVal)-> offsettext.setText("Stroke dash 2"+ newVal));
        
        root.getChildren().add(offsettext);
        
        
                 
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
