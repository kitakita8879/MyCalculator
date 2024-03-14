package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equ;
    private Button dot;
    private Button clear;
    private Button L_arrow;
    private Button R_arrow;
    //private Button del;//
    private TextView ans;
    private TextView test;
    private TextView tmp;

    private Double num1 = 0.0, num2 = 0.0, ansnum = 0.0, ansView = 0.0;
    private String tmpNum;
    private Stack<String> formula = new Stack<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindView();
    }

    private void FindView(){
        ans = findViewById(R.id.Ans);
        tmp = findViewById(R.id.tmp);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        add = findViewById(R.id.Add);
        sub = findViewById(R.id.Sub);
        mul = findViewById(R.id.Mul);
        div = findViewById(R.id.Div);
        dot = findViewById(R.id.Dot);
        clear = findViewById(R.id.Clear);
        L_arrow = findViewById(R.id.LeftArr);
        R_arrow = findViewById(R.id.RightArr);
        //del = findViewById(R.id.Del);
        equ = findViewById(R.id.Equ);

        btn_0.setOnClickListener(clickListen);
        btn_1.setOnClickListener(clickListen);
        btn_2.setOnClickListener(clickListen);
        btn_3.setOnClickListener(clickListen);
        btn_4.setOnClickListener(clickListen);
        btn_5.setOnClickListener(clickListen);
        btn_6.setOnClickListener(clickListen);
        btn_7.setOnClickListener(clickListen);
        btn_8.setOnClickListener(clickListen);
        btn_9.setOnClickListener(clickListen);
        add.setOnClickListener(clickListen);
        sub.setOnClickListener(clickListen);
        mul.setOnClickListener(clickListen);
        div.setOnClickListener(clickListen);
        clear.setOnClickListener(clickListen);
        dot.setOnClickListener(clickListen);
        equ.setOnClickListener(clickListen);
        L_arrow.setOnClickListener(clickListen);
        R_arrow.setOnClickListener(clickListen);
    }

    private Button.OnClickListener clickListen = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            Button b = (Button)v;

            switch (v.getId()){
                case R.id.Clear:
                    ans.setText("");
                    tmp.setText("");
                    while (!formula.isEmpty()) {
                        formula.pop();
                    }
                    break;
                case R.id.Add:
                    ans.setText(ans.getText().toString() + b.getText().toString());
                    tmpNum = tmp.getText().toString();
                    if(tmpNum != null){
                        if(formula.isEmpty()){
                            formula.push(tmpNum);
                        }else if(formula.peek() == "Mul"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 * num2;
                            formula.push(num2.toString());
                        }else if(formula.peek() == "Div"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 / num2;
                            formula.push(num2.toString());
                        }else {
                            formula.push(tmpNum);
                        }
                        formula.push("Add");
                    }
                    tmp.setText("");
                    break;
                case R.id.Sub:
                    ans.setText(ans.getText().toString() + b.getText().toString());
                    tmpNum = tmp.getText().toString();
                    if(tmpNum != null){
                        if(formula.isEmpty()){
                            formula.push(tmpNum);
                        }else if(formula.peek() == "Mul"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 * num2;
                            formula.push(num2.toString());
                        }else if(formula.peek() == "Div"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 / num2;
                            formula.push(num2.toString());
                        }else {
                            formula.push(tmpNum);
                        }
                        formula.push("Sub");
                    }
                    tmp.setText("");
                    break;
                case R.id.Mul:
                    ans.setText(ans.getText().toString() + b.getText().toString());
                    tmpNum = tmp.getText().toString();
                    if(tmpNum != null){
                        if(formula.isEmpty()){
                            formula.push(tmpNum);
                        }else if(formula.peek() == "Mul"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 * num2;
                            formula.push(num2.toString());
                        }else if(formula.peek() == "Div"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 / num2;
                            formula.push(num2.toString());
                        }else {
                            formula.push(tmpNum);
                        }
                        formula.push("Mul");
                    }
                    tmp.setText("");
                    break;
                case R.id.Div:
                    ans.setText(ans.getText().toString() + b.getText().toString());
                    tmpNum = tmp.getText().toString();
                    if(tmpNum != null){
                        if(formula.isEmpty()){
                            formula.push(tmpNum);
                        }else if(formula.peek() == "Mul"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 * num2;
                            formula.push(num2.toString());
                        }else if(formula.peek() == "Div"){
                            num2 = Double.valueOf(tmpNum);
                            formula.pop();
                            num1 = Double.valueOf(formula.pop());
                            num2 = num1 / num2;
                            formula.push(num2.toString());
                        }else {
                            formula.push(tmpNum);
                        }
                        formula.push("Div");
                    }
                    tmp.setText("");
                    break;
                case R.id.Equ:
                    tmpNum = tmp.getText().toString();
                    if(tmpNum != null){
                        formula.push(tmpNum);
                        num2 = Double.valueOf(formula.pop());
                        while (!formula.isEmpty()){
                            tmp.setText(num2.toString());
                            if(formula.peek() == "Mul"){
                                formula.pop();
                                num1 = Double.valueOf(formula.pop());
                                num2 = num1 * num2;
                                formula.push(num2.toString());
                            }else if(formula.peek() == "Div"){
                                formula.pop();
                                num1 = Double.valueOf(formula.pop());
                                num2 = num1 / num2;
                                formula.push(num2.toString());
                            }else if(formula.peek() == "Add"){
                                formula.pop();
                                num1 = Double.valueOf(formula.pop());
                                num2 = num1 + num2;
                                formula.push(num2.toString());
                            }else if(formula.peek() == "Sub"){
                                formula.pop();
                                num1 = Double.valueOf(formula.pop());
                                num2 = num1 - num2;
                                formula.push(num2.toString());
                            }
                            num2 = Double.valueOf(formula.pop());
                        }
                        ansnum = Math.round(num2 *10000) *0.0001;
                        ansView = Math.round(ansnum *100) *0.01;
                        ans.setText(ansView.toString());
                    }
                    tmp.setText("");
                    break;

                case R.id.LeftArr:
                    int i = ansView.toString().length() - ansView.toString().indexOf('.') -1;
                    if(i == 2){
                        ansView = Math.round(ansnum *10) *0.1;
                    }else if( i == 3){
                        ansView = Math.round(ansnum *100) *0.01;
                    }else if( i == 4){
                        ansView = Math.round(ansnum *1000) *0.001;
                    }else if(i == 1){
                        ansView = Double.valueOf(Math.round(ansnum)) ;
                    }
                    ans.setText(ansView.toString());
                    break;
                case R.id.RightArr:
                    int j = ansView.toString().length() - ansView.toString().indexOf('.') -1;
                    if(j == 2){
                        ansView = Math.round(ansnum *1000) *0.001;
                    }else if( j == 1){
                        ansView = Math.round(ansnum *100) *0.01;
                    }else if( j == 0){
                        ansView = Math.round(ansnum *10) *0.1;
                    }else if(j == 3){
                        ansView = Math.round(ansnum *10000) *0.0001;
                    }
                    ans.setText(ansView.toString());
                    break;
                default:
                    if(tmp.getText().toString() == ""){
                        tmp.setText(b.getText().toString());
                    }else {
                        tmp.setText(tmp.getText() + b.getText().toString());
                    }
                    ans.setText(ans.getText().toString() + b.getText().toString());
                    break;
            }
        }
    };
}