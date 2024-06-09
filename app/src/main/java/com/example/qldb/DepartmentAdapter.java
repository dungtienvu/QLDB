package com.example.qldb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {
    private List<Department> departments;
    private OnDepartmentClickListener onDepartmentClickListener;

    public interface OnDepartmentClickListener {
        void onDepartmentClick(Department department);
    }

    public DepartmentAdapter(List<Department> departments, OnDepartmentClickListener listener) {
        this.departments = departments;
        this.onDepartmentClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Department department = departments.get(position);
        holder.nameTextView.setText(department.getName());
        holder.detailsTextView.setText(department.getDetails());
        holder.itemView.setOnClickListener(v -> onDepartmentClickListener.onDepartmentClick(department));
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView detailsTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.department_name);
            detailsTextView = itemView.findViewById(R.id.department_details);
        }
    }
}