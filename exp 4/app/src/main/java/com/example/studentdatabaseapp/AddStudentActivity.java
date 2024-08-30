package com.example.studentdatabaseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    EditText editTextRollNo, editTextName, editTextDepartment;
    Button buttonAdd;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDb = new DatabaseHelper(this);

        editTextRollNo = findViewById(R.id.editTextRollNo);
        editTextName = findViewById(R.id.editTextName);
        editTextDepartment = findViewById(R.id.editTextDepartment);
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
                String name = editTextName.getText().toString();
                String department = editTextDepartment.getText().toString();

                boolean isInserted = myDb.insertData(rollNo, name, department);
                if (isInserted)
                    Toast.makeText(AddStudentActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddStudentActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
