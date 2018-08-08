package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TESTE1 = 11,TESTE2 = 22, TESTE3 = 33,CONF = 44, CANC = 55;
    public void sendToTeste(int n){
        Intent i = new Intent(this,TesteActivity.class);
        startActivityForResult(i,n);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openTeste1(View v){
        sendToTeste(11);
    }
    public void openTeste2(View v){
        sendToTeste(22);
    }
    public void openTeste3(View v){
        sendToTeste(33);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int resultado = 0;
        if (data != null){
            Bundle dados = data.getExtras();
            resultado = dados.getInt("resultado");
        }
        if(requestCode == TESTE1){
            if(resultCode == CONF){
                TextView tv = findViewById(R.id.tv_r1);
                tv.setText(""+resultado);
            }
        }else if (requestCode == TESTE2){
            if(resultCode == CONF){
                TextView tv = findViewById(R.id.tv_r2);
                tv.setText(""+resultado);
            }
        }else if (requestCode == TESTE3){
            if(resultCode == CONF){
                TextView tv = findViewById(R.id.tv_r3);
                tv.setText(""+resultado);
            }
        }

    }
}
