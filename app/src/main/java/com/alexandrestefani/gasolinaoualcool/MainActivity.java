package com.alexandrestefani.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText alcohol;
    private TextInputEditText gas;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alcohol = findViewById(R.id.alcohol_price);
        gas = findViewById(R.id.gas_price);
        result = findViewById(R.id.result);

    }
    public void calculateBestChoise(View view){
        String precoAlcohol = alcohol.getText().toString();
        String precoGas = gas.getText().toString();

       if(validationFillUp(precoAlcohol,precoGas)){

           //Convert in Double
           Double alcohol = Double.parseDouble(precoAlcohol);
           Double gas = Double.parseDouble(precoGas);

           EngineCalculate engineCalculate = new EngineCalculate();
           Boolean resultCalculation = engineCalculate.engine(alcohol,gas);

            if(resultCalculation){
                result.setText(getText(R.string.gas));
            }else {
                result.setText(getText(R.string.alcohol));
            }
       }else{
           result.setText(getText(R.string.it_needs_more_dates));
       }



    }

    public Boolean validationFillUp(String pAlcohol,String pGas){
        Boolean variablesValidated = true;

        if(pAlcohol == null ||pAlcohol.equals("")){
            variablesValidated = false;
        } else if (pGas == null || pGas.equals("")){
            variablesValidated = false;
        }
        return variablesValidated;
    }
}