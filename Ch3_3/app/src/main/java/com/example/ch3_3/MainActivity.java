package com.example.ch3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view) {
        int count;
        TextView output = (TextView) findViewById(R.id.lblOutput);
        count = Integer.parseInt(output.getText().toString());
        count++;
        output.setText(Integer.toString(count));
    }

    public void button2_Click(View view) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText("0");
    }

}