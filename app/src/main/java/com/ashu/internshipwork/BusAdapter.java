package com.ashu.internshipwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    private List<BusModel> busList;

    public BusAdapter(List<BusModel> busList) {
        this.busList = busList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BusModel model = busList.get(position);
        holder.tvBusNumber.setText("Bus No: " + model.getBusNo());
        holder.tvRoute.setText("Route: " + model.getRoute());
        holder.tvCapacity.setText("Capacity: " + model.getCapacity());
    }

    @Override
    public int getItemCount() {
        return busList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBusNumber, tvRoute, tvCapacity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusNumber = itemView.findViewById(R.id.tvBusNumber);
            tvRoute = itemView.findViewById(R.id.tvRoute);
            tvCapacity = itemView.findViewById(R.id.tvCapacity);
        }
    }
}
