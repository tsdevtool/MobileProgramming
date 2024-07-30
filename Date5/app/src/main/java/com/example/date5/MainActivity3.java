package com.example.date5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.BeerAdapter;
import com.example.date5.databinding.ActivityMain3Binding;
import com.example.models.Beers;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;
    BeerAdapter adapter;
    List<Beers> beers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        adapter = new BeerAdapter(MainActivity3.this, R.layout.item_list, initData());
        binding.lvBeers.setAdapter(adapter);
    }

    private List<Beers> initData() {
        beers = new ArrayList<>();
        beers.add(new Beers(1, "Heineken", 17000, R.drawable.heineken));
        beers.add(new Beers(2, "Beer333", 10000, R.drawable.beer333));
        beers.add(new Beers(3, "Hanoi", 12000, R.drawable.hanoi));
        beers.add(new Beers(4, "Larue", 16000, R.drawable.larue));
        beers.add(new Beers(5, "Saigon", 11000, R.drawable.saigon));
        beers.add(new Beers(6, "Sapporo", 20000, R.drawable.sapporo));
        beers.add(new Beers(7, "Tiger", 14000, R.drawable.tiger));
        return beers;
    }
}