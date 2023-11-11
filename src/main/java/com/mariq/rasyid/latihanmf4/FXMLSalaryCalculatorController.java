package com.mariq.rasyid.latihanmf4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLSalaryCalculatorController implements Initializable {

    @FXML
    private TabPane salarycalculator;
    @FXML
    private TextField txt_name;
    @FXML
    private ComboBox<?> chb_rank;
    @FXML
    private TextField txtday;
    @FXML
    private Button calculate_btn;
    @FXML
    private Button btn_reset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculate_click(ActionEvent event) {
    }

    @FXML
    private void reset_click(ActionEvent event) {
    }
    
}
