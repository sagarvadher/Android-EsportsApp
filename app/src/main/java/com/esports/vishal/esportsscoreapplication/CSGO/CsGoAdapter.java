package com.esports.vishal.esportsscoreapplication.CSGO;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esports.vishal.esportsscoreapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by VISHAL on 8/4/2017.
 */
import android.content.Context;
import android.content.Intent;

public class CsGoAdapter extends RecyclerView.Adapter<CsGoAdapter.ItemHolder> {

    ItemClickListener listener;
    private ArrayList<CsGoItem> csGoItemArrayList;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


 //   ArrayList<CsGoItem> filelist =  (ArrayList<CsGoItem>)getIntent().getSerializableExtra("csArray");


    public CsGoAdapter(ArrayList<CsGoItem> csGoItemArrayList, ItemClickListener listener)
    {
        this.csGoItemArrayList = csGoItemArrayList;
        this.listener = listener;
    }

    public CsGoAdapter(ArrayList<CsGoItem> csGoItemArrayList) {
        this.csGoItemArrayList = csGoItemArrayList;
        // cs = new CsGoScoreActivity();
    }

    public interface ItemClickListener {

        void onItemClick(int clickedItemIndex);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.csgo_rows, parent, shouldAttachToParentImmediately);
        ItemHolder holder = new ItemHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CsGoAdapter.ItemHolder holder, int position) {


        CsGoItem csGoItem = csGoItemArrayList.get(position);

        try {
            Date publishedDate = dateFormat.parse(csGoItem.getDateandtimeofgame());
            holder.dateandtimeofgame.setText("Time : " +publishedDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        holder.seasonname.setText("Season Name" +csGoItem.getSeason_name());
        holder.team_1_name.setText("team_1_name:" +csGoItem.getTeam_1_name());
        holder.team_2_name.setText("Team_2 name:" +csGoItem.getTeam_2_name());
        holder.tournament_type.setText("tournament name:" +csGoItem.getTournament_type());
        holder.team_1_abbreviation.setText("team_1_abbreviation :" +csGoItem.getTeam_1_abbreviation());
        holder.team_2_abbreviation.setText("team_2_abbreviation :" +csGoItem.getTeam_2_abbreviation());
        holder.home_score.setText("Home score:" +csGoItem.getHome_score());
        holder.away_score.setText("Away score:" +csGoItem.getAway_score());
    }

    @Override
    public int getItemCount() {
        return csGoItemArrayList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView dateandtimeofgame;
        public TextView seasonname;
        public TextView team_1_name;
        public TextView team_2_name;
        public TextView tournament_type;
        public TextView team_1_abbreviation;
        public TextView team_2_abbreviation;
        public TextView home_score;
        public TextView away_score;

        public ItemHolder(View itemView) {
            super(itemView);

            dateandtimeofgame = (TextView) itemView.findViewById(R.id.dateandtimeofgame);
            seasonname = (TextView) itemView.findViewById(R.id.seasonname);
            team_1_name = (TextView) itemView.findViewById(R.id.team_1_name);
            team_2_name = (TextView) itemView.findViewById(R.id.team_2_name);
            tournament_type = (TextView) itemView.findViewById(R.id.tournament_type);
            team_1_abbreviation = (TextView) itemView.findViewById(R.id.team_1_abbreviation);
            team_2_abbreviation = (TextView) itemView.findViewById(R.id.team_2_abbreviation);
            home_score = (TextView) itemView.findViewById(R.id.home_score);
            away_score = (TextView) itemView.findViewById(R.id.away_score);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }
    }

}