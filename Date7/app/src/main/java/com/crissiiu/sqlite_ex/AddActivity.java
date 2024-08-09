package com.crissiiu.sqlite_ex;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.sqlite_ex.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(MainActivity.TBL_NAME2, binding.edtProductName.getText().toString());
                values.put(MainActivity.TBL_PRICE, Double.parseDouble(binding.edtProductPrice.getText().toString()));
                long numbOfRow = MainActivity.db.insert(MainActivity.TBL_NAME, null, values);
                if(numbOfRow > 0){
                    Toast.makeText(AddActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(AddActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}