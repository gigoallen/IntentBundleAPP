package com.gigoallen.intentbundle0518;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        CalBmi();
    }

    private void CalBmi() {

        double height, weight, bmi;

        Bundle bundle = this.getIntent().getExtras();

        if(bundle != null){

           height = Double.parseDouble(bundle.getString("HEIGHT"));
           weight = Double.parseDouble(bundle.getString("WEIGHT"));

           height = height/100;

           bmi = weight/(height*height);

           String result = "過輕";

           if(bmi<35 && bmi>=30)
               result = "中度肥胖";
           else if(bmi<30 && bmi>=27)
               result = "輕度肥胖";
            else if(bmi<27 && bmi>=24)
                result = "過重";
           else if(bmi>=25)
               result = "重度肥胖";
           else if(bmi<24 && bmi>=18.5)
               result = "正常";

            TextView txvBMI = findViewById(R.id.txvBMI);

            txvBMI.setText("你的BMI: " + bmi + "\n" + result);

        }
    }

    public void btnOK(View view) {
        finish();
    }

}
