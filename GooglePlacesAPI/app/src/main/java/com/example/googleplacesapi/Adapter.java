package com.example.googleplacesapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CardTasarimTutucu> {

    private Context mContext;
    private List<PlacesClass> mekanlarListe;

    public Adapter(Context mContext, List<PlacesClass> mekanlarListe) {
        this.mContext = mContext;
        this.mekanlarListe = mekanlarListe;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewMekanAdi,textViewLokasyon,textViewAdres;

        public CardTasarimTutucu(View itemView) {
            super(itemView);

            textViewMekanAdi = itemView.findViewById(R.id.textViewMekanAdi);
            textViewLokasyon = itemView.findViewById(R.id.textViewLokasyon);
            textViewAdres = itemView.findViewById(R.id.textViewAdres);

        }
    }

    @Override
    public CardTasarimTutucu onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(CardTasarimTutucu holder, int position) {
        PlacesClass mekan = mekanlarListe.get(position);

        holder.textViewMekanAdi.setText(mekan.getMekan_adi());
        holder.textViewLokasyon.setText(mekan.getEnlem()+" - "+mekan.getBoylam());
        holder.textViewAdres.setText(mekan.getAdres());

    }

    @Override
    public int getItemCount() {
        return mekanlarListe.size();
    }


}
