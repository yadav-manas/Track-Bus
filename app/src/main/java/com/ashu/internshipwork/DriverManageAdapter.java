package com.ashu.internshipwork;

import android.app.AlertDialog;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DriverManageAdapter extends RecyclerView.Adapter<DriverManageAdapter.ViewHolder> {

    private List<DriverModel> list;

    public DriverManageAdapter(List<DriverModel> list) {
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
        DriverModel m = list.get(pos);
        h.tvLine1.setText("Name: " + m.getName());
        h.tvLine2.setText("Driver ID: " + m.getDriverId());
        h.tvLine3.setText("Password: " + m.getPassword());
        h.tvLine4.setText("Bus No: " + m.getBusNumber());

        h.btnEdit.setOnClickListener(v -> showEditDialog(h.itemView, pos));
        h.btnDelete.setOnClickListener(v -> {
            list.remove(pos);
            GlobalData.driverModels.removeIf(d -> d.getDriverId().equals(m.getDriverId()));
            notifyItemRemoved(pos);
            notifyItemRangeChanged(pos, list.size());
            Toast.makeText(v.getContext(), "Deleted: " + m.getDriverId(), Toast.LENGTH_SHORT).show();
        });
    }

    private void showEditDialog(View contextView, int position) {
        DriverModel model = list.get(position);
        View dialogView = LayoutInflater.from(contextView.getContext()).inflate(R.layout.dialog_edit_driver, null);

        EditText etName = dialogView.findViewById(R.id.etEditName);
        EditText etId = dialogView.findViewById(R.id.etEditDriverId);
        EditText etPassword = dialogView.findViewById(R.id.etEditPassword);
        EditText etBusNo = dialogView.findViewById(R.id.etEditBusNo);

        etName.setText(model.getName());
        etId.setText(model.getDriverId());
        etPassword.setText(model.getPassword());
        etBusNo.setText(model.getBusNumber());

        new AlertDialog.Builder(contextView.getContext())
                .setTitle("Edit Driver")
                .setView(dialogView)
                .setPositiveButton("Update", (dialog, which) -> {
                    String newName = etName.getText().toString().trim();
                    String newId = etId.getText().toString().trim();
                    String newPass = etPassword.getText().toString().trim();
                    String newBus = etBusNo.getText().toString().trim();

                    DriverModel updated = new DriverModel(newName, newBus, newId, newPass);
                    list.set(position, updated);

                    // update global list
                    for (int i = 0; i < GlobalData.driverModels.size(); i++) {
                        if (GlobalData.driverModels.get(i).getDriverId().equals(model.getDriverId())) {
                            GlobalData.driverModels.set(i, updated);
                            break;
                        }
                    }

                    notifyItemChanged(position);
                    Toast.makeText(contextView.getContext(), "Updated: " + newId, Toast.LENGTH_SHORT).show();
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
