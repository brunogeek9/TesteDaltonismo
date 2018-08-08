package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int teste1 = 11,teste2 = 22, teste3 = 33;
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
}
