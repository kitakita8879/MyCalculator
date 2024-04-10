package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView ans;
    private TextView tmp;

    private Double ans_num = 0.0;
    private Double ansView = 0.0;
    private final Stack<String> formula = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindView();
    }

    private void FindView(){
        ans = findViewById(R.id.Ans);
        tmp = findViewById(R.id.tmp);
        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button add = findViewById(R.id.Add);
        Button sub = findViewById(R.id.Sub);
        Button mul = findViewById(R.id.Mul);
        Button div = findViewById(R.id.Div);
        Button dot = findViewById(R.id.Dot);
        Button clear = findViewById(R.id.Clear);
        Button l_arrow = findViewById(R.id.LeftArr);
        Button r_arrow = findViewById(R.id.RightArr);
        //Button del = findViewById(R.id.Del);//
        Button equ = findViewById(R.id.Equ);

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
        l_arrow.setOnClickListener(clickListen);
        r_arrow.setOnClickListener(clickListen);
    }

    private final Button.OnClickListener clickListen = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            Button b = (Button)v;

            double num1;
            double num2;
            String tmpNum, tmpAns;
            //switch(v.getId()){} 從ADT14開始不支援，資源id非final，參考https://web.archive.org/web/20230203152426/http://tools.android.com/tips/non-constant-fields
            int id = v.getId();
            if (id == R.id.Clear) {
                ans.setText("");
                tmp.setText("");
                while (!formula.isEmpty()) {
                    formula.pop();
                }
            } else if (id == R.id.Add) {
                tmpAns = ans.getText().toString() + b.getText().toString();
                ans.setText(tmpAns);
                tmpNum = tmp.getText().toString();
                if (!tmpNum.isEmpty()) {
                    if (formula.isEmpty()) {
                        formula.push(tmpNum);
                    } else if (formula.peek().equals("Mul")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 * num2;
                        formula.push(Double.toString(num2));
                    } else if (formula.peek().equals("Div")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 / num2;
                        formula.push(Double.toString(num2));
                    } else {
                        formula.push(tmpNum);
                    }
                    formula.push("Add");
                }
                tmp.setText("");
            } else if (id == R.id.Sub) {
                tmpAns = ans.getText().toString() + b.getText().toString();
                ans.setText(tmpAns);
                tmpNum = tmp.getText().toString();
                if (!tmpNum.isEmpty()) {
                    if (formula.isEmpty()) {
                        formula.push(tmpNum);
                    } else if (formula.peek().equals("Mul")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 * num2;
                        formula.push(Double.toString(num2));
                    } else if (formula.peek().equals("Div")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 / num2;
                        formula.push(Double.toString(num2));
                    } else {
                        formula.push(tmpNum);
                    }
                    formula.push("Sub");
                }
                tmp.setText("");
            } else if (id == R.id.Mul) {
                tmpAns = ans.getText().toString() + b.getText().toString();
                ans.setText(tmpAns);
                tmpNum = tmp.getText().toString();
                if (!tmpNum.isEmpty()) {
                    if (formula.isEmpty()) {
                        formula.push(tmpNum);
                    } else if (formula.peek().equals("Mul")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 * num2;
                        formula.push(Double.toString(num2));
                    } else if (formula.peek().equals("Div")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 / num2;
                        formula.push(Double.toString(num2));
                    } else {
                        formula.push(tmpNum);
                    }
                    formula.push("Mul");
                }
                tmp.setText("");
            } else if (id == R.id.Div) {
                tmpAns = ans.getText().toString() + b.getText().toString();
                ans.setText(tmpAns);
                tmpNum = tmp.getText().toString();
                if (!tmpNum.isEmpty()) {
                    if (formula.isEmpty()) {
                        formula.push(tmpNum);
                    } else if (formula.peek().equals("Mul")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 * num2;
                        formula.push(Double.toString(num2));
                    } else if (formula.peek().equals("Div")) {
                        num2 = Double.parseDouble(tmpNum);
                        formula.pop();
                        num1 = Double.parseDouble(formula.pop());
                        num2 = num1 / num2;
                        formula.push(Double.toString(num2));
                    } else {
                        formula.push(tmpNum);
                    }
                    formula.push("Div");
                }
                tmp.setText("");
            } else if (id == R.id.Equ) {
                tmpNum = tmp.getText().toString();
                if (!tmpNum.isEmpty()) {
                    formula.push(tmpNum);
                    num2 = Double.parseDouble(formula.pop());
                    while (!formula.isEmpty()) {
                        tmp.setText(String.valueOf(num2));
                        if (formula.peek().equals("Mul")) {
                            formula.pop();
                            num1 = Double.parseDouble(formula.pop());
                            num2 = num1 * num2;
                            formula.push(Double.toString(num2));
                        } else if (formula.peek().equals("Div")) {
                            formula.pop();
                            num1 = Double.parseDouble(formula.pop());
                            num2 = num1 / num2;
                            formula.push(Double.toString(num2));
                        } else if (formula.peek().equals("Add")) {
                            formula.pop();
                            num1 = Double.parseDouble(formula.pop());
                            num2 = num1 + num2;
                            formula.push(Double.toString(num2));
                        } else if (formula.peek().equals("Sub")) {
                            formula.pop();
                            num1 = Double.parseDouble(formula.pop());
                            num2 = num1 - num2;
                            formula.push(Double.toString(num2));
                        }
                        num2 = Double.parseDouble(formula.pop());
                    }
                    ans_num = Math.round(num2 * 10000) * 0.0001;
                    ansView = Math.round(ans_num * 100) * 0.01;
                    ans.setText(String.format(ansView.toString()));
                }
                tmp.setText("");
            } else if (id == R.id.LeftArr) {
                int i = ansView.toString().length() - ansView.toString().indexOf('.') - 1;
                if (i == 2) {
                    ansView = Math.round(ans_num * 10) * 0.1;
                } else if (i == 3) {
                    ansView = Math.round(ans_num * 100) * 0.01;
                } else if (i == 4) {
                    ansView = Math.round(ans_num * 1000) * 0.001;
                } else if (i == 1) {
                    ansView = (double) Math.round(ans_num);
                }
                ans.setText(String.format(ansView.toString()));
            } else if (id == R.id.RightArr) {
                int j = ansView.toString().length() - ansView.toString().indexOf('.') - 1;
                if (j == 2) {
                    ansView = Math.round(ans_num * 1000) * 0.001;
                } else if (j == 1) {
                    ansView = Math.round(ans_num * 100) * 0.01;
                } else if (j == 0) {
                    ansView = Math.round(ans_num * 10) * 0.1;
                } else if (j == 3) {
                    ansView = Math.round(ans_num * 10000) * 0.0001;
                }
                ans.setText(String.format(ansView.toString()));
            } else {
                if (tmp.getText().toString().isEmpty()) {
                    tmp.setText(b.getText().toString());
                } else {
                    tmpNum = tmp.getText() + b.getText().toString();
                    tmp.setText(tmpNum);
                }
                tmpAns = ans.getText().toString() + b.getText().toString();
                ans.setText(tmpAns);
            }
        }
    };
}