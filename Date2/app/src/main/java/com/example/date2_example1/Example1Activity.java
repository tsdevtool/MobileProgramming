package com.example.date2_example1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.date2_example1.databinding.ActivityExample1Binding;

public class Example1Activity extends AppCompatActivity {


    ActivityExample1Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExample1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

    }

    private void addEvents() {
        binding.btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "Bạn đã chọn: ";

                if (binding.chkFilm.isChecked())
                    content += binding.chkFilm.getText().toString() + ", ";

                if (binding.chkFPTPlay.isChecked())
                    content += binding.chkFPTPlay.getText().toString() +", ";

                if (binding.chkClipTV.isChecked())
                    content += binding.chkClipTV.getText().toString() +", ";

                binding.txtResult.setText(content.substring(0,content.length()-2));
            }
        });
    }
}