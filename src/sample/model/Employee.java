/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;


import javafx.beans.property.*;


/**
 *
 * @author aruna
 */
public class Employee {
    //Declare Employees Table Columns
    private IntegerProperty  empId;
    private StringProperty  firstName;
    private StringProperty  lastName;
    private StringProperty  sex;
    private StringProperty  nic_Number;
    private StringProperty  address1;
    private StringProperty  address2;
    private StringProperty  address3;
    private StringProperty  contactNumber;
    private StringProperty  salary;
    private StringProperty designation;

    public Employee() {
        this.empId = new SimpleIntegerProperty(0);
        this.firstName = new SimpleStringProperty("");
        this.lastName = new SimpleStringProperty("");
        this.sex = new SimpleStringProperty("");
        this.nic_Number = new SimpleStringProperty("");
        this.address1 = new SimpleStringProperty("");
        this.address2 = new SimpleStringProperty("");
        this.address3 = new SimpleStringProperty("");
        this.contactNumber = new SimpleStringProperty("");
        this.salary = new SimpleStringProperty("");
        this.designation = new SimpleStringProperty("");
    }

    public int getEmpId() {
        return empId.get();
    }
    
    public IntegerProperty EmpIdProperty() {
        return empId;
    }

    public void setEmpId(int EmpId) {
        this.empId.set(EmpId);
    }

    public String getFirstName() {
        return firstName.get();
    }
    
     public StringProperty FirstNameProperty() {
        return firstName;
    }
     
    public void setFirstName(String FirstName) {
        this.firstName.set(FirstName);
    }

    public String getLastName() {
        return lastName.get();
    }
    
    public StringProperty LastNameProperty() {
        return lastName;
    }
    
    public void setLastName(String LastName) {
        this.lastName.set(LastName);
    }

    public String getSex() {
        return sex.get();
    }
    
    public StringProperty SexProperty() {
        return sex;
    }

    public void setSex(String Sex) {
        this.sex.set(Sex);
    }

    public String getNic_Number() {
        return nic_Number.get();
    }
    
    public StringProperty Nic_NumberProperty() {
        return nic_Number;
    }

    public void setNic_Number(String nic_Number) {
        this.nic_Number.set(nic_Number);
    }

    public String getAddress1() {
        return address1.get();
    }
    
    public StringProperty Address1Property() {
        return address1;
    }

    public void setAddress1(String Address1) {
        this.address1.set(Address1);
    }

    public String getAddress2() {
        return address2.get();
    }
    
    public StringProperty Address2Property() {
        return address2;
    }

    public void setAddress2(String Address2) {
        this.address2.set(Address2);
    }

    public String getAddress3() {
        return address3.get();
    }
    
    public StringProperty Address3Property() {
        return address3;
    }

    public void setAddress3(String Address3) {
        this.address3.set(Address3);
    }

    public String getContactNumber() {
        return contactNumber.get();
    }
    
    public StringProperty ContactNumberProperty() {
        return contactNumber;
    }
    

    public void setContactNumber(String ContactNumber) {
        this.contactNumber.set(ContactNumber);
    }

    public String getSalary() {
        return salary.get();
    }
    
    public StringProperty SalaryProperty() {
        return salary;
    }

    public void setSalary(String Salary) {
        this.salary.set(Salary);
    }

    public String getDesignation() {
        return designation.get();
    }
    
    public StringProperty DesignationProperty() {
        return designation;
    }

    public void setDesignation(String Designation) {
        this.designation.set(Designation);
    }
    
}

   