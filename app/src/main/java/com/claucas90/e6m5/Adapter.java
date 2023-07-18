package com.claucas90.e6m5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<DatosLista> dataList;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    public Adapter(List<DatosLista> dataList){
        this.dataList=dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        DatosLista data =dataList.get(position);
        int x=position;
        holder.textView.setText(data.getDato());
        Glide.with(holder.itemView).load(data.getUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(x);

            }
        });
    }

    @Override
    public int getItemCount(){
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView2);
        }
    }
}