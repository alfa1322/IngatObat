package com.example.medicationreminder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.medicationreminder.R;
import com.example.medicationreminder.models.Medication;
import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    private List<Medication> medicationList;

    public MedicationAdapter(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    @Override
    public MedicationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medication, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicationViewHolder holder, int position) {
        Medication medication = medicationList.get(position);
        holder.medicationName.setText(medication.getMedicationName());
        holder.dose.setText(medication.getDose());
        holder.time.setText(medication.getTime());
    }

    @Override
    public int getItemCount() {
        return medicationList.size();
    }

    public static class MedicationViewHolder extends RecyclerView.ViewHolder {

        TextView medicationName, dose, time;

        public MedicationViewHolder(View itemView) {
            super(itemView);
            medicationName = itemView.findViewById(R.id.medicationName);
            dose = itemView.findViewById(R.id.dose);
            time = itemView.findViewById(R.id.time);
        }
    }
}
