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
import javafx.scene.shape.Arc;

import java.util.Random;
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
        
        slider.valueProperty().addListener((ov, curVal, newVal)-> {
            offsettext.setText("Stroke dash 2"+ newVal);
         });
        
        root.getChildren().add(offsettext);
        // SHAPES
        Path path= new Path();
        path.setStrokeWidth(3);
        
        MoveTo moveto= new MoveTo();
        moveto.setX(100);
        moveto.setY(50);
        
        QuadCurveTo quadcurve = new QuadCurveTo();
        quadcurve.setX(150);
        quadcurve.setY(150);
        quadcurve.setControlX(100);
        quadcurve.setControlY(50);
        
        LineTo linel= new LineTo();
        linel.setX(200);
        linel.setY(100);
        
        LineTo linep= new LineTo();
        linep.setX(100);
        linep.setY(150);
        
        path.getElements().addAll(moveto, quadcurve, linel, linep);
        
        path.setTranslateY(30);
        
        path.setStroke(Color.AZURE);
        path.setFill(Color.AQUA);
        
       
       root.getChildren().add(path);
        //RAND TEXT 
       
       Random rand = new Random (System.currentTimeMillis());
       for(int i=0; i<100;i++) {
           int x=rand.nextInt((int)300);
           int y= rand.nextInt((int)250);
           int blue=rand.nextInt(255);
           
           Text text = new Text(x,y,"Ice ice");
           
           int rot= rand.nextInt(360);
           text.setFill(Color.BISQUE);
           text.setRotate(rot);
           
           root.getChildren().add(text);
                   
       }
        
        
        
        
        
        
                 
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
