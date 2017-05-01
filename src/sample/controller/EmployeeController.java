/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.Employee;

/**
 * FXML Controller class
 *
 * @author aruna
 */
public class EmployeeController implements Initializable {

    @FXML
    private TextField empIdText;
    @FXML
    private Button searchEmpBtn;
    @FXML
    private Button deleteEmpBtn;
    @FXML
    private Button updateEmpBtn;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newEmailText;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee,String> EmpIdColumn;
    @FXML
    private TableColumn<Employee,String> FirstNameColumn;
    @FXML
    private TableColumn<Employee,String> LastNameColumn;
    @FXML
    private TableColumn<Employee,String> SexColumn;
    @FXML
    private TableColumn<Employee,String> NIC_NumberColumn;
    @FXML
    private TableColumn<Employee,String> Address1Column;
    @FXML
    private TableColumn<Employee,String> Address2Column;
    @FXML
    private TableColumn<Employee,String> Address3Column;
    @FXML
    private TableColumn<Employee,String> ContactNumberColumn;
    @FXML
    private Button searchEmpsBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* EmpIdColumn.setCellValueFactory(cellData -> cellData.getValue().EmpIdProperty());
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        SexColumn.setCellValueFactory(cellData -> cellData.getValue().SexProperty());
        Address1Column.setCellValueFactory(cellData -> cellData.getValue().Address1Property());
        Address2Column.setCellValueFactory(cellData -> cellData.getValue().Address2Property());
        Address3Column.setCellValueFactory(cellData -> cellData.getValue().Address3Property());
        ContactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().ContactNumberProperty());
*/
    }    

    @FXML
    private void searchEmployee(ActionEvent event) {
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
    }

    @FXML
    private void updateEmployeeEmail(ActionEvent event) {
    }

    @FXML
    private void searchEmployees(ActionEvent event) {
    }
    
}
