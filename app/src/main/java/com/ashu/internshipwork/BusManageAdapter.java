package com.ashu.internshipwork;

import android.app.AlertDialog;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BusManageAdapter extends RecyclerView.Adapter<BusManageAdapter.ViewHolder> {

    private List<BusModel> list;

    public BusManageAdapter(List<BusModel> list) {
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
        BusModel m = list.get(pos);
        h.tvLine1.setText("Bus No: " + m.getBusNo());
        h.tvLine2.setText("Route: " + m.getRoute());
        h.tvLine3.setText("Capacity: " + m.getCapacity());
        h.tvLine4.setVisibility(View.GONE); // optional

        h.btnEdit.setOnClickListener(v -> showEditDialog(h.itemView, pos));
        h.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                .setTitle("Delete Bus")
                .setMessage("Are you sure you want to delete this bus? All related drivers and students will also be deleted.")
                .setPositiveButton("Delete", (dialog, which) -> {
                    // Remove related drivers
                    int driversRemoved = 0;
                    for (int i = GlobalData.driverModels.size() - 1; i >= 0; i--) {
                        if (GlobalData.driverModels.get(i).getBusNumber().equals(m.getBusNo())) {
                            GlobalData.driverModels.remove(i);
                            driversRemoved++;
                        }
                    }
                    // Remove related students
                    int studentsRemoved = 0;
                    for (int i = GlobalData.studentModels.size() - 1; i >= 0; i--) {
                        if (GlobalData.studentModels.get(i).getBusNumber().equals(m.getBusNo())) {
                            GlobalData.studentModels.remove(i);
                            studentsRemoved++;
                        }
                    }
                    // Remove bus
                    list.remove(pos);
                    GlobalData.busModels.removeIf(b -> b.getBusNo().equals(m.getBusNo()));
                    GlobalData.busList.removeIf(b -> b.equals(m.getBusNo()));
                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, list.size());
                    Toast.makeText(v.getContext(), "Deleted: " + m.getBusNo() + "\n" + driversRemoved + " drivers and " + studentsRemoved + " students also deleted.", Toast.LENGTH_LONG).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
        });
    }

    private void showEditDialog(View contextView, int position) {
        BusModel model = list.get(position);
        View dialogView = LayoutInflater.from(contextView.getContext()).inflate(R.layout.dialog_edit_bus, null);

        EditText etBusNo = dialogView.findViewById(R.id.etEditBusNo);
        EditText etRoute = dialogView.findViewById(R.id.etEditRoute);
        EditText etCapacity = dialogView.findViewById(R.id.etEditCapacity);

        etBusNo.setText(model.getBusNo());
        etRoute.setText(model.getRoute());
        etCapacity.setText(String.valueOf(model.getCapacity()));

        new AlertDialog.Builder(contextView.getContext())
                .setTitle("Edit Bus")
                .setView(dialogView)
                .setPositiveButton("Update", (dialog, which) -> {
                    String newNo = etBusNo.getText().toString().trim();
                    String newRoute = etRoute.getText().toString().trim();
                    int newCap = Integer.parseInt(etCapacity.getText().toString().trim());

                    BusModel updated = new BusModel(newNo, newRoute, newCap);
                    list.set(position, updated);

                    for (int i = 0; i < GlobalData.busModels.size(); i++) {
                        if (GlobalData.busModels.get(i).getBusNo().equals(model.getBusNo())) {
                            GlobalData.busModels.set(i, updated);
                            break;
                        }
                    }

                    GlobalData.busList.remove(model.getBusNo());
                    GlobalData.busList.add(newNo);

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
