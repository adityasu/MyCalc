package com.aditya.madscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.aditya.madscalculator.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<String> sb1 = new ArrayList<>();
    StringBuilder sb2 = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("0");
                sb1.add("0");
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("1");
                sb1.add("1");
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("2");
                sb1.add("2");
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("3");
                sb1.add("3");
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("4");
                sb1.add("4");
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("5");
                sb1.add("5");
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("6");
                sb1.add("6");
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("7");
                sb1.add("7");
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("8");
                sb1.add("8");
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append("9");
                sb1.add("9");
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append(" + ");
                sb1.add(" + ");
            }
        });

        binding.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append(" / ");
                sb1.add(" / ");
            }
        });

        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append(" * ");
                sb1.add(" * ");
            }
        });

        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.append(" - ");
                sb1.add(" - ");
            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // returnCalculation(sb1);
                ;
                String demo = infixToPostFix(binding.textView.getText().toString());
                binding.textViewdemo.setText(demo);
            }
        });

        binding.btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor (
                result += c;
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
    }

    /*public void returnCalculation(ArrayList<String> sb1) {
        int index;
        while (sb1.size() > 0) {
            for( int i =0; i < sb1.size(); i++) {
                switch (sb1.get(i)) {
                    case "*":
                        appendValue(i,"*");
                        i = 0;
                    case "-":
                        appendValue(i,"*");
                        i = 0;
                    case "/":
                        appendValue(i,"*");
                        i = 0;
                    case "*":
                        appendValue(i,"*");
                        i = 0;


                }
            }

        }
            *//*if (sb1.contains(" * ")) {
                index = sb1.indexOf(" * ");
                appendValue(index, " * ");
                removeValue(index);
            }
            if (sb1.contains(" + ")) {
                index = sb1.indexOf(" + ");
                appendValue(index, " + ");
                removeValue(index);
            }
            if (sb1.contains(" / ")) {
                index = sb1.indexOf(" / ");
                appendValue(index, " / ");
                removeValue(index);
            }
            if (sb1.contains(" - ")) {
                index = sb1.indexOf(" - ");
                appendValue(index, " / ");
                removeValue(index);
            }
        }*//*
    }

    public void appendValue(int index, String operation) {
        sb2.append(sb1.get(index - 1));
        sb2.append(operation);
        sb2.append(sb1.get(index + 1));
    }

    public void removeValue(int index) {
        sb1.remove(index);
        if(index - 1 < sb1.size()) {
            sb1.remove(index - 1);
        }
        if(index + 1 > sb1.size()) {
            sb1.remove(index + 1);
        }
    }*/
}