package com.crissiiu.nguyenhuycuong;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crissiiu.nguyenhuycuong.apdapters.MonHocAdapter;
import com.crissiiu.nguyenhuycuong.models.MonHoc;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //Anh xa Recycle View
        RecyclerView rvMonHoc = findViewById(R.id.main);
        //Tao adapter va truyen danh sach cac mon hoc
        MonHocAdapter adapter = new MonHocAdapter(MonHoc.LayDSMonHoc());
        rvMonHoc.setAdapter(adapter);
        rvMonHoc.setLayoutManager(new LinearLayoutManager(this));
    }
}