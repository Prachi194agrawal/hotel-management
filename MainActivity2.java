//package com.example.hotelmanagement;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity2 extends AppCompatActivity {
//    private EditText inputRoomNumber;
//    private List<Room> roomsList = new ArrayList<>();
//    private Button showRoomsButton;
//    private TextView displayRoomsTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        inputRoomNumber = findViewById(R.id.inputRoomNumber);
//        showRoomsButton = findViewById(R.id.showRoomsButton);
//        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
//
//        showRoomsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String roomNumber = inputRoomNumber.getText().toString();
//                // Perform logic to display available rooms based on the roomNumber
//                // You can implement this logic using your existing method or create a new method specifically for this purpose
//                displayAvailableRooms(roomNumber);
//            }
//        });
//    }
//
//    private void displayAvailableRooms(String roomNumber) {
//        // Implement logic to display available rooms based on the roomNumber
//        // For example, you can retrieve the available rooms list and filter by roomNumber
//        Dialog dialog = new Dialog(MainActivity2.this);
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
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity2.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == Integer.parseInt(roomNumber) && room.getAvailability()) {
//                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
//                        .append(" | Type: ").append(room.getRoomType())
//                        .append(" | Price: $").append(room.getPrice()).append("\n");
//                // Add special features display if needed
//            }
//        }
//        // Display availableRoomsText to the user (e.g., in a TextView)
//        displayRoomsTextView.setText(availableRoomsText.toString());
//    }
//    private Button addRoomButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        // Initialize views
//        inputRoomNumber = findViewById(R.id.inputRoomNumber);
//        showRoomsButton = findViewById(R.id.showRoomsButton);
//        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
//        addRoomButton = findViewById(R.id.addRoomButton); // Assuming you have a button with id addRoomButton
//
//        // Set click listener for showRoomsButton
//        showRoomsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String roomNumber = inputRoomNumber.getText().toString();
//                displayAvailableRooms(roomNumber);
//            }
//        });
//
//        // Set click listener for addRoomButton
//        addRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open a dialog or activity to allow the user to add a new room
//                // For simplicity, let's assume the user directly inputs the room details
//                // You can modify this to suit your application's design
//                addRoomManually();
//            }
//        });
//
//        // Initialize roomsList with some sample data (you can remove this in production)
//        roomsList.add(new Room(101, "Single", 50, true));
//        roomsList.add(new Room(102, "Double", 80, true));
//        roomsList.add(new Room(103, "Suite", 120, false));
//    }
//
//    private void addRoomManually() {
//        // Open a dialog or activity to allow the user to input room details
//        // For simplicity, let's create a dialog with EditText fields for room number, type, price, and availability
//        final Dialog addRoomDialog = new Dialog(MainActivity2.this);
//        addRoomDialog.setContentView(R.layout.add_room_dialog);
//
//        final EditText roomNumberEditText = addRoomDialog.findViewById(R.id.roomNumberEditText);
//        final EditText roomTypeEditText = addRoomDialog.findViewById(R.id.roomTypeEditText);
//        final EditText roomPriceEditText = addRoomDialog.findViewById(R.id.roomPriceEditText);
//        final EditText roomAvailabilityEditText = addRoomDialog.findViewById(R.id.roomAvailabilityEditText);
//        Button saveRoomButton = addRoomDialog.findViewById(R.id.saveRoomButton);
//
//        saveRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get input values
//                int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
//                String roomType = roomTypeEditText.getText().toString();
//                int roomPrice = Integer.parseInt(roomPriceEditText.getText().toString());
//                boolean roomAvailability = Boolean.parseBoolean(roomAvailabilityEditText.getText().toString());
//
//                // Create a new Room object and add it to roomsList
//                roomsList.add(new Room(roomNumber, roomType, roomPrice, roomAvailability));
//
//                // Close the dialog
//                addRoomDialog.dismiss();
//            }
//        });
//
//        addRoomDialog.show();
//    }
//}
//package com.example.hotelmanagement;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.app.Dialog;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.ArrayAdapter;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.ListView;
//        import android.widget.TextView;
//        import android.content.Intent;
//        import java.util.ArrayList;
//        import java.util.List;
//        import android.app.Dialog;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.ArrayAdapter;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.ListView;
//        import android.widget.TextView;
//        import java.util.ArrayList;
//        import java.util.Iterator;
//        import java.util.List;
//
//public class MainActivity2 extends AppCompatActivity {
//    private EditText inputRoomNumber;
//    private List<Room> roomsList = new ArrayList<>();
//    private Button showRoomsButton;
//    private TextView displayRoomsTextView;
//    private Button addRoomButton;
//    private List<Room> availableRoomsList = new ArrayList<>();
//    private ListView availableRoomsListView;
//    private ArrayAdapter<String> adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        Intent intent=getIntent();
//        inputRoomNumber = findViewById(R.id.inputRoomNumber);
//        showRoomsButton = findViewById(R.id.showRoomsButton);
//        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
//        addRoomButton = findViewById(R.id.addRoomButton);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//        availableRoomsListView.setAdapter(adapter);
//
//        // Set click listener for showRoomsButton
//        showRoomsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String roomNumber = inputRoomNumber.getText().toString();
//                displayAvailableRooms(roomNumber);
//            }
//        });
//
//        // Set click listener for addRoomButton
//        addRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addRoomManually();
//            }
//        });
//        availableRoomsList.add(new Room(101, "Single", 50, true));
//        availableRoomsList.add(new Room(102, "Double", 80, true));
//        availableRoomsList.add(new Room(103, "Suite", 120, false));
//        availableRoomsList.add(new Room(105, "Single", 50, true));
//        availableRoomsList.add(new Room(106, "Double", 80, true));
//        availableRoomsList.add(new Room(107, "Single", 50, true));
//        availableRoomsList.add(new Room(108, "Double", 80, true));
//        // Initialize roomsList with some sample data (you can remove this in production)
//        roomsList.add(new Room(101, "Single", 50, true));
//        roomsList.add(new Room(102, "Double", 80, true));
//        roomsList.add(new Room(103, "Suite", 120, false));
//        updateAvailableRoomsList();
//    }
//
//    private void displayAvailableRooms(String roomNumber) {
//        // Implementation of displayAvailableRooms method
//        Dialog dialog = new Dialog(MainActivity2.this);
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
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity2.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == Integer.parseInt(roomNumber) && room.getAvailability()) {
//                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
//                        .append(" | Type: ").append(room.getRoomType())
//                        .append(" | Price: $").append(room.getPrice()).append("\n");
//                // Add special features display if needed
//            }
//        }
//        // Display availableRoomsText to the user (e.g., in a TextView)
//        displayRoomsTextView.setText(availableRoomsText.toString());
//    }
//
//    private void addRoomManually() {
//        // Implementation of addRoomManually method
//        final Dialog addRoomDialog = new Dialog(MainActivity2.this);
//        addRoomDialog.setContentView(R.layout.add_room_dialog);
//
//        final EditText roomNumberEditText = addRoomDialog.findViewById(R.id.roomNumberEditText);
//        final EditText roomTypeEditText = addRoomDialog.findViewById(R.id.roomTypeEditText);
//        final EditText roomPriceEditText = addRoomDialog.findViewById(R.id.roomPriceEditText);
//        final EditText roomAvailabilityEditText = addRoomDialog.findViewById(R.id.roomAvailabilityEditText);
//        Button saveRoomButton = addRoomDialog.findViewById(R.id.saveRoomButton);
//
//        saveRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get input values
//                int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
//                String roomType = roomTypeEditText.getText().toString();
//                int roomPrice = Integer.parseInt(roomPriceEditText.getText().toString());
//                boolean roomAvailability = Boolean.parseBoolean(roomAvailabilityEditText.getText().toString());
//
//                // Create a new Room object and add it to roomsList
//                roomsList.add(new Room(roomNumber, roomType, roomPrice, roomAvailability));
//                updateAvailableRoomsList();
//
//                // Close the dialog
//                addRoomDialog.dismiss();
//            }
//        });
//
//        addRoomDialog.show();
//    }
//    private void updateAvailableRoomsList() {
//        // Clear the adapter
//        adapter.clear();
//
//        // Populate the adapter with available rooms data
//        for (Room room : availableRoomsList) {
//            if (room.getAvailability()) {
//                adapter.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        // Notify the adapter of changes
//        adapter.notifyDataSetChanged();
//    }
//
//    public void bookRoom(int roomNumber) {
//        // Find and book the room
//        Iterator<Room> iterator = availableRoomsList.iterator();
//        while (iterator.hasNext()) {
//            Room room = iterator.next();
//            if (room.getRoomNumber() == roomNumber) {
//                room.setAvailability(false);
//                break;
//            }
//        }
//
//        // Update the available rooms list
//        updateAvailableRoomsList();
//    }
//
//}









//
//
//package com.example.hotelmanagement;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.content.Intent;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class MainActivity2 extends AppCompatActivity {
//    private EditText inputRoomNumber;
//    private List<Room> roomsList = new ArrayList<>();
//    private Button showRoomsButton;
//    private TextView displayRoomsTextView;
//    private Button addRoomButton;
//    private List<Room> availableRoomsList = new ArrayList<>();
//    private ListView availableRoomsListView;
//    private ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        Intent intent = getIntent(); // Get the intent from the first page
//        inputRoomNumber = findViewById(R.id.inputRoomNumber);
//        showRoomsButton = findViewById(R.id.showRoomsButton);
//        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
//        addRoomButton = findViewById(R.id.addRoomButton);
//        //ListView availableRoomsListView = findViewById(R.id.availableRoomsListView);
//
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//
//
//
//        availableRoomsListView.setAdapter(adapter);
//        //availableRoomsListView = findViewById(R.id.availableRoomsListView);
//
//        // Set click listener for showRoomsButton
//        showRoomsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String roomNumber = inputRoomNumber.getText().toString();
//                displayAvailableRooms(roomNumber);
//            }
//        });
//
//        // Set click listener for addRoomButton
//        addRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addRoomManually();
//            }
//        });
//
//        // Initialize available rooms with sample data (you can remove this in production)
//        availableRoomsList.add(new Room(101, "Single", 50, true));
//        availableRoomsList.add(new Room(102, "Double", 80, true));
//        availableRoomsList.add(new Room(103, "Suite", 120, false));
//        availableRoomsList.add(new Room(105, "Single", 50, true));
//        availableRoomsList.add(new Room(106, "Double", 80, true));
//        availableRoomsList.add(new Room(107, "Single", 50, true));
//        availableRoomsList.add(new Room(108, "Double", 80, true));
//
//        // Initialize roomsList with some sample data (you can remove this in production)
//        roomsList.add(new Room(101, "Single", 50, true));
//        roomsList.add(new Room(102, "Double", 80, true));
//        roomsList.add(new Room(103, "Suite", 120, false));
//
//        updateAvailableRoomsList();
//    }
//
//    private void displayAvailableRooms(String roomNumber) {
//        // Implementation of displayAvailableRooms method
//        Dialog dialog = new Dialog(MainActivity2.this);
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
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity2.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == Integer.parseInt(roomNumber) && room.getAvailability()) {
//                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
//                        .append(" | Type: ").append(room.getRoomType())
//                        .append(" | Price: $").append(room.getPrice()).append("\n");
//                // Add special features display if needed
//            }
//        }
//        // Display availableRoomsText to the user (e.g., in a TextView)
//        displayRoomsTextView.setText(availableRoomsText.toString());
//    }
//
//    private void addRoomManually() {
//        // Implementation of addRoomManually method
//        final Dialog addRoomDialog = new Dialog(MainActivity2.this);
//        addRoomDialog.setContentView(R.layout.add_room_dialog);
//
//        final EditText roomNumberEditText = addRoomDialog.findViewById(R.id.roomNumberEditText);
//        final EditText roomTypeEditText = addRoomDialog.findViewById(R.id.roomTypeEditText);
//        final EditText roomPriceEditText = addRoomDialog.findViewById(R.id.roomPriceEditText);
//        final EditText roomAvailabilityEditText = addRoomDialog.findViewById(R.id.roomAvailabilityEditText);
//        Button saveRoomButton = addRoomDialog.findViewById(R.id.saveRoomButton);
//
//        saveRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get input values
//                int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
//                String roomType = roomTypeEditText.getText().toString();
//                int roomPrice = Integer.parseInt(roomPriceEditText.getText().toString());
//                boolean roomAvailability = Boolean.parseBoolean(roomAvailabilityEditText.getText().toString());
//
//                // Create a new Room object and add it to roomsList
//                roomsList.add(new Room(roomNumber, roomType, roomPrice, roomAvailability));
//                updateAvailableRoomsList();
//
//                // Close the dialog
//                addRoomDialog.dismiss();
//            }
//        });
//
//        addRoomDialog.show();
//    }
//
//    private void updateAvailableRoomsList() {
//        // Clear the adapter
//        adapter.clear();
//
//        // Populate the adapter with available rooms data
//        for (Room room : availableRoomsList) {
//            if (room.getAvailability()) {
//                adapter.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        // Notify the adapter of changes
//        adapter.notifyDataSetChanged();
//    }
//
//    public void bookRoom(int roomNumber) {
//        // Find and book the room
//        Iterator<Room> iterator = availableRoomsList.iterator();
//        while (iterator.hasNext()) {
//            Room room = iterator.next();
//            if (room.getRoomNumber() == roomNumber) {
//                room.setAvailability(false);
//                break;
//            }
//        }
//
//        // Update the available rooms list
//        updateAvailableRoomsList();
//    }
//}


//
//package com.example.hotelmanagement;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class MainActivity2 extends AppCompatActivity {
//    private EditText inputRoomNumber;
//    private List<Room> roomsList = new ArrayList<>();
//    private Button showRoomsButton;
//    private TextView displayRoomsTextView;
//    private Button addRoomButton;
//    private List<Room> availableRoomsList = new ArrayList<>();
//    private ListView availableRoomsListView;
//    private ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        Intent intent1 = getIntent();
//        inputRoomNumber = findViewById(R.id.inputRoomNumber);
//        showRoomsButton = findViewById(R.id.showRoomsButton);
//        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
//        addRoomButton = findViewById(R.id.addRoomButton);
//        availableRoomsListView = findViewById(R.id.availableRoomsListView); // Initialize ListView
//
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//        availableRoomsListView.setAdapter(adapter); // Set adapter to ListView
//
//        // Set click listener for showRoomsButton
//        showRoomsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String roomNumber = inputRoomNumber.getText().toString();
//                displayAvailableRooms(roomNumber);
//            }
//        });
//
//        // Set click listener for addRoomButton
//        addRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addRoomManually();
//            }
//        });
//
//        // Initialize available rooms with sample data (you can remove this in production)
//        availableRoomsList.add(new Room(101, "Single", 50, true));
//        availableRoomsList.add(new Room(102, "Double", 80, true));
//        availableRoomsList.add(new Room(103, "Suite", 120, false));
//        availableRoomsList.add(new Room(105, "Single", 50, true));
//        availableRoomsList.add(new Room(106, "Double", 80, true));
//        availableRoomsList.add(new Room(107, "Single", 50, true));
//        availableRoomsList.add(new Room(108, "Double", 80, true));
//
//        // Initialize roomsList with some sample data (you can remove this in production)
//        roomsList.add(new Room(101, "Single", 50, true));
//        roomsList.add(new Room(102, "Double", 80, true));
//        roomsList.add(new Room(103, "Suite", 120, false));
//
//        updateAvailableRoomsList();
//    }
//
//    private void displayAvailableRooms(String roomNumber) {
//        // Implementation of displayAvailableRooms method
//        Dialog dialog = new Dialog(MainActivity2.this);
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
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity2.this,
//                android.R.layout.simple_list_item_1, availableRoomsData);
//        availableRoomsListView.setAdapter(adapter);
//
//        dialog.show();
//        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
//        for (Room room : roomsList) {
//            if (room.getRoomNumber() == Integer.parseInt(roomNumber) && room.getAvailability()) {
//                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
//                        .append(" | Type: ").append(room.getRoomType())
//                        .append(" | Price: $").append(room.getPrice()).append("\n");
//                // Add special features display if needed
//            }
//        }
//        // Display availableRoomsText to the user (e.g., in a TextView)
//        displayRoomsTextView.setText(availableRoomsText.toString());
//    }
//
//    private void addRoomManually() {
//        // Implementation of addRoomManually method
//        final Dialog addRoomDialog = new Dialog(MainActivity2.this);
//        addRoomDialog.setContentView(R.layout.add_room_dialog);
//
//        final EditText roomNumberEditText = addRoomDialog.findViewById(R.id.roomNumberEditText);
//        final EditText roomTypeEditText = addRoomDialog.findViewById(R.id.roomTypeEditText);
//        final EditText roomPriceEditText = addRoomDialog.findViewById(R.id.roomPriceEditText);
//        final EditText roomAvailabilityEditText = addRoomDialog.findViewById(R.id.roomAvailabilityEditText);
//        Button saveRoomButton = addRoomDialog.findViewById(R.id.saveRoomButton);
//
//        saveRoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Get input values
//                int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
//                String roomType = roomTypeEditText.getText().toString();
//                int roomPrice = Integer.parseInt(roomPriceEditText.getText().toString());
//                boolean roomAvailability = Boolean.parseBoolean(roomAvailabilityEditText.getText().toString());
//
//                // Create a new Room object and add it to roomsList
//                roomsList.add(new Room(roomNumber, roomType, roomPrice, roomAvailability));
//                updateAvailableRoomsList();
//
//                // Close the dialog
//                addRoomDialog.dismiss();
//            }
//        });
//
//        addRoomDialog.show();
//    }
//
//    private void updateAvailableRoomsList() {
//        // Clear the adapter
//        adapter.clear();
//
//        // Populate the adapter with available rooms data
//        for (Room room : availableRoomsList) {
//            if (room.getAvailability()) {
//                adapter.add("Room Number: " + room.getRoomNumber() +
//                        " | Type: " + room.getRoomType() +
//                        " | Price: $" + room.getPrice());
//            }
//        }
//
//        // Notify the adapter of changes
//        adapter.notifyDataSetChanged();
//    }
//
//    public void bookRoom(int roomNumber) {
//        // Find and book the room
//        Iterator<Room> iterator = availableRoomsList.iterator();
//        while (iterator.hasNext()) {
//            Room room = iterator.next();
//            if (room.getRoomNumber() == roomNumber) {
//                room.setAvailability(false);
//                break;
//            }
//   }
//
//        // Update the available rooms list
//        updateAvailableRoomsList();
//    }
//}
//
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

public class MainActivity2 extends AppCompatActivity {
    private EditText inputRoomNumber;
    private List<Room> roomsList = new ArrayList<>();
    private Button showRoomsButton;
    private TextView displayRoomsTextView;
    private Button addRoomButton;
    private List<Room> availableRoomsList = new ArrayList<>();
    private ListView availableRoomsListView;
    private ArrayAdapter<String> adapter;
    private int bookedRoomNumber; // New variable to store the booked room number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputRoomNumber = findViewById(R.id.inputRoomNumber);
        showRoomsButton = findViewById(R.id.showRoomsButton);
        displayRoomsTextView = findViewById(R.id.displayRoomsTextView);
        addRoomButton = findViewById(R.id.addRoomButton);
        availableRoomsListView = findViewById(R.id.availableRoomsListView);

        // Initialize adapter and set it to the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        availableRoomsListView.setAdapter(adapter);

        // Check if there is an intent from MainActivity1
        Intent intent = getIntent();
        if (intent != null) {
            bookedRoomNumber = intent.getIntExtra("bookedRoomNumber", -1);
            if (bookedRoomNumber != -1) {
                // Room booked successfully, handle accordingly
                // For example, you can display a message or update your UI
                displayRoomsTextView.setText("Room " + bookedRoomNumber + " booked successfully!");
            }
        }

        // Set click listener for showRoomsButton
        showRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomNumber = inputRoomNumber.getText().toString();
                displayAvailableRooms(roomNumber);
            }
        });

        // Set click listener for addRoomButton
        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRoomManually();
            }
        });

        // Initialize available rooms with sample data (you can remove this in production)
        availableRoomsList.add(new Room(101, "Single", 50, true));
        availableRoomsList.add(new Room(102, "Double", 80, true));
        availableRoomsList.add(new Room(103, "Suite", 120, false));
        availableRoomsList.add(new Room(105, "Single", 50, true));
        availableRoomsList.add(new Room(106, "Double", 80, true));
        availableRoomsList.add(new Room(107, "Single", 50, true));
        availableRoomsList.add(new Room(108, "Double", 80, true));

        // Initialize roomsList with some sample data (you can remove this in production)
        roomsList.add(new Room(101, "Single", 50, true));
        roomsList.add(new Room(102, "Double", 80, true));
        roomsList.add(new Room(103, "Suite", 120, false));

        updateAvailableRoomsList();
    }

    // Rest of your MainActivity2 code...
    private void displayAvailableRooms(String roomNumber) {
        // Implementation of displayAvailableRooms method
        Dialog dialog = new Dialog(MainActivity2.this);
        dialog.setContentView(R.layout.available_rooms_dialog);

        //TextView availableRoomsDialogTitle = dialog.findViewById(R.id.availableRoomsDialogTitle);
        ListView availableRoomsListView = dialog.findViewById(R.id.availableRoomsListView);

        // Populate availableRoomsListView with data from availableRoomsList
        List<String> availableRoomsData = new ArrayList<>();
        for (Room room : availableRoomsList) {
            if (room.getAvailability()) {
                availableRoomsData.add("Room Number: " + room.getRoomNumber() +
                        " | Type: " + room.getRoomType() +
                        " | Price: $" + room.getPrice());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity2.this,
                android.R.layout.simple_list_item_1, availableRoomsData);
        availableRoomsListView.setAdapter(adapter);

        dialog.show();
        StringBuilder availableRoomsText = new StringBuilder("Available Rooms:\n");
        for (Room room : availableRoomsList) {
            if (room.getRoomNumber() == Integer.parseInt(roomNumber) && room.getAvailability()) {
                availableRoomsText.append("Room Number: ").append(room.getRoomNumber())
                        .append(" | Type: ").append(room.getRoomType())
                        .append(" | Price: $").append(room.getPrice()).append("\n");
                // Add special features display if needed
            }
        }
        // Display availableRoomsText to the user (e.g., in a TextView)
        displayRoomsTextView.setText(availableRoomsText.toString());
    }

    private void addRoomManually() {
        // Implementation of addRoomManually method
        final Dialog addRoomDialog = new Dialog(MainActivity2.this);
        addRoomDialog.setContentView(R.layout.add_room_dialog);

        final EditText roomNumberEditText = addRoomDialog.findViewById(R.id.roomNumberEditText);
        final EditText roomTypeEditText = addRoomDialog.findViewById(R.id.roomTypeEditText);
        final EditText roomPriceEditText = addRoomDialog.findViewById(R.id.roomPriceEditText);
        final EditText roomAvailabilityEditText = addRoomDialog.findViewById(R.id.roomAvailabilityEditText);
        Button saveRoomButton = addRoomDialog.findViewById(R.id.saveRoomButton);

        saveRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                int roomNumber = Integer.parseInt(roomNumberEditText.getText().toString());
                String roomType = roomTypeEditText.getText().toString();
                int roomPrice = Integer.parseInt(roomPriceEditText.getText().toString());
                boolean roomAvailability = Boolean.parseBoolean(roomAvailabilityEditText.getText().toString());

                // Create a new Room object and add it to roomsList
                roomsList.add(new Room(roomNumber, roomType, roomPrice, roomAvailability));
                updateAvailableRoomsList();

                // Close the dialog
                addRoomDialog.dismiss();
            }
        });

        addRoomDialog.show();
    }

    private void updateAvailableRoomsList() {
        // Clear the adapter
        adapter.clear();

        // Populate the adapter with available rooms data
        for (Room room : availableRoomsList) {
            if (room.getAvailability()) {
                adapter.add("Room Number: " + room.getRoomNumber() +
                        " | Type: " + room.getRoomType() +
                        " | Price: $" + room.getPrice());
            }
        }

        // Notify the adapter of changes
        adapter.notifyDataSetChanged();
    }
//    public void bookRoom(int roomNumber) {
//        // Find and book the room
//        Iterator<Room> iterator = availableRoomsList.iterator();
//        while (iterator.hasNext()) {
//            Room room = iterator.next();
//            if (room.getRoomNumber() == roomNumber) {
//                room.setAvailability(false);
//                break;
//            }
//        }
//
//        // Update the available rooms list
//        updateAvailableRoomsList();
//    }
}


