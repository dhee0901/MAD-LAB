package com.example.studentdatabaseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteStudentActivity extends AppCompatActivity {

    EditText editTextRollNo;
    Button buttonDelete;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        myDb = new DatabaseHelper(this);

        editTextRollNo = findViewById(R.id.editTextRollNo);
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollNo = Integer.parseInt(editTextRollNo.getText().toString());

                Integer deletedRows = myDb.deleteData(rollNo);
                if (deletedRows > 0)
                    Toast.makeText(DeleteStudentActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DeleteStudentActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
