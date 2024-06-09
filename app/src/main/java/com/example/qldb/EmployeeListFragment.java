package com.example.qldb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListFragment extends Fragment {

    private List<Employee> employeeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);

        // Initialize the employee list (this would normally be fetched from a database or API)
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", "Software Engineer"));
        employeeList.add(new Employee("Jane Smith", "Mechanical Engineer"));

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EmployeeAdapter adapter = new EmployeeAdapter(employeeList, employee -> {
            Intent intent = new Intent(getContext(), EmployeeDetailActivity.class);
            intent.putExtra("employee", employee);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}