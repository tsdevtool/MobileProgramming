package com.example.date5;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        addEvents();
    }

    void showCustomDialog(Beers b){
        Dialog dialog = new Dialog(MainActivity3.this);
        dialog.setContentView(R.layout.custom_beer);

        ImageView imvPhoto = dialog.findViewById(R.id.imvPhotoCustom);
        imvPhoto.setImageResource(b.getBeerThumb());

        TextView txtPrice = dialog.findViewById(R.id.txtPriceCustom);
        txtPrice.setText(String.format("%.0f d", b.getBeerPrice()));

        Button cancel = dialog.findViewById(R.id.btncancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    private void addEvents() {

        binding.lvBeers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Beers b = (Beers) adapter.getItem(i);
                showCustomDialog(b);
            }
        });

        binding.lvBeers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dialog dialog = new Dialog(MainActivity3.this);
                dialog.setContentView(R.layout.custom_dialog);

                Beers b = beers.get(i);

                ImageView imvPhoto = dialog.findViewById(R.id.imvPhotoCustom);
                imvPhoto.setImageResource(b.getBeerThumb());

                TextView txtName = dialog.findViewById(R.id.txtNameCustom);
                txtName.setText(b.getBeerName());

                TextView txtPrice = dialog.findViewById(R.id.txtPriceCustom);
                txtPrice.setText(b.getBeerPrice()+"");

                Button cancel = dialog.findViewById(R.id.btncancel);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCanceledOnTouchOutside(false);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                return true;
            }
        });
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