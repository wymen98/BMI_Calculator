package my.edu.tarc.bmi_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView BMIValueMessage;
        BMIValueMessage = findViewById(R.id.BMIValueMessage);

        ImageView imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();

        if(intent.hasExtra(MainActivity.TAG_MESSAGE)){
            double BMIValue = intent.getDoubleExtra(MainActivity.TAG_MESSAGE, 0);
            BMIValue = Double.parseDouble(String.format("%.2f",BMIValue));

            if(BMIValue <= 18.5){
                imageView.setImageResource(R.drawable.under);
            } else if(BMIValue > 18.5 && BMIValue <= 25){
                imageView.setImageResource(R.drawable.normal);
            }else{
                imageView.setImageResource(R.drawable.over);
            }

            BMIValueMessage.setText("BMI: " + BMIValue);
        }
    }
}
