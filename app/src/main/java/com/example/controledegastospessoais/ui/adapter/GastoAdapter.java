package com.example.controledegastospessoais.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controledegastospessoais.R;
import com.example.controledegastospessoais.modelo.Gastos;
import com.example.controledegastospessoais.ui.adapter.listener.GastosItemClickListener;

import java.util.List;

public class GastoAdapter extends RecyclerView.Adapter<GastoAdapter.ViewHolder> {

    private Context context;
    private GastosItemClickListener gastosItemClickListener;
    private List<Gastos> gastos;

    public GastoAdapter(List<Gastos> gastos, Context context) {
        this.gastos = gastos;
        this.context = context;
    }

    public void setOnItemClickListener(GastosItemClickListener gastosItemClickListener) {
        this.gastosItemClickListener = gastosItemClickListener;
    }

    @NonNull
    @Override
    public GastoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_gastos, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GastoAdapter.ViewHolder holder, int position) {
        Gastos gasto = gastos.get(position);
        holder.vicula(gasto);
    }

    @Override
    public int getItemCount() {
        return gastos.size();
    }

    public void removeItemGastos(int adapterPosition){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText textDescricao;
        private EditText textCategoria;
        private EditText textData;
        private EditText textValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDescricao = itemView.findViewById(R.id.txtDescricao);
            textCategoria = itemView.findViewById(R.id.txtCategoria);
            textData = itemView.findViewById(R.id.txtData);
            textValor = itemView.findViewById(R.id.txtPreco);
        }

        public void vicula(Gastos gasto) {
            textDescricao.setText(gasto.getDescricao());
            textCategoria.setText(gasto.getCategoria());
            textData.setText(gasto.getData());
            textValor.setText(gasto.getValorComoString());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicao = getAdapterPosition();
                    Gastos gasto = gastos.get(getAdapterPosition());
                    gastosItemClickListener.itemClick(gasto, posicao);
                }
            });
        }
    }
}
