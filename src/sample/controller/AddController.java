/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sample.model.EmployeeDAO;

/**
 * FXML Controller class
 *
 * @author aruna
 */
public class AddController implements Initializable {

    @FXML
    private RadioButton maleRadio;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private ChoiceBox<String> designationTxt;
    @FXML
    private TextField empIdTxt;
    @FXML
    private TextField firstNameTxt;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private TextField nicNumberTxt;
    @FXML
    private TextField address1Txt;
    @FXML
    private TextField address2Txt;
    @FXML
    private TextField address3Txt;
    @FXML
    private TextField phoneNumberTxt;
    @FXML
    private TextField salaryTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         maleRadio.setToggleGroup(group);
         maleRadio.setSelected(true);
        
        femaleRadio.setToggleGroup(group);
        designationTxt.setItems(FXCollections.observableArrayList("Doctor", "Nurse","Attendent", "C"));
    }    

    @FXML
    private void addEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        RadioButton rb = (RadioButton) group.getSelectedToggle() ;
        
         int r=EmployeeDAO.insertEmp(empIdTxt.getText(),firstNameTxt.getText(),lastNameTxt.getText(),rb.getText(),nicNumberTxt.getText(),address1Txt.getText(),address2Txt.getText(),address3Txt.getText(),phoneNumberTxt.getText(),designationTxt.getSelectionModel()
                .getSelectedItem());
        if(r==0){
            System.out.println("insert kare ne");
        }
        else{
            System.out.println("insert kara");
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
