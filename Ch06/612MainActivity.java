package com.example.ch6_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgGender);
        // 註冊傾聽者物件
        rg.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // 取得View物件
        TextView output = (TextView) findViewById(R.id.lblOutput);
        // 判斷是選擇哪一個, 使用的參數i
        switch (i) {
            case R.id.rdbBoy:
                RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
                output.setText(boy.getText());
                break;
            case R.id.rdbGirl:
                RadioButton girl =(RadioButton) findViewById(R.id.rdbGirl);
                output.setText(girl.getText());
                break;
        }
    }
}