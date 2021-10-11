package com.example.sqlitenotuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Scores> notlarListe;

    public Adapter(Context mContext, List<Scores> notlarListe) {
        this.mContext = mContext;
        this.notlarListe = notlarListe;
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {
        final Scores not = notlarListe.get(position);

        holder.textViewDers.setText(not.getDers_adi());
        holder.textViewNot1.setText(String.valueOf(not.getNot1()));
        holder.textViewNot2.setText(String.valueOf(not.getNot2()));

        holder.not_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,info.class);

                intent.putExtra("nesne",not);

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return notlarListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewDers;
        private TextView textViewNot1;
        private TextView textViewNot2;
        private CardView not_card;

        public CardTasarimTutucu(View itemView) {
            super(itemView);
            textViewDers = itemView.findViewById(R.id.textViewDers);
            textViewNot1 = itemView.findViewById(R.id.textViewNot1);
            textViewNot2 = itemView.findViewById(R.id.textViewNot2);
            not_card = itemView.findViewById(R.id.not_card);
        }
    }
}
