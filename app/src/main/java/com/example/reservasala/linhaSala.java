package com.example.reservasala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class linhaSala extends BaseAdapter {


        private ArrayList<HashMap<String,String>> lista;
        private LayoutInflater mLayoutInflater;
        private Context mContext;

        public linhaSala(ArrayList<HashMap<String,String>> lista,Context c) {
            this.lista = lista;
            this.mContext = c;
            mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = mLayoutInflater.inflate(R.layout.lista_linha,parent,false);
            Holder h = new Holder();

            h._id = (TextView)(view.findViewById(R.id.tvIdSala));
            h.nSala = (TextView)(view.findViewById(R.id.tvNSala));
            h.infoSala = (TextView)(view.findViewById(R.id.tvInfoSala));

            HashMap<String,String> hashMap = new HashMap<>();
            hashMap = lista.get(position);

            h._id.setText(hashMap.get("_id"));
            h.nSala.setText(hashMap.get("nSala"));
            h.infoSala.setText(hashMap.get("infoSala"));


            return view;
        }


        private class Holder
        {
            TextView _id;
            TextView nSala;
            TextView infoSala;
        }
    }