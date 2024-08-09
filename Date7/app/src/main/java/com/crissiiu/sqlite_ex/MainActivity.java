package com.crissiiu.sqlite_ex;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
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
import java.util.function.ToIntFunction;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static final String DATABASE_NAME = "product_db.db";
    public static final String DATABASE_FOLDER = "databases";
    public static final String TBL_NAME = "Product";

    public static final String TBL_ID = "ProductId";
    public static final String TBL_PRICE = "ProductPrice";
    public static final String TBL_NAME2 = "ProductName";

    public static SQLiteDatabase db = null;
    ArrayAdapter<Product> adapter;
    ArrayList<Product> productList;
    private Product selectedProduct = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prepareDB();
        openDB();
//        loadDB();
        registerForContextMenu(binding.lvProduct);
        addEvents();
    }

    private void addEvents() {
        binding.lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedProduct = adapter.getItem(i);
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDB();
    }

    private void openDB() {
        db = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
    }

    private void loadDB() {
        productList = new ArrayList<>();
        Product product;
        //Load data
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME + " WHERE " + TBL_PRICE + ">?", new String[]{"15000"});
//        Cursor cursor = db.query("TBL_NAME" , null, TBL_PRICE + ">=?" , new String[]{"15000"}, null, null, null);

        Cursor cursor = db.query(TBL_NAME,null,null, null, null, null, null);
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

    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnAdd){
            //Insert data into db
//            Dialog dialog = new Dialog(MainActivity.this);
//            dialog.setContentView(R.layout.activity_add);
//            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            dialog.show();
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnUpdate){
            //Open activity update
            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            if (selectedProduct!=null){
                intent.putExtra("data",selectedProduct);
                startActivity(intent);
            }
        } else if (item.getItemId() == R.id.mnDelete) {
            if (selectedProduct != null){
                //Create dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setIcon(R.drawable.baseline_delete_24);
                builder.setMessage("Bạn có chắn chắn muốn xóa sản phẩm " + selectedProduct.getProductName() + " ?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Delete
                        int numbOfRow = MainActivity.db.delete(TBL_NAME, TBL_ID + "=?", new String[]{String.valueOf(selectedProduct.getId())});
                        if(numbOfRow > 0) {
                            Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                            loadDB();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Delete Fail", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                Dialog dialog = builder.create();
                dialog.show();

            }
        }
        return super.onContextItemSelected(item);
    }
}