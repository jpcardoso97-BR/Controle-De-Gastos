package com.example.controledegastospessoais.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.controledegastospessoais.R;

public class FormGastosActivity extends AppCompatActivity {

    private EditText descricao;
    private EditText categoria;
    private EditText data;
    private EditText valor;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_gastos);
        carregaCampos();
    }

    private void carregaCampos(){
        descricao = findViewById(R.id.editTxtDescricao);
        categoria = findViewById(R.id.editTxtCategoria);
        data = findViewById(R.id.editTxtData);
        valor = findViewById(R.id.editTxtValor);
        salvar = findViewById(R.id.btnSalvar);
    }

}