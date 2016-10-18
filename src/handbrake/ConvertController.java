/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        Stage stage = (Stage) progress_stp_btn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void progressPauseButton(ActionEvent event) {
        t.interrupt();
    }

}
    