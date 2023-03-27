package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private TextView resultTextView;
        private String operand1, operand2, operator;
        private Double result;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            resultTextView = findViewById(R.id.result);
            operand1 = "";
            operand2 = "";
            operator = "";
            result = null;

            Button button0 = findViewById(R.id.btn_0);
            Button button1 = findViewById(R.id.btn_1);
            Button button2 = findViewById(R.id.btn_2);
            Button button3 = findViewById(R.id.btn_3);
            Button button4 = findViewById(R.id.btn_4);
            Button button5 = findViewById(R.id.btn_5);
            Button button6 = findViewById(R.id.btn_6);
            Button button7 = findViewById(R.id.btn_7);
            Button button8 = findViewById(R.id.btn_8);
            Button button9 = findViewById(R.id.btn_9);
            Button buttonAdd = findViewById(R.id.btn_add);
            Button buttonSubtract = findViewById(R.id.btn_subtract);
            Button buttonMultiply = findViewById(R.id.btn_multiply);
            Button buttonDivide = findViewById(R.id.btn_divide);
            Button buttonClear = findViewById(R.id.btn_clear);
            Button buttonBackspace = findViewById(R.id.btn_backspace);
            Button buttonEquals = findViewById(R.id.btn_equal);
            Button buttondecimal =findViewById(R.id.btn_decimal);

            button0.setOnClickListener(v -> numberClicked("0"));

            button1.setOnClickListener(v -> numberClicked("1"));

            button2.setOnClickListener(v -> numberClicked("2"));

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("3");
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("4");
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("5");
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("6");
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("7");
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("8");
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberClicked("9");
                }
            });
            buttondecimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numberClicked(".");
                }
            });

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operatorClicked("+");
                }
            });

            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operatorClicked("-");
                }
            });

            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operatorClicked("*");
                }
            });

            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operatorClicked("/");
                }
            });


            buttonClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operand1 = "";
                    operand2 = "";
                    operator = "";
                    result = null;
                    resultTextView.setText("0");
                }
            });

            buttonBackspace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!operand2.equals("")) {
                        operand2 = operand2.substring(0, operand2.length() - 1);
                        resultTextView.setText(operand1 + operator + operand2);
                    } else if (!operator.equals("")) {
                        operator = "";
                        resultTextView.setText(operand1);
                    } else if (!operand1.equals("")) {
                        operand1 = operand1.substring(0, operand1.length() - 1);
                        resultTextView.setText(operand1);
                    }
                }
            });

            buttonEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!operand1.equals("") && !operand2.equals("") && !operator.equals("")) {
                        Double value1 = Double.parseDouble(operand1);
                        Double value2 = Double.parseDouble(operand2);

                        if (operator.equals("+")) {
                            result = value1 + value2;
                        } else if (operator.equals("-")) {

                            result = value1 - value2;
                        } else if (operator.equals("*")) {
                            result = value1 * value2;
                        } else if (operator.equals("/")) {
                            if (value2 == 0) {
                                resultTextView.setText("Error: Division by 0");
                                return;
                            } else {
                                result = value1 / value2;
                            }
                        }

                        resultTextView.setText(result.toString());
                        operand1 = result.toString();
                        operand2 = "";
                        operator = "";
                    }
                }
            });

        }

    private void numberClicked(String number) {
        if (operator.equals("")) {
            operand1 += number;
            resultTextView.setText(operand1);
        } else {
            operand2 += number;
            resultTextView.setText(operand1 + operator + operand2);
        }
    }

    private void operatorClicked(String operator) {
        if (!operand1.equals("")) {
            this.operator = operator;
            resultTextView.setText(operand1 + operator);
        }
    }
}
