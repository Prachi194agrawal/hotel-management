package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Room_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Intent intent=getIntent();

        // Add onClick listeners for buttons to add/edit/delete rooms
        Button addRoomBtn = findViewById(R.id.addRoomBtn);
        Button editRoomBtn = findViewById(R.id.editRoomBtn);
        Button deleteRoomBtn = findViewById(R.id.deleteRoomBtn);

        addRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRoomDialog();
            }
        });

        editRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditRoomDialog();
            }
        });

        deleteRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic to delete a room
                deleteRoom();
            }
        });
    }

    private void openAddRoomDialog() {
        // Implement logic to open a dialog or activity for adding a new room
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Room");
        builder.setMessage("Implement logic to add a new room here.");
        builder.setPositiveButton("Add", (dialog, which) -> {
            // Handle add button click
            // Perform necessary actions like adding the room to your database
            addRoomToDatabase(); // Placeholder method
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Handle cancel button click
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openEditRoomDialog() {
        // Implement logic to open a dialog or activity for editing a room
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Room");
        builder.setMessage("Implement logic to edit a room here.");
        builder.setPositiveButton("Save", (dialog, which) -> {
            // Handle save button click
            // Perform necessary actions like updating the room in your database
            editRoomInDatabase(); // Placeholder method
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Handle cancel button click
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteRoom() {
        // Implement logic to delete a room
        // Perform necessary actions like deleting the room from your database
        deleteRoomFromDatabase(); // Placeholder method
    }

    private void addRoomToDatabase() {
        // Placeholder method for adding a room to the database
        // Implement your database insertion logic here
    }

    private void editRoomInDatabase() {
        // Placeholder method for editing a room in the database
        // Implement your database update logic here
    }

    private void deleteRoomFromDatabase() {
        // Placeholder method for deleting a room from the database
        // Implement your database deletion logic here
    }
}
