package com.example.calculatorpre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        GridLayout keysGL = (GridLayout) findViewById(R.id.keys);

        int kbHeight = (int) (keysGL.getHeight() / keysGL.getRowCount());
        int kbWidth = (int) (keysGL.getWidth()/keysGL.getColumnCount());

        Log.v("Calculator", "keysGL.getHeight()="+keysGL.getHeight());
        Log.v("Calculator", "keysGL.getRowCount()="+keysGL.getRowCount());
        Button btn;

        for( int i=0; i< keysGL.getChildCount();i++){
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            //btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36 );
        }
    }
}