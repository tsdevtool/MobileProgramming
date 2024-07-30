package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.date5.R;
import com.example.models.Beers;

import java.util.List;

public class BeerAdapter extends BaseAdapter {

    public BeerAdapter(Activity context, int item_layout, List<Beers> beers) {
        this.context = context;
        this.item_layout = item_layout;
        this.beers = beers;
    }

    Activity context;

    int item_layout;

    //Nguon du lieu
    List<Beers> beers;








    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Object getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //Tham chieu den cac view tren item_list
    //Nap du lieu
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(item_layout, null);

            //Link views o item_list
            holder.imvPhoto = view .findViewById(R.id.imvPhoto);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //binding data
        Beers b = beers.get(i);
        holder.txtName.setText(b.getBeerName());
        holder.txtPrice.setText(b.getBeerPrice()+"");
        holder.imvPhoto.setImageResource(b.getBeerThumb());

        return view;
    }

    public static class ViewHolder{
        ImageView imvPhoto;
        TextView txtName, txtPrice;

    }
}
