/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author The Game
 */
public class ConvertController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public ProgressBar progerss_bar;
    public Label precentege;
    public Button progress_stp_btn;
    public Thread t = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       progerssBar();         
    }  
    
    
    @FXML
    public void increase() {
    }

    public void progerssBar() {

        t = new Thread(new Runnable() {
            public void run() {
                double p = 0;
                double p1 = 0;

                do {

                    p += 0.05;
                    progerss_bar.setProgress(p);
                    p1 += 0.05;
                    precentege.setText(Double.toString(p1));

                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                      
                    }

                } while (p <= 1);
            }
        });
        
        
        t.start();

        
    }
    
    @FXML
    public void progressStopButton(ActionEvent event) {      
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage stage = (Stage) progress_stp_btn.getScene().getWindow();
            stage.close();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @FXML
    public void progressPauseButton(ActionEvent event) {
        t.interrupt();
    }

}
    