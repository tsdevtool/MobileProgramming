package com.crissiiu.sqlite_ex;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.models.Product;
import com.crissiiu.sqlite_ex.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    ActivityUpdateBinding binding;
    Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
        addEvents();
    }

    private void getData() {
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("data");
        assert  product != null;
        binding.edtProductName.setText(product.getProductName());
        binding.edtProductPrice.setText(String.valueOf(product.getProductPrice()));
    }

    private void addEvents() {
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Update data
                ContentValues values = new ContentValues();
                values.put(MainActivity.TBL_NAME2, binding.edtProductName.getText().toString());
                values.put(MainActivity.TBL_PRICE, Double.parseDouble(binding.edtProductPrice.getText().toString()));

                int numbOfRow = MainActivity.db.update(MainActivity.TBL_NAME, values, MainActivity.TBL_ID + "=?", new String[]{String.valueOf(product.getId())});
                if(numbOfRow > 0){
                    Toast.makeText(UpdateActivity.this, "Update Success!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(UpdateActivity.this, "Update Fail!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}