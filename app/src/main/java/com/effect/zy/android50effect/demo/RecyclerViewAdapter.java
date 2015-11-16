package com.effect.zy.android50effect.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.effect.zy.android50effect.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private AdapterView.OnItemClickListener OnItemClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener OnItemClickListener){
        this.OnItemClickListener = OnItemClickListener;

    }

    public static final int[] res = {
            R.mipmap.pic_1,
            R.mipmap.pic_2,
            R.mipmap.pic_3,
            R.mipmap.pic_4,
            R.mipmap.pic_5,
            R.mipmap.pic_6,
            R.mipmap.pic_7,
            R.mipmap.pic_8,
            R.mipmap.pic_9,
            R.mipmap.pic_10
    };

    public RecyclerViewAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_card_main,
                parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.img.setImageResource(res[position]);
        if(OnItemClickListener != null){
//            holder.img.setTransitionName("robot");
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClickListener.onItemClick(null, v, position, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return res.length;
    }

    class MyViewHolder extends ViewHolder {

        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }

}