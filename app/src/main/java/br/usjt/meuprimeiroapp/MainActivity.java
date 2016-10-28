package br.usjt.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inicio;
    public final static String EXTRA_MESSAGE = "br.usjt.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio = (EditText)findViewById(R.id.edit_message);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String chave = inicio.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, chave);
        startActivity(intent);
    }
}
