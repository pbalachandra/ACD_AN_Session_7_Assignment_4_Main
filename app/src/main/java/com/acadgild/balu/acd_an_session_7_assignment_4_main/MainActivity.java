package com.acadgild.balu.acd_an_session_7_assignment_4_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView_display;
    EditText editText_first_name, editText_last_name;
    Button button_add;
    DBHelper dbHelper = new DBHelper(this);

    ArrayList<Employee> arrayList_employee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_display = (TextView) findViewById(R.id.textView_display);
        editText_first_name = (EditText) findViewById(R.id.editText_first_name);
        editText_last_name = (EditText) findViewById(R.id.editText_last_name);
        button_add = (Button) findViewById(R.id.button_add);

        button_add.setOnClickListener(this);

        display_data();

    }

    @Override
    public void onClick(View v)
    {
        Employee employee = new Employee();

        employee.setEmp_first_name(editText_first_name.getText().toString());
        employee.setEmp_last_name(editText_last_name.getText().toString());
        dbHelper.add_new_employee(employee);
        editText_first_name.setText("");
        editText_last_name.setText("");
        display_data();
    }

    public void display_data()
    {
        textView_display.setText("");
        arrayList_employee = dbHelper.get_all_employees();

        for(Employee emp:arrayList_employee)
        {
            textView_display.append(String.format(getResources().getString(R.string.display_text),
                                    emp.getEmp_id(), emp.getEmp_first_name(), emp.getEmp_last_name()));
        }
    }
}
