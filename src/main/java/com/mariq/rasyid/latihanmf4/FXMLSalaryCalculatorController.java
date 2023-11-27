package com.mariq.rasyid.latihanmf4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import com.mariq.rasyid.latihanmf4.Model.LatihhanMF4;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLSalaryCalculatorController implements Initializable {

    //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    //Model
    LatihhanMF4 mdl = new LatihhanMF4();

    @FXML
    private TabPane salarycalculator;
    @FXML
    private TextField txt_name;
    @FXML
    private ComboBox<String> chb_rank;
    @FXML
    private TextField txtday;
    @FXML
    private Button calculate_btn;
    @FXML
    private Button btn_reset;
    @FXML
    private Label Name;
    @FXML
    private Label Rank;
    @FXML
    private Label Gajipokok;
    @FXML
    private Label Day;
    @FXML
    private Label Bonus;

    @FXML
    private Label Pajak;
    @FXML
    private Label GajiBersih;
    @FXML
    private Label GajiKotor;
    @FXML
    private Button close_btn;
    @FXML
    private Button back_btn;
    @FXML
    private Tab input;
    @FXML
    private Tab output;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chb_rank.setItems(FXCollections.observableArrayList(
                "--Pilih Jabatan--",
                "Manager",
                "Supervisor",
                "Staff"));
        chb_rank.getSelectionModel().select(0);
        output.setDisable(true);

    }

    @FXML
    private void calculate_click(ActionEvent event) {
        if (txt_name.getText().isBlank()) {
            do {
                TextInputDialog txt = new TextInputDialog();
                txt.setContentText("Masukan Nama Pegawai");
                txt.setTitle("Input Nama Pegawai");
                txt.showAndWait();
                txt_name.setText(txt.getResult());
            } while (txt_name.getText().isBlank());
        } else {
            mdl.setName(txt_name.getText());
            mdl.setDays(Integer.parseInt(txtday.getText()));
            mdl.setRank(chb_rank.getSelectionModel().getSelectedIndex());
            double main_salary = 0, tax = 0, bonus = 0, bonus_cal = 0;
            String rank = null;
            switch (mdl.getRank()) {
                case 1: {
                    rank = "Manager";
                    if (mdl.getDays() > 24) {
                        bonus = 10;
                    } else if (mdl.getDays() > 20) {
                        bonus = 5;
                    } else if (mdl.getDays() > 17) {
                        bonus = 2.5;
                    }
                    main_salary = 2000000;
                    Rank.setText(rank);
                    tax = 0;
                    break;
                }

                case 2:
                    rank = "Supervisor";
                    if (mdl.getDays() > 24) {
                        bonus = 20;
                    } else if (mdl.getDays() > 20) {
                        bonus = 10;
                    } else if (mdl.getDays() > 17) {
                        bonus = 5;
                    }
                    main_salary = 1500000;
                    Rank.setText(rank);
                    tax = 0;
                    break;
                case 3: {
                    rank = "Staff";
                    if (mdl.getDays() > 24) {
                        bonus = 40;
                    } else if (mdl.getDays() > 20) {
                        bonus = 20;
                    } else if (mdl.getDays() > 17) {
                        bonus = 10;
                    }
                    main_salary = 800000;
                    Rank.setText(rank);
                    tax = 0.1;
                    break;
                }
                default: {
                    rank = null;
                    bonus = 0;
                    main_salary = 0;
                    Rank.setText(rank);
                    tax = 0;
                }
            }
            bonus_cal = main_salary * bonus;
            double gross_salary = main_salary + bonus_cal;
            double tax_salary = main_salary * tax;
            double tot_tax_salary = gross_salary - tax_salary;
            Name.setText(mdl.getName());
            Gajipokok.setText(formater.format(main_salary));
            Day.setText(String.valueOf(mdl.getDays()));
            Bonus.setText(formater.format(bonus_cal));
            GajiKotor.setText(formater.format(gross_salary));
            Pajak.setText(formater.format(tax_salary));
            GajiBersih.setText(formater.format(tot_tax_salary));
            salarycalculator.getSelectionModel().select(1);
            input.setDisable(true);
            output.setDisable(false);
        }
    }

    @FXML
    void event(Event ev) {
        if (txt_name.getText().isEmpty() && output.isSelected()) {
            {
                Alert art = new Alert(Alert.AlertType.WARNING, "Data Masih Kosong Mohon Isi Terlebih dahulu", ButtonType.YES);
                art.showAndWait();
                if (art.getResult() == ButtonType.YES) {
                    salarycalculator.getSelectionModel().select(0);
                }
            }
        }
    }

    @FXML
    private void reset_click(ActionEvent event
    ) {
        Alert art = new Alert(Alert.AlertType.CONFIRMATION, "Apakah data ini akan direset ulang", ButtonType.YES, ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            txt_name.setText(null);
            chb_rank.getSelectionModel().select(0);
            txtday.setText(null);
        }
        txt_name.isFocused();
    }

    @FXML
    private void close_click(ActionEvent event
    ) {
        System.exit(0);
    }

    @FXML
    private void back_click(ActionEvent event
    ) {
        Name.setText("Label");
        Rank.setText("Label");
        Gajipokok.setText("Label");
        Day.setText("Label");
        Bonus.setText("Label");
        Pajak.setText("Label");
        GajiBersih.setText("Label");
        GajiKotor.setText("Label");
        txt_name.setText(null);
        chb_rank.getSelectionModel().select(0);
        txtday.setText(null);
        salarycalculator.getSelectionModel().select(0);
        input.setDisable(false);
        output.setDisable(true);

    }

}
