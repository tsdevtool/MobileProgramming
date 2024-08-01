package com.crissiiu.hocsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Khai bao cac bien lien quan den db
    String DB_PATH_SUFFIX = "/databases/"; //thu muc chua db
    SQLiteDatabase database = null; //Khai bao ten co so du lieu
    String DATABASE_NAME = "qlsach.db"; //Ten file chua co so du lieu

    //Khai bao listview
    ListView lv;
    List<String> myList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tao cac thong so cho listview
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myList);
        lv.setAdapter(myAdapter);

        //...Tien hanh goi ham copy co so du lieu tu assets vao db, trong bo nho cai dat ung dung.....
        processCopy();
        database = openOrCreateDatabase("qlsach.db",MODE_PRIVATE, null);
        Cursor c  =database.query("tbsach",null,null,null,null,null, null);
        String data = "";
        c.moveToFirst();
        while(!c.isAfterLast()){
            data = c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2) + " - " + c.getString(3);
            myList.add(data);
            c.moveToNext();
        }
        c.close();
        myAdapter.notifyDataSetChanged();


    }

    //Ham copy CSDL SQLite tu thu muc assets vao thu muc cai dat ung dung
    private void processCopy() {
    //private app
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!((File) dbFile).exists())
        {
            try{CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset() {
// TODO Auto-generated method stub
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
// Path to the just created empty db
            String outFileName = getDatabasePath();
// if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
// Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
// transfer bytes from the inputfile to the outputfile
// Truyền bytes dữ liệu từ input đến output
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
// Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}