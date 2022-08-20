package com.example.trlblzrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TTListCustomAdapter extends ArrayAdapter<TTList> {

    private Context mContext;
    private int mResource;
    public TTListCustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TTList> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView subject = convertView.findViewById(R.id.TTlistSubject);
        TextView time = convertView.findViewById(R.id.TTlistTime);

        subject.setText(getItem(position).getSubject());
        time.setText(getItem(position).getTime());

        return convertView;
    }
}
