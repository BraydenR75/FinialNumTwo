package com.zybooks.finialnumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int StepCounter = 0;
    boolean activityActivated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txtStepCounterDisplay = (TextView) findViewById(R.id.countingSteps);

        // Sensor Manager: Purpose = "Manages all of the Sensors"
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Make a Sensor that specifically gets the Accelerometer
        Sensor sensorShake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {

                    float x_accel = sensorEvent.values[0];
                    float y_accel = sensorEvent.values[1];
                    float z_accel = sensorEvent.values[2];

                    if (x_accel > 2 || x_accel < -2 || y_accel > 12 || y_accel < -12 ||  z_accel > 2 || z_accel < -2) {
                        StepCounter = StepCounter + 1;
                        txtStepCounterDisplay.setText(StepCounter + " Steps");
                    }

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        // Defining the editor to edit the preferences with
        SharedPreferences.Editor editor = sharedPreferences.edit();

        sensorManager.registerListener(sensorEventListener, sensorShake, sensorManager.SENSOR_DELAY_NORMAL);

        Button reccStepsBtn = (Button) findViewById(R.id.reccStepsBtn);
        Button addButton = (Button) findViewById(R.id.Addbtn);
        Button homeButton = (Button) findViewById(R.id.Homebtn);
        Button goalsButton = (Button) findViewById(R.id.Goalsbtn);


        reccStepsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editor.putInt("Step_Counter", StepCounter);
                editor.apply();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Add.class));
            }
        });

        goalsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Goals.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

    }



}