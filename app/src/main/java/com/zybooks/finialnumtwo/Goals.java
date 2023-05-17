package com.zybooks.finialnumtwo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        Button addButton = (Button) findViewById(R.id.Addbtn);
        Button homeButton = (Button) findViewById(R.id.Homebtn);
        Button goalsButton = (Button) findViewById(R.id.Goalsbtn);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Goals.this, Add.class));
            }
        });

        goalsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Goals.this, Goals.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Goals.this, MainActivity.class));
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String Wrk = sharedPreferences.getString("input_Workout", "0");
        String WrkGoal = sharedPreferences.getString("input_workout_goal", "");
        String StepGoal = sharedPreferences.getString("input_step_goal", "");

        //for steps later on
        //String stp = sharedPreferences.getString("Step_Counter", 0);

        TextView txtStepGoalDisplay = (TextView) findViewById(R.id.stepGoalDisplay);
        TextView txtWorkoutGoalDisplay = (TextView) findViewById(R.id.workoutGoalDisplay);
        TextView txtWorkoutDisplay = (TextView) findViewById(R.id.workoutDisplay);

        TextView txtCalories = (TextView) findViewById(R.id.CalorieCount);

        //for steps
        int IntStepHolder = sharedPreferences.getInt("Step_Counter", 0);
        TextView txtStepDisplay = (TextView) findViewById(R.id.stepDisplay);
        int TrueValue = IntStepHolder;

        double calculatedTotal = IntStepHolder * 0.35;

        txtCalories.setText(calculatedTotal + " Calories");

        txtStepGoalDisplay.setText(txtStepGoalDisplay.getText() + StepGoal + " Steps");
        txtWorkoutGoalDisplay.setText(txtWorkoutGoalDisplay.getText() + WrkGoal);
        txtWorkoutDisplay.setText(txtWorkoutDisplay.getText() + Wrk+ " min");

        //for steps
        txtStepDisplay.setText(TrueValue + " Steps");

        //0.35 calories per step

    }
}
