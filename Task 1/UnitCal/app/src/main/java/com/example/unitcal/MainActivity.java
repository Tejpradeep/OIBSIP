package com.example.unitcal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton cmToMButton;
    private RadioButton mToCmButton;
    private TextView txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        cmToMButton = findViewById(R.id.cm_to_m);
        mToCmButton = findViewById(R.id.m_to_cm);
        txt=findViewById(R.id.txt);

    }

    public void convert(View view) {
        String inputText = editText.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double resultValue;

        if (cmToMButton.isChecked()) {
            resultValue = inputValue / 100.0;
            txt.setText(String.format("%.2f", resultValue)+ "Mt");
        } else {
            resultValue = inputValue * 100.0;
            txt.setText(String.format("%.2f", resultValue)+ "cm");
        }


    }
}
