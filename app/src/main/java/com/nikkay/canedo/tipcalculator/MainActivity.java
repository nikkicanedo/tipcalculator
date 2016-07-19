package com.nikkay.canedo.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etBill;
    EditText etNumPeople;
    TextView tvTip;
    SeekBar tip_Percent;
    TextView tipPercentLabel;
    TextView tvTotalPerPerson;

    int tipPercent = 0;
    int numberOfPeep = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (EditText) findViewById(R.id.etBill);
        etNumPeople = (EditText) findViewById(R.id.etNumPeople);
        tvTip = (TextView) findViewById(R.id.tvTip);
        tip_Percent = (SeekBar) findViewById(R.id.seekBar);
        tipPercentLabel = (TextView)findViewById(R.id.tip_percent);
        tvTotalPerPerson = (TextView) findViewById(R.id.tvTotalPerPerson);



        tip_Percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercent = progress;

                double billAmount = Double.parseDouble(etBill.getText().toString());
                numberOfPeep = Integer.parseInt(etNumPeople.getText().toString());
                double totalToPay = (billAmount *tipPercent)/100;
                double totalTips = (billAmount + totalToPay);

                tvTotalPerPerson.setText(String.format("%.2f", totalToPay / numberOfPeep));
                tvTip.setText(String.format("%.2f", totalTips / numberOfPeep));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercentLabel.setText("Tip Percent - " + seekBar.getProgress());
            }
        });

        etNumPeople.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etBill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
