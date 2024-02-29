package com.example.ch3_5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view) {
        // 取得EditText元件
        EditText txtTemp = (EditText) findViewById(R.id.txtTemp);
        // 取得輸入值
        int tmp = Integer.parseInt(txtTemp.getText().toString());
        // 攝氏轉華氏的公式
        double result = (9.0 * tmp) / 5.0 + 32.0;
        // 取得TextView元件
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("華氏溫度: " + result);
    }
}