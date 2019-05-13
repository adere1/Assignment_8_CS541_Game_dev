package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personAge;
        TextView status;
        TextView appdate;
        TextView followdate;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            status = (TextView)itemView.findViewById(R.id.status);
            appdate = (TextView)itemView.findViewById(R.id.appdate);
            followdate = (TextView)itemView.findViewById(R.id.followdate);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        String x = "Status: "+persons.get(i).status;
        personViewHolder.status.setText(x);
        String color = null ;
        if(persons.get(i).status.equals("Accepted Offer")){
            personViewHolder.status.setTextColor(Color.parseColor("#008000"));
        }
        if(persons.get(i).status.equals("Pending")){
            personViewHolder.status.setTextColor(Color.parseColor("#FFA500"));
        }
        if(persons.get(i).status.equals("Reject")){
            personViewHolder.status.setTextColor(Color.parseColor("#FF0000"));
        }

        String z = "Application Date: " + persons.get(i).appdate;
        personViewHolder.appdate.setText(z);

        String n = "Follow Up Date: " + persons.get(i).followdate;
        personViewHolder.followdate.setText(n);

        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
