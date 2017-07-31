package com.example.androidsunsun.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        mTextView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            mTextView.setText(mEditText.getText().toString());
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }
    public void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view,int hourOfDay,int minute) {
                mTextView.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                    if(hourOfDay >= 2 && 10 > hourOfDay){
                        mTextView.setText("おはよう");
                    }else if(hourOfDay >= 10 && 18 > hourOfDay){
                        mTextView.setText("こんにちは");
                    }else if(hourOfDay >= 18 || 2 > hourOfDay)
                        mTextView.setText("こんばんは");
                Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
            }
        },
                13,
                0,
                true);
        timePickerDialog.show();
    }
}

