/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _javafxfirst;


import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;


/**
 *
 * @author ulalu
 */
public class _JavaFxFirstMenu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("menu");
        BorderPane root=new BorderPane();
        
        Scene scene= new Scene(root, 300, 200,Color.BLUE);
        
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
