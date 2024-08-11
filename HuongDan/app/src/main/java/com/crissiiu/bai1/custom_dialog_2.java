package com.crissiiu.bai1;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.bai1.databinding.ActivityCustomDialog2Binding;

public class custom_dialog_2 extends AppCompatActivity {


    ActivityCustomDialog2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomDialog2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }


}