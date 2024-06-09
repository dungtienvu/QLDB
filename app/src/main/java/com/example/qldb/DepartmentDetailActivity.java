package com.example.qldb;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DepartmentDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_detail);

        Department department = (Department) getIntent().getSerializableExtra("department");

        TextView nameTextView = findViewById(R.id.department_name);
        TextView detailsTextView = findViewById(R.id.department_details);

        if (department != null) {
            nameTextView.setText(department.getName());
            detailsTextView.setText(department.getDetails());
        }
    }
}
