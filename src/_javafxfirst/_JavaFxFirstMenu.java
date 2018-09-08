/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javafxfirst;


import javafx.collections.ObservableList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


/**
 *
 * @author ulalu
 */
public class _JavaFxFirstMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("menu");
        BorderPane root=new BorderPane();
        
        Scene scene= new Scene(root, 500, 350);
    
scene.setFill(Color.BLANCHEDALMOND);
root.setBackground(Background.EMPTY);


        ///background color???
        
        //new function
        GridPane grid= new GridPane();
        grid.setPadding(new Insets(10));
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPrefHeight(Double.MAX_VALUE);
        ColumnConstraints col1= new ColumnConstraints(150,150,Double.MAX_VALUE);
        ColumnConstraints col2= new ColumnConstraints(50);
        ColumnConstraints col3=new ColumnConstraints(150,150,Double.MAX_VALUE);
        col1.setHgrow(Priority.ALWAYS);
        col3.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2, col3);
        
        Label cand = new Label("Candidate");
        GridPane.setHalignment(cand, HPos.CENTER);
        grid.add(cand,0,0);
        
        Label okregi= new Label("confirmed");
        grid.add(okregi,2,0);
        GridPane.setHalignment(okregi, HPos.CENTER);
        
        ObservableList<String> candidates= FXCollections.observableArrayList("anna kowalska", "jerzy lusowski", "pola negri", "paulina koss", "nadiezna slakowsky");
        ListView<String> candlist= new ListView<>(candidates);
        grid.add(candlist, 0, 1);
        
        ObservableList<String> okregiName= FXCollections.observableArrayList();
        ListView<String> okregilist= new ListView(okregiName);
        grid.add(okregilist, 2, 1);
        
        Button rb= new Button(">");
        rb.setOnAction((ActionEvent event)->{
            String potential= candlist.getSelectionModel().getSelectedItem();
            if (potential != null){
                candlist.getSelectionModel().clearSelection();
                candidates.remove(potential);
                okregiName.add(potential);
                }    
        });
        
        Button lb= new Button ("<");
        lb.setOnAction((ActionEvent event)-> {
            String notokreg= okregilist.getSelectionModel().getSelectedItem();
            if(notokreg!=null){
                okregilist.getSelectionModel().clearSelection();;
            okregiName.remove(notokreg);
            candidates.add(notokreg);
            }
        });
        
        VBox vb= new VBox(5);
        vb.getChildren().addAll(rb,lb);
        vb.setAlignment(Pos.CENTER);
        grid.add(vb, 1,1);
        
        root.setCenter(grid);
        
        GridPane.setVgrow(root,Priority.ALWAYS);
        
        
      
        MenuBar menub= new MenuBar();
        root.setTop(menub);
        
        Menu filemenu = new Menu("file");
        
        MenuItem newmitem=new MenuItem("new");
        MenuItem savemenu=new MenuItem("save");
        //skrot  ctrl + s do save
        savemenu.setMnemonicParsing(true);
        savemenu.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
        MenuItem exitmenu=new MenuItem("exit");
        
        exitmenu.setOnAction(actionEvent-> Platform.exit());
        
        filemenu.getItems().addAll(newmitem, savemenu, new SeparatorMenuItem(), exitmenu);
        
        Menu cameram = new Menu("Camera");
        
        CheckMenuItem cam1menuItem = new CheckMenuItem("Show camera1");
        cam1menuItem.setSelected(true);
        
        cameram.getItems().add(cam1menuItem);
        
        CheckMenuItem cam2menu = new CheckMenuItem("show camera 2");
        cam2menu.setSelected(true);
         
        cameram.getItems().add(cam2menu);
        
        Menu alarm=new Menu("alarm");
        
        ToggleGroup tgroup= new ToggleGroup();
        RadioMenuItem sounditem= new RadioMenuItem("sound");
        
        sounditem.setToggleGroup(tgroup);
        
        RadioMenuItem stopalarm= new RadioMenuItem("alarm off");
        
        stopalarm.setToggleGroup(tgroup);
        stopalarm.setSelected(true);
        
        alarm.getItems().addAll(sounditem, stopalarm, new SeparatorMenuItem());
        
        Menu conti= new Menu("Contigency plan");
        conti.getItems().addAll(
        new CheckMenuItem("self destruct"),
        new CheckMenuItem("turn off"),
        new CheckMenuItem("run for your lives"));
        
        alarm.getItems().add(conti);
         menub.getMenus().addAll(filemenu, cameram, alarm);
         
         
       MenuItem exitItem = createMenuItem("E_xit",
                new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN),
                (actionEvent) -> {
                    
                    Platform.exit();
                });

       

      MenuItem contextExitItem = createMenuItem("E_xit", exitItem.getAccelerator(), exitItem.getOnAction());

        ContextMenu contextFileMenu = new ContextMenu();
        contextFileMenu.getItems().addAll(
                new SeparatorMenuItem(), contextExitItem);
        
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me)-> {
            if (me.getButton()== MouseButton.SECONDARY || me.isControlDown()){
                contextFileMenu.show(root, me.getScreenX(), me.getScreenY());
            } else{
                contextFileMenu.hide();
            }
        });
        
       
        
         primaryStage.setScene(scene);
        primaryStage.show();
    }
    private MenuItem createMenuItem(String name,
                                    KeyCombination keyCombination,
                                    EventHandler<ActionEvent> handler) {

        MenuItem menuItem = new MenuItem(name);
        menuItem.setMnemonicParsing(true);
        menuItem.setAccelerator(keyCombination);
        menuItem.setOnAction(handler);

        return menuItem;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
