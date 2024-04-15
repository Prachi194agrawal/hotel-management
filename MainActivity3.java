package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
// MainActivity.java
public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Add onClick listeners for buttons to navigate to other activities
        Button manageRoomsBtn = findViewById(R.id.manageRoomsBtn);
        Button manageEmployeesBtn = findViewById(R.id.manageEmployeesBtn);
        Button bookRoomBtn = findViewById(R.id.bookRoomBtn);
        Button checkoutRoomBtn = findViewById(R.id.checkoutRoomBtn);

        manageRoomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, Room_Activity.class));
            }
        });

        manageEmployeesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, EmployActivity.class));
            }
        });

        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, BookingActivity.class));
            }
        });

        checkoutRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, CheckoutActivity.class));
            }
        });
    }
}
