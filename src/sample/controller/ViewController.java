/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.model.Employee;
import sample.model.EmployeeDAO;

/**
 * FXML Controller class
 *
 * @author aruna
 */
public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField empIdText;
    
    @FXML
    private TextField NicNText;
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
    private TableColumn<Employee,String> designationColumn;
    
    @FXML
    private TableColumn<Employee,String> salaryColumn;
    
    public static Employee selectedEmp;

    public static Employee getEmp() {
        return selectedEmp;
    }

    public static void setEmp(Employee selectedEmp) {
        ViewController.selectedEmp = selectedEmp;
    }
    
    @FXML
    private void addEmployee(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/addEmployee.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add");
        stage.show();
    }
    
    @FXML
    private void tableRefresh(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
         //Get all Employees information
            ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            //Populate Employees on TableView
            System.out.println("refresh karamu");
            populateEmployees(empData);
    }
    @FXML
    private void searchEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Employee emp = EmployeeDAO.searchEmployee(NicNText.getText(),empIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowEmployee(emp);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowEmployee(Employee emp) throws ClassNotFoundException {
        if (emp != null) {
            populateEmployee(emp);
           
        } else {
           System.out.println("This employee does not exist!\n");
           populateEmployee(emp);
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert");
           alert.setHeaderText("Information Alert");
           String s ="NO Search Result";
           alert.setContentText(s);
           alert.show();
        }
    }
    
    //Populate Employee
    @FXML
    private void populateEmployee (Employee emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Employee> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }

    
    //Search all employees
    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateEmployees(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    //Populate Employees for TableView
    @FXML
    private void populateEmployees (ObservableList<Employee> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(empData.size());
        employeeTable.setItems(empData);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        employeeTable.setRowFactory( (TableView<Employee> tv) -> {
        TableRow<Employee> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                Employee rowData = row.getItem();
                System.out.println(rowData);
                
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/UpdateEmployee.fxml"));
                //Region root = null;
                ViewController.setEmp(rowData);
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                
                Parent p = loader.getRoot();
                
                Scene scene = new Scene(p);
                st.setScene(scene);


                st.showAndWait();
                    }
        });
        return row ;
        });
        EmpIdColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("empId"));
        FirstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        LastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        SexColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("sex"));
        NIC_NumberColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("nic_Number"));
        Address1Column.setCellValueFactory(new PropertyValueFactory<Employee,String>("address1"));
        Address2Column.setCellValueFactory(new PropertyValueFactory<Employee,String>("address2"));
        Address3Column.setCellValueFactory(new PropertyValueFactory<Employee,String>("address3"));
        ContactNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("contactNumber"));
        designationColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("designation"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("salary"));
        
        try {
            //Get all Employees information
            ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            //Populate Employees on TableView
            System.out.println("populate karamu");
            populateEmployees(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            try {
                throw e;
            } catch (SQLException ex) {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //EmpIdColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("empId"));
        
        /*
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        SexColumn.setCellValueFactory(cellData -> cellData.getValue().SexProperty());
        Address1Column.setCellValueFactory(cellData -> cellData.getValue().Address1Property());
        Address2Column.setCellValueFactory(cellData -> cellData.getValue().Address2Property());
        Address3Column.setCellValueFactory(cellData -> cellData.getValue().Address3Property());
        ContactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().ContactNumberProperty());
        */
    }    
    
}
