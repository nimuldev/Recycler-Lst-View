package com.math.recyclearview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {

   List<Informations> informationslist;

    public InformationAdapter(List<Informations> informationslist) {
        this.informationslist = informationslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclearviews,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Informations informations=informationslist.get(position);
        holder.nameTv.setText(informations.getName());
        holder.emailTv.setText(informations.getEmail());
        holder.passwordTv.setText(informations.getPassword());

    }

    @Override
    public int getItemCount() {
        return informationslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv,emailTv,passwordTv;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            nameTv=itemView.findViewById(R.id.nameTVR);
            emailTv=itemView.findViewById(R.id.emailTVR);
            passwordTv=itemView.findViewById(R.id.passwordTVR);
        }
    }
}
