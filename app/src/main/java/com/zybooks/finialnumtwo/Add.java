package com.zybooks.finialnumtwo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        // Defining the editor to edit the preferences with
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText input_Workout = (EditText) findViewById(R.id.ipu_Workout);
        Spinner input_step_goal = (Spinner) findViewById(R.id.spi_step_goal);
        Spinner input_workout_goal = (Spinner) findViewById(R.id.spi_workout_goal);


        Button setGoalsBtn = (Button) findViewById(R.id.setGoalsBtn);

        setGoalsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editor.putString("input_step_goal", input_step_goal.getSelectedItem().toString());
                editor.putString("input_workout_goal", input_workout_goal.getSelectedItem().toString());
                editor.apply();
            }
        });

        Button recordWorkBtn = (Button) findViewById(R.id.recordWorkBtn);

        recordWorkBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editor.putString("input_Workout", String.valueOf(input_Workout.getText()));
                editor.apply();
            }
        });



        Button addButton = (Button) findViewById(R.id.Addbtn);
        Button homeButton = (Button) findViewById(R.id.Homebtn);
        Button goalsButton = (Button) findViewById(R.id.Goalsbtn);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Add.this, Add.class));
            }
        });

        goalsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Add.this, Goals.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Add.this, MainActivity.class));
            }
        });

    }
}
