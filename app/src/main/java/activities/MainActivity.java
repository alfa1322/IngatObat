package com.example.medicationreminder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.medicationreminder.R;
import com.example.medicationreminder.adapters.MedicationAdapter;
import com.example.medicationreminder.database.DatabaseHelper;
import com.example.medicationreminder.models.Medication;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedicationAdapter medicationAdapter;
    private DatabaseHelper dbHelper;
    private Button btnAddMedication;
    private List<Medication> medicationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAddMedication = findViewById(R.id.btnAddMedication);
        dbHelper = new DatabaseHelper(this);

        // Fetch medications from database
        medicationList = dbHelper.getAllMedications();

        medicationAdapter = new MedicationAdapter(medicationList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(medicationAdapter);

        // OnClickListener to add new medication
        btnAddMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMedicationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the medication list when returning to MainActivity
        medicationList.clear();
        medicationList.addAll(dbHelper.getAllMedications());
        medicationAdapter.notifyDataSetChanged();
    }
}
