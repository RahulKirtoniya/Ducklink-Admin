package com.example.ducklinkadmin;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDetailsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> userList;
    private CustomListAdapter customListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);

        // Assuming you have a method to retrieve user data, otherwise, replace with your own data
        String[] usersArray = getUserData();
        userList = new ArrayList<>(Arrays.asList(usersArray));

        listView = findViewById(R.id.listview);
        customListAdapter = new CustomListAdapter(this, userList);
        listView.setAdapter(customListAdapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click, launch UserProfileActivity
                String selectedUser = userList.get(position);
                launchUserProfileActivity(selectedUser);
            }
        });
    }

    // Method to retrieve user data, replace with your own implementation
    private String[] getUserData() {
        // Example data
        return new String[]{"User 1", "User 2", "User 3", "User 4", "User 5", "User 6"};
    }

    // Method to launch UserProfileActivity
    private void launchUserProfileActivity(String selectedUser) {
        Intent intent = new Intent(UserDetailsActivity.this, UserProfileActivity.class);
        intent.putExtra("username", selectedUser);
        startActivity(intent);
    }
}
