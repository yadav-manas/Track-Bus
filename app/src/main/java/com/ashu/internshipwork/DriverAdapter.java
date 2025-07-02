package com.ashu.internshipwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {

    private List<DriverModel> driverList;

    public DriverAdapter(List<DriverModel> driverList) {
        this.driverList = driverList;
    }

    @Override
    public DriverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver, parent, false);
        return new DriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DriverViewHolder holder, int position) {
        DriverModel driver = driverList.get(position);
        holder.tvName.setText("Name: " + driver.getName());
        holder.tvBus.setText("Bus: " + driver.getBusNumber());
        holder.tvDriverId.setText("Driver ID: " + driver.getDriverId());
        holder.tvPassword.setText("Password: " + driver.getPassword());
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    static class DriverViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvBus, tvDriverId, tvPassword;

        public DriverViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvBus = itemView.findViewById(R.id.tvBus);
            tvDriverId = itemView.findViewById(R.id.tvDriverId);
            tvPassword = itemView.findViewById(R.id.tvPassword);
        }
    }
}
