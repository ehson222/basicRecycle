package com.ea222.team4reminderlistr1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder>{

    Context context;
    List<String> list;
    public adapterClickListener adapterClickListener;
    public adapterDeleteListener adapterDeleteListener;


    public adapter(Context context, List<String> list, adapterClickListener adapterClickListener, adapterDeleteListener adapterDeleteListener){
        this.list = list;
        this.context = context;
        this.adapterClickListener = adapterClickListener;
        this.adapterDeleteListener = adapterDeleteListener;
    }

    public adapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rows,viewGroup,false);
        return new viewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder view, final int i) {
        // i = current position
        view.textView.setText(list.get(i));
        //each row
        view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //NOTE: the 2 lines below are tied to MainActivity, myadapter = new adapter...
               adapterClickListener.onClickListener(i);
               adapterDeleteListener.onDeleteListener(i);
                //Toast.makeText(context,String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.rowView);
    }
    }
}
