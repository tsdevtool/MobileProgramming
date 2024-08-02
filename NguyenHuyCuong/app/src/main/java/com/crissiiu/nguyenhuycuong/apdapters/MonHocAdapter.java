package com.crissiiu.nguyenhuycuong.apdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crissiiu.nguyenhuycuong.R;
import com.crissiiu.nguyenhuycuong.models.MonHoc;

import org.w3c.dom.Text;

import java.util.List;

public class MonHocAdapter extends RecyclerView.Adapter<MonHocAdapter.ViewHolder> {
    public List<MonHoc> lsMonHoc;

    public MonHocAdapter(List<MonHoc> lsMonHoc) {
        this.lsMonHoc = lsMonHoc;
    }

    //chuyen layout san view su dung LayoutInflater
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //doc xml layout file va chuyen doi cac thuoc tinh cua non thanh mot view
        View monHocView = inflater.inflate(R.layout.activity_recycle_view, parent, false);
        //return a new holder instance
        ViewHolder viewHolder = new ViewHolder(monHocView);
        return viewHolder;
    }

    //Render layout o vi tri position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Get the data model based on position
        MonHoc temp = lsMonHoc.get(position);
        //set item view
        holder.txtMonHoc.setText(temp.getMaHP() + " - " + temp.getTenHP());
        holder.txtTenGV.setText(temp.getTenGV());
        Context context = holder.imgView.getContext();
        int imageId = context.getResources().getIdentifier(temp.getTenHinh(),"mipmap",context.getPackageName());
        if(imageId!=0)
            holder.imgView.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return lsMonHoc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView txtMonHoc;
        TextView txtTenGV;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgView = itemView.findViewById(R.id.imgMonHoc);
            txtMonHoc = itemView.findViewById(R.id.txtHocPhan);
            txtTenGV = itemView.findViewById(R.id.txtGiaoVien);

        }
    }
}
