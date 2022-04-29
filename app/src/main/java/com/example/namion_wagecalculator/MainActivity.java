package com.example.namion_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText employeename, employeehours;
    RadioGroup employeetype;
    RadioButton btnSelected;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edittext
        employeename = findViewById(R.id.employeename);
        employeehours = findViewById(R.id.employeehours);

        //radiogroup
        employeetype = findViewById(R.id.employeetype);
        //button
        calculate = findViewById(R.id.btncalculate);

        //button OnClick listener
        calculate.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btncalculate:
                int selectedemployeetype = employeetype.getCheckedRadioButtonId();
                btnSelected = findViewById(selectedemployeetype);

                String type = btnSelected.getText().toString();
                String name = employeename.getText().toString();
                String salaryamount = (employeehours.getText().toString());

                Intent intent = new Intent(this,Display.class);
                getIntent().putExtra("type",type);
                getIntent().putExtra("empname",name);
                getIntent().putExtra("hours",salaryamount);

                startActivity(intent);
            break;

        }
    }
}