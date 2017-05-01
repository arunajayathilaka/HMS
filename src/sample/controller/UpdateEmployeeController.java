/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sample.model.Employee;
import sample.model.EmployeeDAO;

/**
 * FXML Controller class
 *
 * @author aruna
 */
public class UpdateEmployeeController implements Initializable {

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
    
    public Employee emp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emp =ViewController.getEmp();
        
        maleRadio.setToggleGroup(group);  
        femaleRadio.setToggleGroup(group);
        designationTxt.setItems(FXCollections.observableArrayList("Doctor", "Nurse","Attendent", "C"));
        
        empIdTxt.setText(Integer.toString(emp.getEmpId()));
        firstNameTxt.setText(emp.getFirstName());
        lastNameTxt.setText(emp.getLastName());
        nicNumberTxt.setText(emp.getNic_Number());
        address1Txt.setText(emp.getAddress1());
        address2Txt.setText(emp.getAddress2());
        address3Txt.setText(emp.getAddress3());
        phoneNumberTxt.setText(emp.getContactNumber());
        designationTxt.setValue(emp.getDesignation());
        if(emp.getSex() =="male"){
            group.selectToggle(maleRadio);
        }
        group.selectToggle(femaleRadio);
       salaryTxt.setText(emp.getSalary());
        
        
        
    }    
    
   
    
    @FXML
    private void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        System.out.println("update");
        RadioButton rb = (RadioButton) group.getSelectedToggle() ;
       
        if(!firstNameTxt.getText().equals(emp.getFirstName())){
            System.out.println("firtname");
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"FirstName",firstNameTxt.getText());
        }
        if(!lastNameTxt.getText().equals(emp.getLastName())){
            System.out.println("lastname");
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"LastName",lastNameTxt.getText());
        }
        
        if(!rb.getText().equals(emp.getSex())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Sex",rb.getText());
        }
        if(!nicNumberTxt.getText().equals(emp.getNic_Number())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"NIC_Number",nicNumberTxt.getText());
        }
        if(!address1Txt.getText().equals(emp.getAddress1())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address1",address1Txt.getText());
        }
        if(!address2Txt.getText().equals(emp.getAddress2())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address2",address2Txt.getText());
        }
        if(!address3Txt.getText().equals(emp.getAddress3())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Address3",address3Txt.getText());
        }
        if(!phoneNumberTxt.getText().equals(emp.getContactNumber())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"ContactNumber",phoneNumberTxt.getText());
        }
        if(!designationTxt.getSelectionModel().getSelectedItem().equals(emp.getDesignation())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Designation",designationTxt.getSelectionModel().getSelectedItem());
        }
        if(!salaryTxt.getText().equals(emp.getSalary())){
            EmployeeDAO.updateEmp(Integer.toString(emp.getEmpId()),"Salary",salaryTxt.getText());
        }
    }

    @FXML
    private void cancelEmp(ActionEvent event) {
       ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                EmployeeDAO.deleteEmpWithId(Integer.toString(emp.getEmpId()));
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UpdateEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

      
}
