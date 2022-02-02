package com.example.bankregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatePickerDialog.OnDateSetListener dateSetListener;
    TextView tvday,tvmonth,tvyear,donthavepan;
    MaterialButton next;
    EditText edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvday=findViewById(R.id.tvday);
        tvmonth=findViewById(R.id.tvmonth);
        tvyear=findViewById(R.id.tvyear);
        donthavepan=findViewById(R.id.donthavepan);
        next=findViewById(R.id.next);
        edit_text=findViewById(R.id.edit_text);
        tvday.setOnClickListener(this);
        tvmonth.setOnClickListener(this);
        tvyear.setOnClickListener(this);
        donthavepan.setOnClickListener(this);
        next.setOnClickListener(this);
    }
    public void selectdate() {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                tvday.setText(String.valueOf(day));
                tvmonth.setText(String.valueOf(month));
                tvyear.setText(String.valueOf(year));
            }
        };

    }

    @Override
    public void onClick(View view) {
        int Id = view.getId();
        switch (Id) {
            case R.id.tvday:
                selectdate();
                break;
            case R.id.tvmonth:
                selectdate();
                break;
            case R.id.tvyear:
                selectdate();
                break;
            case R.id.donthavepan:
                finish();

            case R.id.next:
                if(validation())
                {
                    Toast.makeText(MainActivity.this,"Detail Submitted successfully",Toast.LENGTH_SHORT).show();
          finish();
                }
            //    finish();
                break;

        }
    }
    public boolean validation()
    {
        if (TextUtils.isEmpty( edit_text.getText())) {
return false;
        }
        else if (TextUtils.isEmpty( tvday.getText())) {
            return false;
    }
        else if (TextUtils.isEmpty( tvmonth.getText())) {
            return false;
        }
        else if (TextUtils.isEmpty( tvyear.getText())) {
            return false;
        }
        else
        {
            return true;
        }
    }
}