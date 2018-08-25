/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingLinesExample;

import javafx.application.Application;

import javafx.scene.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.text.Font;

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
         Scene scene = new Scene(root, 500, 600, Color.TURQUOISE);
         
         Line vline = new Line(10,10,500,10);
         
         vline.setStroke(Color.VIOLET);
         vline.setStrokeWidth(15);
         vline.setStrokeLineCap(StrokeLineCap.BUTT);
         
         vline.getStrokeDashArray().addAll(10d, 5d,15d,20d);
         vline.setStrokeDashOffset(0);
         
         root.getChildren().add(vline);
         
         Line white= new Line(10,30,500,30);
         
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
        
        Text offsettext= new Text("votes NO FOX fur PROTEST "+ slider.getValue());
        offsettext.setX(15);
        offsettext.setY(300);
        offsettext.setStrokeWidth(2);
        Font ft=Font.font("arial",25);
           offsettext.setFont(ft);
        offsettext.setStroke(Color.PLUM);
        
        slider.valueProperty().addListener((ov, curVal, newVal)-> {
            offsettext.setText("votes NO FOX fur PROTEST "+ newVal);
         });
        
        root.getChildren().add(offsettext);
        // SHAPES
        Path path= new Path();
        path.setStrokeWidth(3);
        
        MoveTo moveto= new MoveTo();
        moveto.setX(170);
        moveto.setY(380);
        
        QuadCurveTo quadcurve = new QuadCurveTo();
        quadcurve.setX(280);
        quadcurve.setY(380);
        quadcurve.setControlX(225);
        quadcurve.setControlY(520);
        
        LineTo line1= new LineTo();
        line1.setX(280);
        line1.setY(380);
        
        LineTo line2= new LineTo();
        line2.setX(260);
        line2.setY(340);
        
         LineTo line3= new LineTo();
        line3.setX(225);
        line3.setY(380);
        
         LineTo line4= new LineTo();
        line4.setX(190);
        line4.setY(340);
        
         LineTo line5= new LineTo();
        line5.setX(170);
        line5.setY(380);
        
         LineTo line6= new LineTo();
        line6.setX(280);
        line6.setY(380);
        
        path.getElements().addAll(moveto, quadcurve, line1, line2, line3,line4,line5,line6);
        
        path.setTranslateY(30);
        
        path.setStroke(Color.AZURE);
        path.setFill(Color.CORAL);
        
       
       root.getChildren().add(path);
        //RAND TEXT 
       
       Random rand = new Random (System.currentTimeMillis());
       for(int i=0; i<20;i++) {
           int x=rand.nextInt((int)400);
           int y= rand.nextInt((int)500);
           
           
           Text text = new Text(x,y,"lucky one ANIMAL RIGHTS movement");
           Font font=Font.font("serif",20);
           text.setFont(font);
           
           int rot= rand.nextInt(40);
           text.setFill(Color.ANTIQUEWHITE);
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
