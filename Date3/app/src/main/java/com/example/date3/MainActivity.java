package com.example.date3;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.date3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    //Varible as Listenner
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnVariable1){
                Toast.makeText(MainActivity.this, "Variable 1", Toast.LENGTH_SHORT).show();
            }

//            if(view.equals(binding.btnVariable2)){
//                Toast.makeText(MainActivity.this, "Variable 2", Toast.LENGTH_SHORT).show();
//            }

            if (view.getId() == R.id.btnVariable2){
                Toast.makeText(MainActivity.this, "Variable 2", Toast.LENGTH_SHORT).show();
            }
        }
    };


    private void addEvents() {
        binding.btnAnonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Anonymous Listener", Toast.LENGTH_SHORT).show();
            }
        });

        //Variable Listener
        binding.btnVariable1.setOnClickListener(onClickListener);
        binding.btnVariable2.setOnClickListener(onClickListener);

        //Activity Listener
        binding.btnActivity1.setOnClickListener(this);
        binding.btnActivity2.setOnClickListener(this);

        //Explicit class as Listener
        binding.btnExplicit1.setOnClickListener(new myEvents());
        binding.btnExplicit2.setOnClickListener(new myEvents());
    }


    //XML Onclick Listener
    public void sayHello(View view) {
        //Logic here
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }

    //Activity as Listener
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnActivity1){
            Toast.makeText(this, "Actitvity 1", Toast.LENGTH_SHORT).show();
        }

        if(view.equals(binding.btnActivity2)){
            Toast.makeText(this, "Activity 2", Toast.LENGTH_SHORT).show();
        }
    }

    //View class as Listener
    public class myEvents implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.equals(binding.btnExplicit1)){
                Toast.makeText(MainActivity.this, "Explicit #1", Toast.LENGTH_SHORT).show();
            }
            if(view.equals(binding.btnExplicit2)){
                Toast.makeText(MainActivity.this, "Explicit #2", Toast.LENGTH_SHORT).show();
            }
        }
    }
}