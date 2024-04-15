package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.hotelmanagement.InvalidAadharException;
import com.example.hotelmanagement.Receptionist;
import com.example.hotelmanagement.Housekeeping;
import com.example.hotelmanagement.Manager;
import com.example.hotelmanagement.Bellboy;
import com.example.hotelmanagement.Chef;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// Import any other necessary classes here


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class MainActivity4 extends AppCompatActivity {
    private List<Employee> employeesList = new ArrayList<>();
    private Button addEmployeeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent=getIntent();
        addEmployeeBtn=findViewById(R.id.addEmployeeBtn);
        employeesList.add(new Receptionist("Alice", "EMP001", 13));
        employeesList.add(new Housekeeping("Bob", "EMP002"));
        employeesList.add(new Manager("Charlie", "EMP003", 4));
        employeesList.add(new Bellboy("David", "EMP004"));
        employeesList.add(new Chef("Eva", "EMP005"));
        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText guestNameEditText = findViewById(R.id.guestNameEditText);
                EditText guestAadharEditText = findViewById(R.id.guestAadharEditText);
                EditText guestPhoneEditText = findViewById(R.id.guestPhoneEditText);
                EditText roomIdEditText = findViewById(R.id.roomIdEditText);
                EditText numDaysEditText = findViewById(R.id.numDaysEditText);

                String guestName = guestNameEditText.getText().toString();
                String guestAadhar = guestAadharEditText.getText().toString();
                String guestPhone = guestPhoneEditText.getText().toString();
                String roomId = roomIdEditText.getText().toString();
                int numDays = Integer.parseInt(numDaysEditText.getText().toString());

                // Call the bookRoom method with the retrieved inputs
                //bookRoom(roomId, guestName, guestAadhar, guestPhone, numDays);
                addEmployee(guestName, roomId, numDays);
                addEmployee("Riya", "156", 5);
            }
        });

    }
    public void addEmployee(String employeeName, String employeeId, int employeeType) {
        Employee newEmployee = null;
        switch (employeeType) {
            case 1:
                newEmployee = new Receptionist(employeeName, employeeId,13);
                break;
            case 2:
                newEmployee = new Housekeeping(employeeName, employeeId);
                break;
            case 3:
                newEmployee = new Manager(employeeName, employeeId,4);
                break;
            case 4:
                newEmployee = new Bellboy(employeeName, employeeId);
                break;
            case 5:
                newEmployee = new Chef(employeeName, employeeId);
                break;
            default:
                // Handle invalid employee type
                break;
        }

        if (newEmployee != null) {
            employeesList.add(newEmployee);
            // Display success message to the user (e.g., using Toast)
            // Update UI or perform any other necessary actions
        } else {
            // Display error message for invalid employee type
            // Display error message to the user (e.g., using Toast)
        }
    }

}