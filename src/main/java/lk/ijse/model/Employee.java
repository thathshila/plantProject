package lk.ijse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    private String Employee_id;
    private String Employee_name;
    private String Address;
    private String Contact;
    private Date Date;
    private double Salary;
    private String WorkingHours;
    private String Attendance;
    private String Position;
private String userId;
}