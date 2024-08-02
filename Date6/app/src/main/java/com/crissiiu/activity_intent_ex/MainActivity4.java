package com.crissiiu.activity_intent_ex;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.activity_intent_ex.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();

        addEvent();
    }

    private void addEvent() {
        binding.btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numb = Integer.parseInt(binding.txtNumber.getText().toString());
                double result = numb * numb;

                //Attach data
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);//Sending data to Main Activity
                finish(); //Closing
            }
        });
    }

    private void getData() {
        intent = getIntent();
        binding.txtNumber.setText(intent.getStringExtra("number"));


    }
}