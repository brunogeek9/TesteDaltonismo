package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int TESTE1 = 11,TESTE2 = 22, TESTE3 = 33,CONF = 44, CANC = 55;
    public void sendToTeste(int n,int idImage){
        Intent i = new Intent(this,TesteActivity.class);
        i.putExtra("idImage", idImage) ;
        startActivityForResult(i,n);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openTeste1(View v){
        sendToTeste(11,1);
    }
    public void openTeste2(View v){
        sendToTeste(22,2);
    }
    public void openTeste3(View v){
        sendToTeste(33,3);
    }
    public void cliqueVerificar(View v){
        TextView tvr = findViewById(R.id.tv_res);
        TextView r1 = findViewById(R.id.tv_r1);
        TextView r2 = findViewById(R.id.tv_r2);
        TextView r3 = findViewById(R.id.tv_r3);
        int res1 = Integer.parseInt(r1.getText().toString());
        int res2 = Integer.parseInt(r2.getText().toString());
        int res3 = Integer.parseInt(r3.getText().toString());
        if(res1 == 0 || res2==0 || res3==0){
            Toast toast = Toast.makeText(getApplicationContext(), "Por favor, complete o teste", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            if(res2 == 29 && res3 == 74 && res1==8){
                tvr.setText("Normal");
            }else{
                tvr.setText("Procurar um médico");
            }
        }
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
