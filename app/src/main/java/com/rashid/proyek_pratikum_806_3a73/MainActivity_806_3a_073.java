package com.rashid.proyek_pratikum_806_3a73;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_806_3a_073 extends AppCompatActivity {
    EditText tahun;
    Button proses, batal, keluar;
    TextView output;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_806_3a_073);
        tahun = findViewById(R.id.input);
        proses =findViewById(R.id.proses);
        batal = findViewById(R.id.batal);
        keluar = findViewById(R.id.keluar);
        output = findViewById(R.id.output);

        batal.setOnClickListener(v -> {
            if (tahun.getText().toString().isEmpty() && output.getText().toString().isEmpty()) {
                Toast.makeText(this, "Already Clear, DON'T SPAM!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            tahun.setText(null);
            output.setText(null);

        });

        keluar.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        proses.setOnClickListener(v -> {
            if(tahun.getText().toString().isEmpty()) {
                tahun.setError("Mohon Masukkan Tahun");
                return;
            }
            int inputTahun = Integer.parseInt(tahun.getText().toString());
            if (inputTahun % 400 == 0 || inputTahun % 4 == 0) {
                output.setText("Kabisat");
            } else if (inputTahun % 100 == 0) {
                output.setText("Bukan Kabisat");
            } else {
                output.setText("Bukan Kabisat");
            }
        });

    }
}