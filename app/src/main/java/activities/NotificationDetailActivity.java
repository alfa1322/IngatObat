package com.example.medicationreminder.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.medicationreminder.R;

public class NotificationDetailActivity extends AppCompatActivity {

    private TextView tvMedicationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        tvMedicationName = findViewById(R.id.tvMedicationName);

        String medicationName = getIntent().getStringExtra("medication_name");
        tvMedicationName.setText(medicationName);
    }
}
