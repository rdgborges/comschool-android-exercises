package com.comschool.aula4ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstEditText;
    private EditText mSecondEditText;
    private RadioGroup mOperationsRadioGroup;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstEditText = (EditText) findViewById(R.id.first_value_edit_text);
        mSecondEditText = (EditText) findViewById(R.id.second_value_edit_text);
        mOperationsRadioGroup = (RadioGroup) findViewById(R.id.operations_radio_group);
        mResultTextView = (TextView) findViewById(R.id.result_text_view);
    }

    public void calculateOperation(View view) {
        int firstNumber = Integer.parseInt(mFirstEditText.getText().toString());
        int secondNumber = Integer.parseInt(mSecondEditText.getText().toString());
        int selectedOperation = getSelectedOperation();
        int result = 0;

        switch (selectedOperation) {
            case 0:
                result = firstNumber + secondNumber;
                break;
            case 1:
                result = firstNumber - secondNumber;
                break;
            case 2:
                result = firstNumber * secondNumber;
                break;
            case 3:
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
        }

        mResultTextView.setText(String.valueOf(result));
    }

    private int getSelectedOperation() {
        int radioButtonID = mOperationsRadioGroup.getCheckedRadioButtonId();
        View radioButton = mOperationsRadioGroup.findViewById(radioButtonID);
        int id = mOperationsRadioGroup.indexOfChild(radioButton);

        return id;
    }
}
