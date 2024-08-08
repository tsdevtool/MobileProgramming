package com.crissiiu.bai1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.bai1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String phoneNumberString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Number 1", Toast.LENGTH_SHORT).show();
                phoneNumberString = phoneNumberString + binding.btnNumber1.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Number 1", Toast.LENGTH_SHORT).show();
                phoneNumberString = phoneNumberString + binding.btnNumber2.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber3.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber4.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber5.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber6.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber7.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber8.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber9.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber0.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });

//        Delete
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                abc = do dai 3 a = 0 b =1 = c = 2 0->2 0 -1 0->3-1

                if(binding.edtPhoneNumber.getText().length() > 0){
                    phoneNumberString = phoneNumberString.substring(0, phoneNumberString.length()-1);
                    binding.edtPhoneNumber.setText(phoneNumberString);
                }
            }
        });
//        Go to Call
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.edtPhoneNumber.getText().length() > 0){
                    Intent intent = new Intent(Intent.ACTION_CALL);
//                Uri uri = Uri.parse("tel:" + binding.edtPhoneNumber.getText().toString());
                    Uri uri = Uri.parse("tel:" + phoneNumberString);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
//                    Toast.makeText(MainActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}