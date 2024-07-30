package com.example.date2_example1;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.date2_example1.databinding.ActivityExample2Binding;

public class Example1 extends AppCompatActivity {

    ActivityExample2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExample2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "Bạn đã đánh giá: ";
                int selectId = binding.radVote.getCheckedRadioButtonId();
                if (selectId != -1){
                    RadioButton selectedRadioButton = findViewById(selectId);
                    content += selectedRadioButton.getText().toString();

                    binding.txtResult.setText(content);
                }else{
                    Toast.makeText(Example1.this, "Please select a rating", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}