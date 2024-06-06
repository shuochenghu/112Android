package com.example.explicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class OpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
        CheckBox chkDivide = (CheckBox) findViewById(R.id.chkDivide);
        //chkDivide.setEnabled(false);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1, opd2;
                double result = 0.0;
                RadioButton rdbAdd, rdbSubtract, rdbMultiply, rdbDivide;

                // 取得傳遞的資料
                Bundle bundle = OpActivity.this.getIntent().getExtras();
                if (bundle == null) return;
                // 取得運算元
                opd1 = Integer.parseInt(bundle.getString("OPERAND01"));
                opd2 = Integer.parseInt(bundle.getString("OPERAND02"));
                // 取得選取的運算子
                rdbAdd = (RadioButton) findViewById(R.id.rdbAdd);
                if (rdbAdd.isChecked()) {
                    //chkDivide.setEnabled(false);
                    result = opd1 + opd2; // 加
                }
                rdbSubtract = (RadioButton) findViewById(R.id.rdbSubtract);
                if (rdbSubtract.isChecked()) {
                    //chkDivide.setEnabled(false);
                    result = opd1 - opd2;  // 減
                }
                rdbMultiply = (RadioButton) findViewById(R.id.rdbMultiply);
                if (rdbMultiply.isChecked()) {
                    //chkDivide.setEnabled(false);
                    result = opd1 * opd2;  // 乘
                }
                rdbDivide = (RadioButton) findViewById(R.id.rdbDivide);
                //chkDivide = (CheckBox) findViewById(R.id.chkDivide);
                if (rdbDivide.isChecked()) {
                    //chkDivide.setEnabled(true);
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
        });
    }
}