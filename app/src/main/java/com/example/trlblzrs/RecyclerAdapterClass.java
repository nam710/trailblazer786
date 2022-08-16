package com.example.trlblzrs;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterClass extends RecyclerView.Adapter<RecyclerAdapterClass.myViewHolder> {

    ArrayList<ClassModel> dataholder;



    public RecyclerAdapterClass(ArrayList<ClassModel> holder) {
        this.dataholder = holder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_row,parent,false);
       return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.Title.setText(dataholder.get(position).getTitle());
        holder.Subject.setText(dataholder.get(position).getSubject());

        holder.CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),class_activity.class);
                view.getContext().startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

    TextView Title,Subject;
    CardView CardView;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        Title = itemView.findViewById(R.id.title);
        Subject = itemView.findViewById(R.id.subject);
        CardView = itemView.findViewById(R.id.class_card);

    }
}

}
