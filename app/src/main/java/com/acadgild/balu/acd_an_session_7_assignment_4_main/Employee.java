package com.acadgild.balu.acd_an_session_7_assignment_4_main;

/**
 * Created by BALU on 4/20/2016.
 */
public class Employee
{
    private int emp_id;
    private String emp_first_name;
    private String emp_last_name;

    public Employee() {
    }

    public Employee(int emp_id, String emp_first_name, String emp_last_name)
    {
        this.emp_id = emp_id;
        this.emp_first_name = emp_first_name;
        this.emp_last_name = emp_last_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_first_name() {
        return emp_first_name;
    }

    public void setEmp_first_name(String emp_first_name) {
        this.emp_first_name = emp_first_name;
    }

    public String getEmp_last_name() {
        return emp_last_name;
    }

    public void setEmp_last_name(String emp_last_name) {
        this.emp_last_name = emp_last_name;
    }
}
