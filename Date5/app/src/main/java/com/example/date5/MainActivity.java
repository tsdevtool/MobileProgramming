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
import androidx.recyclerview.widget.RecyclerView;

import com.example.date5.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayListDrinks;
    ArrayList<String> arrayListPizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
    }



    private void loadData() {
        String[] drinks = {"Coca-Cola", "Pepsi", "Fanta", "C2", "Redbull", "Olong Tea", "TH TrueMilk", "Sprite", "333", "Tiger", "Heineken", "Saigon Beer", "HaNoi Beer", "Lemon Tea", "Soda", "Sting"};
        arrayListDrinks = new ArrayList<>();
        arrayListDrinks.addAll(Arrays.asList(drinks));

        arrayListPizza  = new ArrayList<>();
        arrayListPizza.addAll(Arrays.asList(getResources().getStringArray(R.array.food)));
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListPizza);

        binding.lvDrinks.setAdapter(adapter);
    }

    private void addEvents() {
        binding.lvDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapter.getItem(i);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        binding.lvDrinks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.remove(adapter.getItem(i));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

}