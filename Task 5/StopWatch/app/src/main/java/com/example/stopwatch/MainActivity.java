package com.example.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


        private TextView tvTimer;
        private Button btnStart, btnStop, btnHold, btnContinue;
        private Handler handler;
        private long startTime, elapsedTime;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tvTimer = findViewById(R.id.tv_timer);
            btnStart = findViewById(R.id.btn_start);
            btnStop = findViewById(R.id.btn_stop);
            btnHold = findViewById(R.id.btn_hold);
            btnContinue = findViewById(R.id.btn_continue);

            handler = new Handler();

            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnStart.getText().equals("Start")) {
                        startTime = System.currentTimeMillis();
                        handler.postDelayed(updateTimer, 0);
                        btnStart.setText("Pause");
                    } else if (btnStart.getText().equals("Pause")) {
                        handler.removeCallbacks(updateTimer);
                        btnStart.setText("Resume");
                    } else if (btnStart.getText().equals("Resume")) {
                        startTime = System.currentTimeMillis() - elapsedTime;
                        handler.postDelayed(updateTimer, 0);
                        btnStart.setText("Pause");
                    }
                }
            });

            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.removeCallbacks(updateTimer);
                    elapsedTime = 0;
                    tvTimer.setText("00:00:00");
                    btnStart.setText("Start");
                }
            });

            btnHold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.removeCallbacks(updateTimer);
                    elapsedTime = System.currentTimeMillis() - startTime;
                    btnStart.setText("Resume");
                }
            });

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startTime = System.currentTimeMillis() - elapsedTime;
                    handler.postDelayed(updateTimer, 0);
                    btnStart.setText("Pause");
                }
            });
        }

        private Runnable updateTimer = new Runnable() {
            @Override
            public void run() {
                elapsedTime = System.currentTimeMillis() - startTime;

                int hours = (int) (elapsedTime / (60 * 60 * 1000));
                int minutes = (int) ((elapsedTime / (60 * 1000)) % 60);
                int seconds = (int) ((elapsedTime / 1000) % 60);

                String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                tvTimer.setText(time);

                handler.postDelayed(this, 1000);
            }
        };
    }
