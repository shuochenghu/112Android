package com.example.calculator;


import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

enum State {FirstNumberInput, OperatorInputed, NumberInput}
enum OP { None, Add, Sub, Mul, Div}

public class MainActivity extends AppCompatActivity {

    private int theValue = 0;
    private int operand1=0, operand2=0;
    private OP op=OP.None;
    private State state = State.FirstNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void onWindowFocusChanged (boolean hasFocus) {
        GridLayout keysGL = (GridLayout) findViewById(R.id.keys);

        int kbHeight = (int) (keysGL.getHeight() / keysGL.getRowCount());
        int kbWidth = (int) (keysGL.getWidth()/keysGL.getColumnCount());

        Button btn;

        for( int i=0; i< keysGL.getChildCount();i++){
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36 );
        }
    }
    public void processKeyInput(View view){
        Button b= (Button )view;    // 取得發生事件的按鈕
        String bstr= b.getText().toString();   // 取得發生事件的按鈕上的文字
        int bint; // 透過R.id.display取得顯示結果的EditText元件
        EditText edt = (EditText) findViewById(R.id.display);

        switch(bstr) { // 依據發生事件的按鈕上的文字值，進行不同的處理
            // 數字按鈕被點按時
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                bint = (new Integer(bstr)).intValue(); //將文字轉換為整數值

                switch(state) { // 依據當時的狀態決定不同的處理
                    case FirstNumberInput:
                        theValue=theValue*10+bint;
                        break;
                    case OperatorInputed:
                        theValue=bint;
                        operand2=bint;
                        state=State.NumberInput;
                        break;
                    case NumberInput:
                        theValue=theValue*10+bint;
                        break;
                }
                edt.setText("" + theValue);
                break;
            case "Clear": // 清除並重設相關變數
                state=State.FirstNumberInput;
                theValue=0;
                edt.setText((CharSequence)("0"));
                op=OP.None;
                operand2=operand1=0;
                break;
            case "Back": // 倒退鍵
                theValue=(int)(theValue/10);
                edt.setText("" + theValue);
                break;
            case "+":
            case "-":
            case "*":
            case "/": // 當operator被點選時
                switch(state) { // 依據當時的狀態決定不同的處理
                    case FirstNumberInput:
                        operand1=theValue;
                        operand2=theValue;
                        switch(bstr) {
                            case "+": op=OP.Add; break;
                            case "-": op=OP.Sub; break;
                            case "*": op=OP.Mul; break;
                            case "/": op=OP.Div; break;
                        }
                        state=State.OperatorInputed;
                        break;
                    case OperatorInputed:
                        switch(bstr) {
                            case "+": op=OP.Add; break;
                            case "-": op=OP.Sub; break;
                            case "*": op=OP.Mul; break;
                            case "/": op=OP.Div; break;
                        }
                        operand2=theValue;
                        break;
                    case NumberInput:
                        operand2=theValue;
                        switch(op) {
                            case Add: theValue=operand1+operand2; break;
                            case Sub: theValue=operand1-operand2; break;
                            case Mul: theValue=operand1*operand2; break;
                            case Div: theValue=operand1/operand2; break;
                        }
                        operand1=theValue;
                        switch(bstr) {
                            case "+": op=OP.Add; break;
                            case "-": op=OP.Sub; break;
                            case "*": op=OP.Mul; break;
                            case "/": op=OP.Div; break;
                        }
                        state=State.OperatorInputed;
                        edt.setText("" + theValue);
                        break;
                }
                break;
            case "=": // 當＝號被點選時，依據當時的狀態決定不同的處理
                if(state==State.OperatorInputed) {
                    switch(op) {
                        case Add: theValue=operand1+operand2; break;
                        case Sub: theValue=operand1-operand2; break;
                        case Mul: theValue=operand1*operand2; break;
                        case Div: theValue=operand1/operand2; break;
                    }
                    operand1=theValue;
                }
                else if(state==State.NumberInput) {
                    operand2=theValue;
                    switch(op) {
                        case Add: theValue=operand1+operand2; break;
                        case Sub: theValue=operand1-operand2; break;
                        case Mul: theValue=operand1*operand2; break;
                        case Div: theValue=operand1/operand2; break;
                    }
                    operand1=theValue;
                    state=State.OperatorInputed;
                }
                edt.setText("" + theValue);
                break;
        }
    }
}
