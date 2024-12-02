package com.example.medicationreminder.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.medicationreminder.R;
import com.example.medicationreminder.database.DatabaseHelper;

public class AddMedicationActivity extends AppCompatActivity {

    private EditText etMedicationName, etDose, etTime;
    private Button btnSaveMedication;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

        etMedicationName = findViewById(R.id.etMedicationName);
        etDose = findViewById(R.id.etDose);
        etTime = findViewById(R.id.etTime);
        btnSaveMedication = findViewById(R.id.btnSaveMedication);

        dbHelper = new DatabaseHelper(this);

        btnSaveMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String medicationName = etMedicationName.getText().toString();
                String dose = etDose.getText().toString();
                String time = etTime.getText().toString();

                if (medicationName.isEmpty() || dose.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AddMedicationActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isMedicationAdded = dbHelper.addMedication(medicationName, dose, time);
                    if (isMedicationAdded) {
                        Toast.makeText(AddMedicationActivity.this, "Medication added successfully", Toast.LENGTH_SHORT).show();
                        finish();  // Close the activity and return to the main screen
                    } else {
                        Toast.makeText(AddMedicationActivity.this, "Error adding medication", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
