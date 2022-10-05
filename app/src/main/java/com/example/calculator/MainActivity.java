package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private EditText inputNum;
    public int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        inputNum = (EditText) findViewById(R.id.inputNum);
    }

    public void onButtonClick(View view) {
        Button button = (Button)view;

        if (inputNum.length() == 0) { //проверка на 0 позицию
            position = 0;
        }
        if (position > 1) { //для всех позиций
            inputNum.append(button.getText());
            position++;
        }
        if (position == 1 && button.getText().toString().equals("0")) { //если второй элемент и кнопка 0
            if (inputNum.getText().toString().equals("0")) { // если первый элемент 0
                inputNum.setText("0");
            }
            else { // если первый элемент не 0
                inputNum.append(button.getText());
            }
        }
        if (position == 1 && !button.getText().toString().equals("0")) { //если второй элемент и кнопка не 0
            if (inputNum.getText().toString().equals("0")) {
                inputNum.setText(button.getText().toString());
            }
            else {
                inputNum.append(button.getText());
                position++;
            }
        }
        if (position == 0) {
            inputNum.append(button.getText());
            position++;
        }
    }

    String deleteCharacters(String str, int from, int to) {
        return str.substring(0,from)+str.substring(to);
    }

    public void onDeleteClick(View view) {
        if (inputNum.length() > 0) {
            String op = inputNum.getText().toString();
            op = deleteCharacters(op, op.length() - 1, op.length());
            inputNum.setText(op);
            position--;
        }
        if (inputNum.length() == 0) {
            position = 0;
        }
    }

    public void onSymbolClick(View view) {
        Button button = (Button)view;
        String op = button.getText().toString();
        String number = inputNum.getText().toString();
        String r = number + op;
        inputNum.setText(r);
    }

    public static int substraction(int first, int second) {
        return first - second;
    }

    public static int division(int first, int second) {
        return first / second;
    }

    public static int multiplication(int first, int second) {
        return first * second;
    }

    public static int addition(int first, int second) {
        return first + second;
    }

    int first = 0, second = 0;
    public void convert(String in, char sym) {
        String tmpF = "", tmpS = "";
        for (int i = 0; i < in.indexOf(sym); i++) {
            tmpF += (in.charAt(i));
        }
        for (int i = in.indexOf(sym) + 1; i < in.length(); i++) {
            tmpS += (in.charAt(i));
        }

        first = Integer.parseInt(tmpF);
        second = Integer.parseInt(tmpS);
    }

    public void onResultClick(View view) {
        int res = 0;
        String input = inputNum.getText().toString();

        if (input.contains("+")) {
            convert(input, '+');
            res = addition(first, second);
        }
        if (input.contains("-")) {
            convert(input, '-');
            res = substraction(first, second);
        }
        if (input.contains("*")) {
            convert(input, '*');
            res = multiplication(first, second);
        }
        if (input.contains("÷")) {
            convert(input, '÷');
            res = division(first, second);
        }

        if (!inputNum.getText().toString().equals("0")) {
            inputNum.setText(String.valueOf(res));
        }
    }

    public void onClearClick(View view) {
        inputNum.setText("");
    }
}