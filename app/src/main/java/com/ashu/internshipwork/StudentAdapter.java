package com.ashu.internshipwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    List<StudentModel> studentList;

    public StudentAdapter(List<StudentModel> list) {
        this.studentList = list;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        StudentModel student = studentList.get(position);
        holder.tvName.setText("Name: " + student.getName());
        holder.tvRoll.setText("Roll No: " + student.getRollNo());
        holder.tvPassword.setText("Password: " + student.getPassword());
        holder.tvBus.setText("Bus: " + student.getBusNumber());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRoll, tvPassword, tvBus;

        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvRoll = itemView.findViewById(R.id.tvRoll);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            tvBus = itemView.findViewById(R.id.tvBus);
        }
    }
}
