package com.example.studentdatabaseapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewStudentActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView listViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        myDb = new DatabaseHelper(this);
        listViewStudents = findViewById(R.id.listViewStudents);

        loadStudentData();
    }

    private void loadStudentData() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            // Show message if no data is found
            Toast.makeText(ViewStudentActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<String> studentList = new ArrayList<>();
        while (res.moveToNext()) {
            // Assuming columns: ROLL_NO, NAME, DEPARTMENT
            String data = "Roll No: " + res.getString(0) + "\n" +
                    "Name: " + res.getString(1) + "\n" +
                    "Department: " + res.getString(2);
            studentList.add(data);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listViewStudents.setAdapter(adapter);
    }
}
