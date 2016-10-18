/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The Game
 */
public class PresetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Button preset_cancel_btn;
    public Button preset_ok_btn;
    public Button preset_save_btn;
    public Button preset_delete_btn;
    
    public TextField profile_name;
    
    
    public ComboBox<String> encoder;
    public ComboBox<String> resolution;
    public ComboBox<String> vb;
    public ComboBox<String> fr;
    public ComboBox<String> ar;
    public ComboBox<String> aencoder;
    public ComboBox<String> channel;
    public ComboBox<String> sr;
    public ComboBox<String> ab;
    
    
    ObservableList<String> encoderList = FXCollections.observableArrayList("H.264 (Intel QSV)","MPEG-4","MPEG-2","H.265 (x265)");
    ObservableList<String> resolutionList = FXCollections.observableArrayList("640x480","1280x720","1920x1080");
    ObservableList<String> vbList = FXCollections.observableArrayList("250 kb","512 kb","1200 kb","1500 kb","2000 kb");
    ObservableList<String> frList = FXCollections.observableArrayList("5","10","12","15","23.976","24","25","30","50","60");
    ObservableList<String> arList = FXCollections.observableArrayList("4:3","16:9");
    ObservableList<String> aencoderList = FXCollections.observableArrayList("A3C");
    ObservableList<String> channelList = FXCollections.observableArrayList("2.1 channel","5.1 channel","7.1 channel");
    ObservableList<String> srList = FXCollections.observableArrayList("32000 Hz","41400 Hz","48000Hz");
    ObservableList<String> abList = FXCollections.observableArrayList("40 kbps","48 kbps","56 kbps","80 kbps","96 kbps","128 kbps");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        encoder.setItems(encoderList);
        resolution.setItems(resolutionList);
        vb.setItems(vbList);
        fr.setItems(frList);
        ar.setItems(arList);
        aencoder.setItems(aencoderList);
        channel.setItems(channelList);
        sr.setItems(srList);
        ab.setItems(abList);
    }  
    
    @FXML
    public void presetCancelButton(ActionEvent event) {        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage stage = (Stage) preset_cancel_btn.getScene().getWindow();
            stage.close();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    public void presetOkButton(ActionEvent event) {        
        Stage stage = (Stage) preset_ok_btn.getScene().getWindow();
        stage.close();
    }
    
    public void presetSaveButton(ActionEvent event) {        
        if(profile_name.getText().length() != 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You have succesfully save a preset!");

            alert.showAndWait();

            Stage stage = (Stage) preset_save_btn.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("You need to a enter a preset name");

            alert.showAndWait();
        }
    }
    
    public void presetDeleteButton(ActionEvent event) {        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Do you want to delete this preset?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage stage = (Stage) preset_delete_btn.getScene().getWindow();
        stage.close();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
}
