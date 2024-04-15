package com.example.hotelmanagement;
//import com.example.hotelmanagement.InvalidAadharException;
//import com.example.hotelmanagement.Receptionist;
//import com.example.hotelmanagement.Housekeeping;
//import com.example.hotelmanagement.Manager;
//import com.example.hotelmanagement.Bellboy;
//import com.example.hotelmanagement.Chef;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//import android.widget.TextView;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.content.Intent;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// Import any other necessary classes here
//
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private List<Room> roomsList = new ArrayList<>();
//    private List<Reservation> reservationsList = new ArrayList<>();
//    private List<Bill> billsList = new ArrayList<>();
//    private List<Employee> employeesList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize roomsList, reservationsList, billsList, employeesList, etc. if needed
//
//        Button displayRoomsBtn = findViewById(R.id.displayRoomsBtn);
//        Button bookRoomBtn = findViewById(R.id.bookRoomBtn);
//        Button checkoutRoomBtn = findViewById(R.id.checkoutRoomBtn);
//        Button addEmployeeBtn = findViewById(R.id.addEmployeeBtn);
//
//        try {
//            // Your code that may cause exceptions
//            displayRoomsBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                    startActivity(intent);
//
//                }});
//
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception
//            // Handle the exception, such as displaying an error message to the user
//
//        }
//
//
//        // Your existing code...
//
//        Button displayPreviousEmployeesBtn = findViewById(R.id.displayPreviousEmployeesBtn);
//        displayPreviousEmployeesBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPreviousEmployeesDialog();
//            }
//        });
//
//
//        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Call a method to handle booking logic
//                bookRoom(15, "shashank", "5252", "7489401140", 5);
//            }
//        });
//
//        checkoutRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Call a method to handle checkout logic
//                checkoutRoom(15);
//            }
//        });
//
//        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Call a method to handle adding employee logic
//                addEmployee("Riya", "156", 5);
//            }
//        });
//    }
//
//    public void displayAvailableRooms() {
//        // Implement logic to display available rooms
//        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
//        for (Room room : roomsList) {
//            if (room.getAvailability()) {
//                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
//                        .append(" | Type: ").append(room.getRoomType())
//                        .append(" | Price: $").append(room.getPrice()).append("\n");
//                // Add special features display if needed
//            }
//        }
//        // Display availableRoomsText to the user (e.g., in a TextView)
//        Toast.makeText(MainActivity.this, availableRoomsText.toString(), Toast.LENGTH_LONG).show();
//    }
//
//    public void bookRoom(int roomId, String guestName, String guestAadharNumber, String guestPhoneNumber, int numDays) {
//        // Check if the room is available
//        Room selectedRoom = null;
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == roomId && room.getAvailability()) {
//                selectedRoom = room;
//                break;
//            }
//        }
//
//        if (selectedRoom != null) {
//            // Room is available, proceed with booking
//            try {
//                Guest guest = new Guest(guestName, guestAadharNumber);
//                // Validate guest phone number here
//
//                // Calculate total cost
//                double totalCost = selectedRoom.getPrice() * numDays;
//
//                // Book the room
//                selectedRoom.setAvailability(false);
//                Reservation reservation = new Reservation(selectedRoom, guest, numDays);
//                reservationsList.add(reservation);
//
//                // Display booking confirmation and total cost
//                String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
//                // Display confirmation message to the user (e.g., using AlertDialog)
//
//                // Update UI or perform any other necessary actions
//
//
//                // Check if the Aadhar number is valid
//                if (!isValidAadhar(guestAadharNumber)) {
//                    throw new InvalidAadharException("Invalid Aadhar Number");
//                }
//                // Other booking logic...
//            } catch (InvalidAadharException e) {
//                // Handle the exception
//                e.printStackTrace();
//            }
//        } else {
//            // Room is not available
//            // Display error message to the user (e.g., using Toast)
//        }
//    }
//    private boolean isValidAadhar(String aadharNumber) {
//        // Validate the Aadhar number format and logic here
//        return aadharNumber != null && aadharNumber.length() == 12;
//    }
//
//    public void checkoutRoom(int roomId) {
//        for (Reservation reservation : reservationsList) {
//            if (reservation.getRoom().getRoomNumber() == roomId) {
//                double totalBill = reservation.getRoom().getPrice() * reservation.getDuration();
//                Bill bill = new Bill(totalBill);
//                billsList.add(bill);
//
//                // Display checkout confirmation message and total bill
//                String checkoutMessage = "Room " + roomId + " has been checked out successfully.\nTotal Bill: $" + totalBill;
//                // Display checkoutMessage to the user (e.g., using AlertDialog)
//
//                // Update UI or perform any other necessary actions
//
//                // Mark the room as available
//                reservation.getRoom().setAvailability(true);
//                reservationsList.remove(reservation);
//                return;
//            }
//        }
//        // Room not found in reservations list, display error message
//        // Display error message to the user (e.g., using Toast)
//    }
//
//    public void addEmployee(String employeeName, String employeeId, int employeeType) {
//        Employee newEmployee = null;
//        switch (employeeType) {
//            case 1:
//                newEmployee = new Receptionist(employeeName, employeeId,13);
//                break;
//            case 2:
//                newEmployee = new Housekeeping(employeeName, employeeId);
//                break;
//            case 3:
//                newEmployee = new Manager(employeeName, employeeId,4);
//                break;
//            case 4:
//                newEmployee = new Bellboy(employeeName, employeeId);
//                break;
//            case 5:
//                newEmployee = new Chef(employeeName, employeeId);
//                break;
//            default:
//                // Handle invalid employee type
//                break;
//        }
//
//        if (newEmployee != null) {
//            employeesList.add(newEmployee);
//            // Display success message to the user (e.g., using Toast)
//            // Update UI or perform any other necessary actions
//        } else {
//            // Display error message for invalid employee type
//            // Display error message to the user (e.g., using Toast)
//        }
//    }
//
//
//    private void showAvailableRoomsDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.available_rooms_dialog);
//
//        TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
//        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);
//
//        // Populate availableRoomsListView with data from roomsList
//        List<String> availableRoomsData = new ArrayList<>();
//        for (Room room : roomsList) {
//            if (room.getAvailability()) {
//                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//    }
//
//    private void showPreviousEmployeesDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.previous_employees_dialog);
//
//        TextView previousEmployeesDialogTitle = dialog.findViewById(R.id.previousEmployeesDialogTitle);
//        ListView previousEmployeesListView = dialog.findViewById(R.id.previousEmployeesListView);
//
//        // Populate previousEmployeesListView with data from employeesList
//        List<String> previousEmployeesData = new ArrayList<>();
//        for (Employee employee : employeesList) {
//            previousEmployeesData.add(employee.getName() + " | ID: " + employee.getId());
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, previousEmployeesData);
//        previousEmployeesListView.setAdapter(adapter);
//
//        dialog.show();
//    }
//
//}
//



//
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private List<Room> roomsList = new ArrayList<>();
//    private List<Reservation> reservationsList = new ArrayList<>();
//    private List<Bill> billsList = new ArrayList<>();
//    private List<Employee> employeesList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize roomsList (assuming it's done elsewhere)
//
//        Button displayRoomsBtn = findViewById(R.id.displayRoomsBtn);
//        Button bookRoomBtn = findViewById(R.id.bookRoomBtn);
//        Button checkoutRoomBtn = findViewById(R.id.checkoutRoomBtn);
//
//        displayRoomsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAvailableRoomsDialog();
//            }
//        });
//
//        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Example booking
//                bookRoom(15, "John Doe", "123456789012", "1234567890", 5);
//            }
//        });
//
//        checkoutRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Example checkout
//                checkoutRoom(15);
//            }
//        });
//    }
//
//    public void showAvailableRoomsDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.available_rooms_dialog);
//
//        TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
//        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);
//
//        List<String> availableRoomsData = new ArrayList<>();
//        for (Room room : roomsList) {
//            if (room.getAvailability()) {
//                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//    }
//
////
//public void bookRoom(int roomId, String guestName, String guestAadharNumber, String guestPhoneNumber, int numDays) {
//    // Check if the room is available
//    Room selectedRoom = null;
//    for (Room room : roomsList) {
//        if (room.getRoomNumber() == roomId && room.getAvailability()) {
//            selectedRoom = room;
//            break;
//        }
//    }
//
//    if (selectedRoom != null) {
//        // Room is available, proceed with booking
//        try {
//            Guest guest = new Guest(guestName, guestAadharNumber);
//            // Validate guest phone number here
//
//            // Calculate total cost
//            double totalCost = selectedRoom.getPrice() * numDays;
//
//            // Book the room
//            selectedRoom.setAvailability(false);
//            Reservation reservation = new Reservation(selectedRoom, guest, numDays);
//            reservationsList.add(reservation);
//
//            // Display booking confirmation and total cost
//            String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
//            // Display confirmation message to the user (e.g., using AlertDialog)
//
//            // Check if the Aadhar number is valid
//            if (!isValidAadhar(guestAadharNumber)) {
//                throw new InvalidAadharException("Invalid Aadhar Number");
//            }
//            // Other booking logic...
//        } catch (InvalidAadharException e) {
//            // Handle the exception
//            e.printStackTrace();
//        }
//    } else {
//        // Room is not available
//        // Display error message to the user (e.g., using Toast)
//    }
//}
//
//
//        if (selectedRoom != null) {
//            try {
//                Guest guest = new Guest(guestName, guestAadharNumber);
//                double totalCost = selectedRoom.getPrice() * numDays;
//
//                selectedRoom.setAvailability(false);
//                Reservation reservation = new Reservation(selectedRoom, guest, numDays);
//                reservationsList.add(reservation);
//
//                String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
//                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();
//
//                // Update UI or perform other necessary actions
//            } catch (InvalidAadharException e) {
//                e.printStackTrace();
//                Toast.makeText(MainActivity.this, "Invalid Aadhar Number", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(MainActivity.this, "Room not available", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void checkoutRoom(int roomId) {
//        Reservation reservationToRemove = null;
//        for (Reservation reservation : reservationsList) {
//            if (reservation.getRoom().getRoomNumber() == roomId) {
//                double totalBill = reservation.getRoom().getPrice() * reservation.getDuration();
//                Bill bill = new Bill(totalBill);
//                billsList.add(bill);
//
//                String checkoutMessage = "Room " + roomId + " has been checked out successfully.\nTotal Bill: $" + totalBill;
//                Toast.makeText(MainActivity.this, checkoutMessage, Toast.LENGTH_LONG).show();
//
//                reservation.getRoom().setAvailability(true);
//                reservationToRemove = reservation;
//                break;
//            }
//        }
//
//        if (reservationToRemove != null) {
//            reservationsList.remove(reservationToRemove);
//        } else {
//            Toast.makeText(MainActivity.this, "Room not found in reservations list", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    // Other methods for adding employees, displaying previous employees, etc.
//}

//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private List<Room> roomsList = new ArrayList<>();
//    private List<Reservation> reservationsList = new ArrayList<>();
//    private List<Bill> billsList = new ArrayList<>();
//    private List<Employee> employeesList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize roomsList (assuming it's done elsewhere)
//
//        Button displayRoomsBtn = findViewById(R.id.displayRoomsBtn);
//        Button bookRoomBtn = findViewById(R.id.bookRoomBtn);
//        Button checkoutRoomBtn = findViewById(R.id.checkoutRoomBtn);
//
//        // Initialize roomsList
//        roomsList.add(new Room(101, "Single", 50.0, true));
//        roomsList.add(new Room(102, "Double", 80.0, true));
//        roomsList.add(new Room(103, "Suite", 120.0, false));
//
//        // Initialize reservationsList
//        Guest guest1 = new Guest("John Doe", "123456789012");
//        Guest guest2 = new Guest("Jane Doe", "987654321098");
//
//        Reservation reservation1 = new Reservation(roomsList.get(0), guest1, 3);
//        Reservation reservation2 = new Reservation(roomsList.get(1), guest2, 5);
//
//        reservationsList.add(reservation1);
//        reservationsList.add(reservation2);
//
//        // Initialize billsList
//        Bill bill1 = new Bill(150.0);
//        Bill bill2 = new Bill(400.0);
//
//        billsList.add(bill1);
//        billsList.add(bill2);
//
//        // Initialize employeesList
//        employeesList.add(new Receptionist("Alice", "EMP001", 13));
//        employeesList.add(new Housekeeping("Bob", "EMP002"));
//        employeesList.add(new Manager("Charlie", "EMP003", 4));
//        employeesList.add(new Bellboy("David", "EMP004"));
//        employeesList.add(new Chef("Eva", "EMP005"));
//    }
//
//        displayRoomsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showAvailableRoomsDialog();
//            }
//        });
//
//        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Example booking
//                bookRoom(15, "John Doe", "123456789012", "1234567890", 5);
//            }
//        });
//
//        checkoutRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Example checkout
//                checkoutRoom(15);
//            }
//        });
//    }
//
//    public void showAvailableRoomsDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.available_rooms_dialog);
//
//        TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
//        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);
//
//        List<String> availableRoomsData = new ArrayList<>();
//        for (Room room : roomsList) {
//            if (room.getAvailability()) {
//                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//    }
//
//    public void bookRoom(int roomId, String guestName, String guestAadharNumber, String guestPhoneNumber, int numDays) {
//        Room selectedRoom = null;
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == roomId && room.getAvailability()) {
//                selectedRoom = room;
//                break;
//            }
//        }
//
//        if (selectedRoom != null) {
//
//                Guest guest = new Guest(guestName, guestAadharNumber);
//                double totalCost = selectedRoom.getPrice() * numDays;
//
//                selectedRoom.setAvailability(false);
//                Reservation reservation = new Reservation(selectedRoom, guest, numDays);
//                reservationsList.add(reservation);
//
//                String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
//                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();
//
//                // Update UI or perform other necessary actions
//
//        } else {
//            Toast.makeText(MainActivity.this, "Room not available", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void checkoutRoom(int roomId) {
//        Reservation reservationToRemove = null;
//        for (Reservation reservation : reservationsList) {
//            if (reservation.getRoom().getRoomNumber() == roomId) {
//                double totalBill = reservation.getRoom().getPrice() * reservation.getDuration();
//                Bill bill = new Bill(totalBill);
//                billsList.add(bill);
//
//                String checkoutMessage = "Room " + roomId + " has been checked out successfully.\nTotal Bill: $" + totalBill;
//                Toast.makeText(MainActivity.this, checkoutMessage, Toast.LENGTH_LONG).show();
//
//                reservation.getRoom().setAvailability(true);
//                reservationToRemove = reservation;
//                break;
//            }
//        }
//
//        if (reservationToRemove != null) {
//            reservationsList.remove(reservationToRemove);
//        } else {
//            Toast.makeText(MainActivity.this, "Room not found in reservations list", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
//




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
public class MainActivity extends AppCompatActivity {
    private List<Room> roomsList = new ArrayList<>();
    private List<Reservation> reservationsList = new ArrayList<>();
    private List<Bill> billsList = new ArrayList<>();
    private List<Employee> employeesList = new ArrayList<>();
    private Button displayRoomsBtn;
    private Button bookRoomBtn;
    private Button checkoutRoomBtn;
    private Button addEmployeeBtn;
    private Button addRoomBtn;
    private Button hotelManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize roomsList
        roomsList.add(new Room(101, "Single", 50.0, true));
        roomsList.add(new Room(102, "Double", 80.0, true));
        roomsList.add(new Room(103, "Suite", 120.0, false));
        roomsList.add(new Room(104, "Suite", 120.0, false));
        roomsList.add(new Room(105, "Double", 80.0, true));
        roomsList.add(new Room(106, "Double", 80.0, true));
        roomsList.add(new Room(107, "Double", 80.0, true));
       hotelManagement=findViewById(R.id.hotelmanagement);
        addRoomBtn=findViewById(R.id.addRoomButton);
        displayRoomsBtn = findViewById(R.id.displayRoomsBtn);
        addEmployeeBtn=findViewById(R.id.addEmployeeBtn);
        bookRoomBtn = findViewById(R.id.bookRoomBtn);
        checkoutRoomBtn = findViewById(R.id.checkoutRoomBtn);
                Guest guest1 = new Guest("John Doe", "123456789012");
        Guest guest2 = new Guest("Jane Doe", "987654321098");

        Reservation reservation1 = new Reservation(roomsList.get(0), guest1, 3);
        Reservation reservation2 = new Reservation(roomsList.get(1), guest2, 5);

        reservationsList.add(reservation1);
        reservationsList.add(reservation2);

        // Initialize billsList
        Bill bill1 = new Bill(150.0);
        Bill bill2 = new Bill(400.0);

        billsList.add(bill1);
        billsList.add(bill2);

        // Initialize employeesList
        employeesList.add(new Receptionist("Alice", "EMP001", 13));
        employeesList.add(new Housekeeping("Bob", "EMP002"));
        employeesList.add(new Manager("Charlie", "EMP003", 4));
        employeesList.add(new Bellboy("David", "EMP004"));
        employeesList.add(new Chef("Eva", "EMP005"));
        hotelManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        displayRoomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAvailableRoomsDialogForBooking();
            }
        });
                Button displayPreviousEmployeesBtn = findViewById(R.id.displayPreviousEmployeesBtn);
        displayPreviousEmployeesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousEmployeesDialog();
            }
        });
        addEmployeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });
        addRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent2);
            }
        });

//        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Example booking
//               // bookRoom(15, "John Doe", "123456789012", "1234567890", 5);
//                showAvailableRoomsDialogForBooking();
//            }
//        });

        bookRoomBtn.setOnClickListener(new View.OnClickListener() {
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
                int roomId = Integer.parseInt(roomIdEditText.getText().toString());
                int numDays = Integer.parseInt(numDaysEditText.getText().toString());

                // Call the bookRoom method with the retrieved inputs
                bookRoom(roomId, guestName, guestAadhar, guestPhone, numDays);
            }
        });


        checkoutRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example checkout
                showBookedRoomsForCheckoutDialog();
            }
        });
    }

//    public void showAvailableRoomsDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setContentView(R.layout.available_rooms_dialog);
//
//        //TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
//        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);
//
//        List<String> availableRoomsData = new ArrayList<>();
//        for (Room room : roomsList) {
//            if (room.getAvailability()) {
//                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//    }

//    public void bookRoom(int roomId, String guestName, String guestAadharNumber, String guestPhoneNumber, int numDays) {
//        Room selectedRoom = null;
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == roomId && room.getAvailability()) {
//                selectedRoom = room;
//                break;
//            }
//        }
//
//        if (selectedRoom != null) {
//
//                Guest guest = new Guest(guestName, guestAadharNumber);
//                double totalCost = selectedRoom.getPrice() * numDays;
//
//                selectedRoom.setAvailability(false);
//                Reservation reservation = new Reservation(selectedRoom, guest, numDays);
//                reservationsList.add(reservation);
//
//                String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
//                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();
//
//                // Update UI or perform other necessary actions
//
//
//        } else {
//            Toast.makeText(MainActivity.this, "Room not available", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void bookRoom(int roomId, String guestName, String guestAadharNumber, String guestPhoneNumber, int numDays) {
        Room selectedRoom = null;
        for (Room room : roomsList) {
            if (room.getRoomNumber() == roomId && room.getAvailability()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {

                Guest guest = new Guest(guestName, guestAadharNumber);
                double totalCost = selectedRoom.getPrice() * numDays;

                selectedRoom.setAvailability(false);
                Reservation reservation = new Reservation(selectedRoom, guest, numDays);
                reservationsList.add(reservation);

                String confirmationMessage = "Room " + roomId + " has been booked successfully.\nTotal Cost: $" + totalCost;
                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();

                // Update UI or perform other necessary actions

        } else {
            Toast.makeText(MainActivity.this, "Room not available", Toast.LENGTH_SHORT).show();
        }
    }


//    public void checkoutRoom(int roomId) {
//        Reservation reservationToRemove = null;
//        for (Reservation reservation : reservationsList) {
//            if (reservation.getRoom().getRoomNumber() == roomId) {
//                double totalBill = reservation.getRoom().getPrice() * reservation.getDuration();
//                Bill bill = new Bill(totalBill);
//                billsList.add(bill);
//
//                String checkoutMessage = "Room " + roomId + " has been checked out successfully.\nTotal Bill: $" + totalBill;
//                Toast.makeText(MainActivity.this, checkoutMessage, Toast.LENGTH_LONG).show();
//
//                reservation.getRoom().setAvailability(true);
//                reservationToRemove = reservation;
//                break;
//            }
//        }
//
//        if (reservationToRemove != null) {
//            reservationsList.remove(reservationToRemove);
//        } else {
//            Toast.makeText(MainActivity.this, "Room not found in reservations list", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void checkoutRoom(int roomId, double totalBill) {
        Reservation reservationToRemove = null;
        for (Reservation reservation : reservationsList) {
            if (reservation.getRoom().getRoomNumber() == roomId) {
                // Bill object creation and addition to the billsList removed for brevity

                String checkoutMessage = "Room " + roomId + " \nTotal Bill: $" + totalBill;
                Toast.makeText(MainActivity.this, checkoutMessage, Toast.LENGTH_LONG).show();

                reservation.getRoom().setAvailability(true);
                reservationToRemove = reservation;
                break;
            }
        }

        if (reservationToRemove != null) {
            reservationsList.remove(reservationToRemove);
        } else {
            Toast.makeText(MainActivity.this, "Room not found in reservations list", Toast.LENGTH_SHORT).show();
        }
    }

    private void showPreviousEmployeesDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.previous_employees_dialog);

        TextView previousEmployeesDialogTitle = dialog.findViewById(R.id.previousEmployeesDialogTitle);
        ListView previousEmployeesListView = dialog.findViewById(R.id.previousEmployeesListView);

        // Populate previousEmployeesListView with data from employeesList
        List<String> previousEmployeesData = new ArrayList<>();
        for (Employee employee : employeesList) {
            previousEmployeesData.add(employee.getName() + " | ID: " + employee.getId());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, previousEmployeesData);
        previousEmployeesListView.setAdapter(adapter);

        dialog.show();
    }
    public void showAvailableRoomsDialogForBooking() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.available_rooms_dialog);

        //TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);

        List<String> availableRoomsData = new ArrayList<>();
        for (Room room : roomsList) {
            if (room.getAvailability()) {
                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
                        " | Type: " + room.getRoomType() +
                        " | Price: $" + room.getPrice());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, availableRoomsData);
        availableRoomsListView.setAdapter(adapter);

        availableRoomsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected room from the list
                Room selectedRoom = roomsList.get(position);

                // Check if the room is available
                if (selectedRoom.getAvailability()) {
                    // Perform booking for the selected room
                    bookRoom(selectedRoom.getRoomNumber(), "John Doe", "123456789012", "1234567890", 5);

                    // Dismiss the dialog after booking
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Room not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
    public void showBookedRoomsForCheckoutDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.booked_rooms_dialog);

        TextView bookedRoomsDialogTitle = dialog.findViewById(R.id.bookedRoomsDialogTitle);
        ListView bookedRoomsListView = dialog.findViewById(R.id.bookedRoomsListView);

        List<String> bookedRoomsData = new ArrayList<>();
        for (Reservation reservation : reservationsList) {
            bookedRoomsData.add("Room Number: " + reservation.getRoom().getRoomNumber() +
                    " | Guest Name: " + reservation.getGuest().getName() +
                    " | Duration: " + reservation.getDuration() + " days");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, bookedRoomsData);
        bookedRoomsListView.setAdapter(adapter);

        bookedRoomsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected reservation
                Reservation selectedReservation = reservationsList.get(position);

                // Calculate total bill for the selected reservation
                double totalBill = selectedReservation.getRoom().getPrice() * selectedReservation.getDuration();

                // Perform checkout actions
                checkoutRoom(selectedReservation.getRoom().getRoomNumber(), totalBill);

                // Dismiss the dialog after checkout
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
