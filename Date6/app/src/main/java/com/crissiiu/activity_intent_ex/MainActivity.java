package com.crissiiu.activity_intent_ex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.activity_intent_ex.databinding.ActivityMainBinding;
import com.crissiiu.models.Products;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.i("MainActivity:", "onCreate");

        addEvent();

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            if(result.getResultCode() == RESULT_OK && result.getData()!=null){
                double res = result.getData().getDoubleExtra("result", 0);
                binding.txtContent.setText(String.valueOf(res));
            }
        } );
    }

    private void addEvent() {
        binding.btnOpenActivityMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening Activity #2
                Intent intent  = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        binding.btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening Activity as Dialog
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        binding.btnOpenActivityMain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening Activity #3
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);

                //Attach Data using putExtra
//                intent.putExtra(Utils.NUMB,89);
//                intent.putExtra(Utils.GRADES, 9.5f);
//                intent.putExtra("checked",true);
//                intent.putExtra("say","Hello");

                //Attach data using Bundle
                Bundle bundle = new Bundle();
                bundle.putInt(Utils.NUMB,85);
                bundle.putFloat(Utils.GRADES, 6.8f);
                bundle.putBoolean(Utils.CHECKED,true);
                bundle.putString(Utils.SAY, "Welcome");

                //Attach object
                Products product = new Products(1, 22000, "Laptop");

                bundle.putSerializable(Utils.MYPRODUCT,product);

                intent.putExtra("myData", bundle);

                startActivity(intent);
            }
        });

        binding.btnOpenActivityMain4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                //sending data
                intent.putExtra("number", binding.edtNumber.getText().toString());

                activityResultLauncher.launch(intent);
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity:", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity:", "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity:", "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity:", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity:", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity:", "onPause");
    }
}