package com.example.date5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.date5.databinding.ActivityMain2Binding;
import com.example.models.Products;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    ArrayAdapter<Products> adapter;
    ArrayList<Products> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initAdapter();
        addEvents();

    }

    private void initAdapter() {
        adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1);
        binding.lvProduct.setAdapter(adapter);
    }

    private void addEvents() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Adding product
//                adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1);
                String name = binding.edtProductName.getText().toString();
                double price = Double.parseDouble(binding.edtProductPrice.getText().toString());
                Products p = new Products(price, name);
//                products.add(p);
                adapter.add(p);

//                binding.lvProduct.setAdapter(adapter);
            }
        });

        binding.lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Products selectedItem = adapter.getItem(i);
                Toast.makeText(MainActivity2.this, selectedItem.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Products selectedItem = adapter.getItem(i);
                adapter.remove(selectedItem);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}