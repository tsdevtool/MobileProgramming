package com.crissiiu.sqlite_ex;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.models.Product;
import com.crissiiu.sqlite_ex.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static final String DATABASE_NAME = "product_db.db";
    public static final String DATABASE_FOLDER = "databases";
    public static final String TBL_NAME = "Product";

    SQLiteDatabase db = null;
    ArrayAdapter<Product> adapter;
    ArrayList<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prepareDB();
        openDB();
        loadDB();
    }

    private void openDB() {
        db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

    }

    private void loadDB() {
        productList = new ArrayList<>();
        Product product;
        //Load data
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME, null);
        while(cursor.moveToNext()){
            product = new Product(cursor.getInt(0), cursor.getDouble(2), cursor.getString(1));
            productList.add(product);
        }
        cursor.close();

        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1 ,productList);
        binding.lvProduct.setAdapter(adapter);

    }

    private void prepareDB() {
        try{
            File dbFile = getDatabasePath(DATABASE_NAME);
            if(!dbFile.exists()){
                if (copyDB()){
                    Toast.makeText(this, "Copy Database is Successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Copy Database is Fail", Toast.LENGTH_LONG).show();
                }
            }
        }catch (Exception e){
            Log.e("Error: ", e.toString());
        }
    }

    private  boolean copyDB(){
        String dbPath = getApplicationInfo().dataDir + "/"+ DATABASE_FOLDER +"/" + DATABASE_NAME;
        try{
            InputStream inputStream = getAssets().open(DATABASE_NAME);
            File f = new File(getApplicationInfo().dataDir + "/"+ DATABASE_FOLDER +"/");
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = null;
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                outputStream = Files.newOutputStream(Paths.get(dbPath));
            }
            byte[] buffer = new byte[1024];
            int length;
            while((length = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }
}