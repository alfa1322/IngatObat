package com.example.medicationreminder.activities;

import android.os.Bundle;
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
    private MedicationAdapter adapter;
    private DatabaseHelper dbHelper;
    private List<Medication> medicationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DatabaseHelper(this);

        // Get the list of medications from the database
        medicationList = dbHelper.getAllMedications();

        adapter = new MedicationAdapter(medicationList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
