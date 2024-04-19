package com.example.ch6_1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    private TextView output;
    private EditText txt;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得View物件
        output = (TextView) findViewById(R.id.lblOutput);
        // 註冊傾聽者物件
        rg = (RadioGroup) findViewById(R.id.rgGender);
        rg.setOnCheckedChangeListener(this);
        txt = (EditText) findViewById(R.id.txtName);
        txt.addTextChangedListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        show(rg.getCheckedRadioButtonId());
    }
    @Override
    public void afterTextChanged(Editable editable) {
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        show(i);
    }
    public void show(int i) {
        String str = "";
        str = txt.getText().toString() + "\n";  // 取得EditText值
        // 判斷是選擇哪一個, 使用的參數i
        switch (i) {
            case R.id.rdbBoy:
                RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
                output.setText(str + boy.getText());
                break;
            case R.id.rdbGirl:
                RadioButton girl = (RadioButton) findViewById(R.id.rdbGirl);
                output.setText(str + girl.getText());
                break;
        }
    }
}