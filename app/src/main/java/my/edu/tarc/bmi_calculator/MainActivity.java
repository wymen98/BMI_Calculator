package my.edu.tarc.bmi_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.tarc.bmi_calculator.MESSAGE";
    private EditText weightTextMessage;
    private EditText heightTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightTextMessage = findViewById(R.id.weightTextMessage);
        heightTextMessage = findViewById(R.id.heightTextMessage);
    }

    public void calculateBMI(View view){
        double getWeight;
        double getHeight;
        double BMIResult;

        if(TextUtils.isEmpty(weightTextMessage.getText())){
            weightTextMessage.setError("Please enter your weight!!");
            return;
        }

        if(TextUtils.isEmpty(heightTextMessage.getText())){
            heightTextMessage.setError("Please enter your height!!");
            return;
        }

        getWeight = Double.parseDouble(weightTextMessage.getText().toString());
        getHeight = Double.parseDouble(heightTextMessage.getText().toString());

        BMIResult = getWeight / (getHeight/100 * getHeight/100);

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra(TAG_MESSAGE, BMIResult);

        startActivity(intent);
    }

}
