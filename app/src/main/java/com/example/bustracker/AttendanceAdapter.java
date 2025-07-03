package com.example.bustracker;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    List<AttendanceModel> attendanceModelList;

    public AttendanceAdapter(List<AttendanceModel> attendanceModelList) {
        this.attendanceModelList = attendanceModelList;
    }

    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.ViewHolder holder, int position) {
        AttendanceModel model = attendanceModelList.get(position);
        holder.studentId.setText(model.getStudentId());
        holder.name.setText(model.getName());
        holder.checkbox.setOnCheckedChangeListener(null);

        holder.checkbox.setChecked(model.isPresent());
        holder.status_label.setText(model.isPresent() ? "Present" : "Absent");
        holder.status_label.setTextColor(model.isPresent()
                ? Color.parseColor("#2E7D32")  // green
                : Color.parseColor("#D32F2F")); // red

        // Set checkbox tick color
        int tickColor = model.isPresent() ? Color.parseColor("#2E7D32") : Color.parseColor("#D32F2F");
        holder.checkbox.setButtonTintList(ColorStateList.valueOf(tickColor));

        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.setPresent(isChecked);
            holder.status_label.setText(isChecked ? "Present" : "Absent");
            holder.status_label.setTextColor(isChecked
                    ? Color.parseColor("#2E7D32")
                    : Color.parseColor("#D32F2F"));
            int newTickColor = isChecked ? Color.parseColor("#2E7D32") : Color.parseColor("#D32F2F");
            holder.checkbox.setButtonTintList(ColorStateList.valueOf(newTickColor));
        });
    }


    @Override
    public int getItemCount() {

        return attendanceModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, studentId;
        CheckBox checkbox;
        ImageView profile;
        TextView status_label;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.list_student_name);
            studentId=itemView.findViewById(R.id.list_roll_no);
            checkbox=itemView.findViewById(R.id.present);
            profile=itemView.findViewById(R.id.img_profile);
            status_label=itemView.findViewById(R.id.status_label);

        }
    }
}
