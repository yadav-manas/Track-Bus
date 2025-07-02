package com.ashu.internshipwork;

import android.app.AlertDialog;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentManageAdapter extends RecyclerView.Adapter<StudentManageAdapter.ViewHolder> {

    private List<StudentModel> list;

    public StudentManageAdapter(List<StudentModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manage_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int pos) {
        StudentModel m = list.get(pos);
        h.tvLine1.setText("Name: " + m.getName());
        h.tvLine2.setText("Roll No: " + m.getRollNo());
        h.tvLine3.setText("Password: " + m.getPassword());
        h.tvLine4.setText("Bus No: " + m.getBusNumber());

        h.btnEdit.setOnClickListener(v -> showEditDialog(h.itemView, pos));
        h.btnDelete.setOnClickListener(v -> {
            list.remove(pos);
            GlobalData.studentModels.removeIf(s -> s.getRollNo().equals(m.getRollNo()));
            notifyItemRemoved(pos);
            notifyItemRangeChanged(pos, list.size());
            Toast.makeText(v.getContext(), "Deleted: " + m.getRollNo(), Toast.LENGTH_SHORT).show();
        });
    }

    private void showEditDialog(View contextView, int position) {
        StudentModel model = list.get(position);
        View dialogView = LayoutInflater.from(contextView.getContext()).inflate(R.layout.dialog_edit_student, null);

        EditText etName = dialogView.findViewById(R.id.etEditName);
        EditText etRoll = dialogView.findViewById(R.id.etEditRoll);
        EditText etPassword = dialogView.findViewById(R.id.etEditPassword);
        EditText etBusNo = dialogView.findViewById(R.id.etEditBusNo);

        etName.setText(model.getName());
        etRoll.setText(model.getRollNo());
        etPassword.setText(model.getPassword());
        etBusNo.setText(model.getBusNumber());

        new AlertDialog.Builder(contextView.getContext())
                .setTitle("Edit Student")
                .setView(dialogView)
                .setPositiveButton("Update", (dialog, which) -> {
                    String newName = etName.getText().toString().trim();
                    String newRoll = etRoll.getText().toString().trim();
                    String newPass = etPassword.getText().toString().trim();
                    String newBus = etBusNo.getText().toString().trim();

                    StudentModel updated = new StudentModel(newName, newRoll, newPass, newBus);
                    list.set(position, updated);

                    for (int i = 0; i < GlobalData.studentModels.size(); i++) {
                        if (GlobalData.studentModels.get(i).getRollNo().equals(model.getRollNo())) {
                            GlobalData.studentModels.set(i, updated);
                            break;
                        }
                    }

                    notifyItemChanged(position);
                    Toast.makeText(contextView.getContext(), "Updated", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvLine1, tvLine2, tvLine3, tvLine4;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLine1 = itemView.findViewById(R.id.tvLine1);
            tvLine2 = itemView.findViewById(R.id.tvLine2);
            tvLine3 = itemView.findViewById(R.id.tvLine3);
            tvLine4 = itemView.findViewById(R.id.tvLine4);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
