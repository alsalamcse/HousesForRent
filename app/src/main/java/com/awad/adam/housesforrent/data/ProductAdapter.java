package com.awad.adam.housesforrent.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.awad.adam.housesforrent.R;

import static com.awad.adam.housesforrent.R.id.parent;

/**
 * Created by user on 30/04/2018.
 */

public class ProductAdapter extends ArrayAdapter<Product>
{
    public ProductAdapter (@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);

    }
    @NonNull
    @Override

public View getView (int postition, @Nullable View convertView, @Nullable ViewGroup parent)
    {

        View view= LayoutInflater.from(getContext()).inflate(R.layout.prodcut_item, parent,false);

        TextView tvName=(TextView) view.findViewById(R.id.TvName);
        TextView tvprice=(TextView) view.findViewById(R.id.tvprice);
        TextView tvAmount= (TextView) view.findViewById(R.id.tvAmount);

                ;

        Product p=getItem(postition);

        tvName.setText(p.getName());
        tvprice.setText(p.getPrice()+"");
        tvAmount.setText(p.getAmount()+"");


        return view;
    }
}









