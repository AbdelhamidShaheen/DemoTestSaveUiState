package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiatComponet();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("textView_Key", textView.getText().toString());
        savedInstanceState.putString("editText_Key", editText.getText().toString());


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        textView.setText(savedInstanceState.getString("textView_Key"));
        editText.setText(savedInstanceState.getString("editText_Key"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void intiatComponet() {
        button = (Button) findViewById(R.id.push);
        editText = (EditText) findViewById(R.id.textedit);
        textView = (TextView) findViewById(R.id.textshow);
    }
}
