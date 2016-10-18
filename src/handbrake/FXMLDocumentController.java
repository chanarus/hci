/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author The Game
 * Time to play the game
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Label label;
    public Label source_name_label;
    public Label source_format_label;
    public TextField destination_txt;
    public MediaView mv;
    public MediaPlayer mp;
    public Media me;
    public BorderPane bp;
    public ComboBox<String> profile_combo;
    public ComboBox<String> anamorphic;
    public ComboBox<String> modulus;
    public ComboBox<String> codec;
    public ComboBox<String> fps;
        
    String filename;
    String filedetails;
    
    ObservableList<String> profileList = FXCollections.observableArrayList("flv","mkv");
    ObservableList<String> anamorphicList = FXCollections.observableArrayList("None","Strict","Custom");
    ObservableList<String> modulusList = FXCollections.observableArrayList("16","8","4","2");
    ObservableList<String> codecList = FXCollections.observableArrayList("H.264 (Intel QSV)","MPEG-4","MPEG-2","H.265 (x265)");
    ObservableList<String> fpsList = FXCollections.observableArrayList("5","10","12","15","23.976","24","25","30","50","60");
    
    public void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    public void cutButtonAction(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cut.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    public void convertButtonAction(ActionEvent event) {
        try {
            if (source_name_label.getText().length() != 0) {
                if(destination_txt.getText().length() != 0) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("convert.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));  
                stage.show();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("You need to set an output folder");

                alert.showAndWait();
            }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("You need to add a video");

                alert.showAndWait();
            }
        
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    public void addPresetButtonAction(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("preset.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    /*
    *Add a new source to the system
    */
    @FXML
    public void addSourceButtonAction(ActionEvent event) {
        try {
            
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            
            if (selectedFile != null) {
                filename = selectedFile.getName().toString();
                filedetails = filename.substring(filename.lastIndexOf(".") + 1);
                
                source_name_label.setText(filename.substring(0,filename.lastIndexOf('.')));
                source_format_label.setText(filedetails);            
                
                String path = selectedFile.getAbsolutePath();
                me = new Media(new File(path).toURI().toString());
                mp = new MediaPlayer(me);
                mv.setMediaPlayer(mp);
                //mp.setAutoPlay(true);
                
//                DoubleProperty width = mv.fitWidthProperty();
//                DoubleProperty height = mv.fitHeightProperty();
//                
//                width.bind(Bindings.selectDouble(bp.sceneProperty(), "width"));
//                height.bind(Bindings.selectDouble(bp.sceneProperty(), "height"));
            }
            else {
                source_name_label.setText("File selection cancelled.");
            }
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    public void play(ActionEvent event) {
        mp.play();
    }
    
    public void pause(ActionEvent event) {
        mp.pause();
    }
    
    public void stop(ActionEvent event) {
        mp.stop();
    }
    
    public void browseOutputButtonAction(ActionEvent event) {
        try {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("JavaFX Projects");
            File defaultDirectory = new File("C:\\");
            chooser.setInitialDirectory(defaultDirectory);
            File selectedDirectory = chooser.showDialog(null);
            
            if (selectedDirectory != null) {
                 destination_txt.setText(selectedDirectory.getAbsolutePath());
            }
            
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    public void openOutputButtonAction(ActionEvent event) {
        try {
            if(destination_txt.getText().length() != 0) {
                FileChooser fileChooser = new FileChooser();
            
                String userDirectoryString = destination_txt.getText();
                File userDirectory = new File(userDirectoryString);
                fileChooser.setInitialDirectory(userDirectory);
                File selectedFile = fileChooser.showOpenDialog(null);
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("You need to set an output folder");

                alert.showAndWait();
            }
            
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profile_combo.setItems(profileList);
        anamorphic.setItems(anamorphicList);
        modulus.setItems(modulusList);
        codec.setItems(codecList);
        fps.setItems(fpsList);
    }    
    
}
