package com.example.ch9_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
    }
    // Button元件的事件處理方法
    public void button2_Click(View view) {
        int opd1, opd2;
        double result = 0.0;
        RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;
        CheckBox chkDivide;
        // 取得傳遞的資料
        Bundle bundle = this.getIntent().getExtras();
        if (bundle == null) return;
        // 取得運算元
        opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
        opd2 = Integer.parseInt(bundle.getString("OPERAND02"));
        // 取得選取的運算子
        rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
        if (rdbAdd.isChecked()) {
            result = opd1 + opd2; // 加
        }
        rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
        if (rdbSubtract.isChecked()) {
            result = opd1 - opd2;  // 減
        }
        rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
        if (rdbMultiply.isChecked()) {
            result = opd1 * opd2;  // 乘
        }
        rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
        chkDivide = (CheckBox) findViewById(R.id.chkDivide);
        if (rdbDivide.isChecked()) {
            if (chkDivide.isChecked())
                result = opd1 / opd2;  // 整數除法
            else
                result = opd1 / (double) opd2;
        }
        Intent rIntent = new Intent();
        // 建立傳回值
        Bundle rbundle = new Bundle();
        rbundle.putDouble("RESULT", result);
        rIntent.putExtras(rbundle);    // 加上資料
        setResult(RESULT_OK, rIntent); // 設定傳回
        finish(); // 結束活動
    }
}