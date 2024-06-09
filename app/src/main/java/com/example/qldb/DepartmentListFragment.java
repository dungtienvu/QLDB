package com.example.qldb;

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

public class DepartmentListFragment extends Fragment {

    private List<Department> departmentList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department_list, container, false);

        // Initialize the department list (this would normally be fetched from a database or API)
        departmentList = new ArrayList<>();
        departmentList.add(new Department("Computer Science", "Details about CS department"));
        departmentList.add(new Department("Mechanical Engineering", "Details about ME department"));

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        com.example.qldb.DepartmentAdapter adapter = new com.example.qldb.DepartmentAdapter(departmentList, department -> {
            Intent intent = new Intent(getContext(), DepartmentDetailActivity.class);
            intent.putExtra("department", department);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}