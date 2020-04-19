package com.example.postpc_ongoingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView bottom =  (Button) findViewById(R.id.button);
        final TextView textView1 =  findViewById(R.id.textView1);
        final EditText input_text = (EditText) findViewById(R.id.input_text); //comment

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textToView = input_text.getText().toString();

                textView1.setText(textToView);

                textView1.setVisibility(View.VISIBLE);

                input_text.setText("");


            }
        });




    }
}
