package com.codellion.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean state = false;
    public void swapClick(View view){

        if(state){
            rupeeToDollar();
        }
        else{
            dollarToRupee();
        }
    }

    private void dollarToRupee(){
        state = true;
        ImageView dollarImage, rupeeImage;
        dollarImage = (ImageView) findViewById(R.id.dollarImage);
        rupeeImage = (ImageView) findViewById(R.id.rupeesImage);
        TextView text = (TextView) findViewById(R.id.conversionText);
        text.setText(getString(R.string.content_torupees));
        dollarImage.setImageResource(R.drawable.rupees);
        rupeeImage.setImageResource(R.drawable.dollars);
    }

    private void rupeeToDollar(){
        state = false;
        ImageView dollarImage, rupeeImage;
        dollarImage = (ImageView) findViewById(R.id.dollarImage);
        rupeeImage = (ImageView) findViewById(R.id.rupeesImage);
        TextView text = (TextView) findViewById(R.id.conversionText);
        text.setText(getString(R.string.content_todollar));
        dollarImage.setImageResource(R.drawable.dollars);
        rupeeImage.setImageResource(R.drawable.rupees);
    }

    public void clickConvert(View view){
        double conversionNumber = 75.62;
        EditText amount = (EditText) findViewById(R.id.enterAmount);
        TextView convertedAmout = (TextView) findViewById(R.id.result);
        if(state){
            String enteredAmountStr = amount.getText().toString();
            double enterdDollarAmount = Double.parseDouble(enteredAmountStr);
            double result = enterdDollarAmount * conversionNumber;
            String displayResult = Double.toString(result);
            String ans = "₹   "+displayResult;
            convertedAmout.setText(ans);
        }
        else{
            String enteredAmountStr = amount.getText().toString();
            double enterdDollarAmount = Double.parseDouble(enteredAmountStr);
            double result = enterdDollarAmount / conversionNumber;
            String displayResult = Double.toString(result);
            String ans = "$   "+displayResult;
            convertedAmout.setText(ans);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
