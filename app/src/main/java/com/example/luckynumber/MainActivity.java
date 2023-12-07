package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title;
    EditText edittext;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.textView);
        edittext = findViewById(R.id.editText);
        button = findViewById(R.id.bttn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name = edittext.getText().toString();

                Intent i = new Intent(
                        getApplicationContext(),
                        MainActivity2.class
                );

                i.putExtra("name", name);
                startActivity(i);

            }
        });
    }
}