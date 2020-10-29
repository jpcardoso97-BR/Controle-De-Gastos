package com.example.controledegastospessoais.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.controledegastospessoais.R;
import com.example.controledegastospessoais.database.AppDatabase;
import com.example.controledegastospessoais.modelo.Gastos;
import com.example.controledegastospessoais.ui.adapter.GastoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewGastos;
    private FloatingActionButton floatingActionButton;
    static List<Gastos> gastosList;

    private GastoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickButton();
        configuraRecyclerView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data.hasExtra("NOVO_GASTO")){
            if (resultCode == Activity.RESULT_OK){
                Gastos gastos = (Gastos) data.getSerializableExtra("NOVO_GASTO");
                AppDatabase.getInstance(getApplicationContext()).gastosDAO().insert(gastos);
                gastosList.clear();
                gastosList.addAll(AppDatabase.getInstance(getApplicationContext()).gastosDAO().getAll());
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void clickButton(){
        floatingActionButton = findViewById(R.id.fabRecyclerView);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormGastosActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void configuraRecyclerView(){
        recyclerViewGastos = findViewById(R.id.recyclerViewGastos);
        recyclerViewGastos.setLayoutManager(new LinearLayoutManager(this));


    }
}