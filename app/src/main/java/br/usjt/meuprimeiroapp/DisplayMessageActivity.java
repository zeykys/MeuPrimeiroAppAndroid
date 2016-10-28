package br.usjt.meuprimeiroapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String DATA_MESSAGE = "br.usjt.DATA";
    ArrayList<String> periodo;
    Activity atividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        atividade=this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        periodo = buscaPeriodo(chave);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, periodo);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(atividade, DetalheActivity.class);
                intent.putExtra(DATA_MESSAGE,periodo.get(position));
                startActivity(intent);
            }
        });


    }
    public ArrayList<String>buscaPeriodo(String chave){
        ArrayList<String>periodo = geraPeriodo();
        if(chave==null||chave.length()==0){
            return periodo;
        }else{
            ArrayList<String>subLista = new ArrayList<>();
            for(String registro:periodo){
                if(registro.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(registro);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraPeriodo(){
        ArrayList<String>lista = new ArrayList<>();
        lista.add("19/10/2016 - Pagamento Fornecedor - R$-400,00");
        lista.add("19/10/2016 - Lojas Renner - R$-150,00");
        lista.add("20/10/2016 - Tarifa Bancaria - R$-5000,00");
        lista.add("21/10/2016 - Recebimento Fornecedor - R$900,00");
        lista.add("21/10/2016 - SuperMercado Extra - R$255,00");
        lista.add("21/10/2016 - Coco Bambu Restaurante - R$300,00");
        lista.add("22/10/2016 - Posto Ipiranga - R$-50,00");
        lista.add("22/10/2016 - PetShop - R$-25,00");
        lista.add("23/10/2016 - Pizzaria Mahadi - R$-40,00");
        lista.add("24/10/2016 - Padaria Santa Izildinha - R$30,00");
        return lista;
    }
}
