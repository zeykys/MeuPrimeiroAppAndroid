package br.usjt.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        TextView periodo = (TextView)findViewById(R.id.periodo_selecionado);
        Intent intent = getIntent();
        periodo.setText(intent.getStringExtra(DisplayMessageActivity.DATA_MESSAGE));
    }
}
