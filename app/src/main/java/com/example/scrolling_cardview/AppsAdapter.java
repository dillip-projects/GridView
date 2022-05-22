package com.example.scrolling_cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.MyViewHolder>  {

    private Context context;
    public List<AppsModel> appsModelList;

    //step 3 : implementing methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_app,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AppsAdapter.MyViewHolder holder, int position) {

        AppsModel appsModel=appsModelList.get(position);
        holder.title.setText(appsModel.getName());
        holder.appdown.setText(appsModel.getNumofDownloads()+"users");

        //displaying image use glide library

        Glide.with(context).load(appsModel.getThumbail()).
                into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return appsModelList.size();
    }
    //step 1 - my view holder class

    public class MyViewHolder extends RecyclerView.ViewHolder{

         public TextView title,appdown;
         public ImageView thumbnail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.titletext);
            appdown=itemView.findViewById(R.id.count);
            thumbnail=itemView.findViewById(R.id.thumbnail);

        }
    }
    //step 2 : varibales & constructors


    public AppsAdapter(Context context, List<AppsModel> appsModelList) {
        this.context = context;
        this.appsModelList = appsModelList;
    }



}
