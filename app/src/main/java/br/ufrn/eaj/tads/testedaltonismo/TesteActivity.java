package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TesteActivity extends AppCompatActivity {
    public static final int TESTE1 = 11,TESTE2 = 22, TESTE3 = 33,CONF = 44, CANC = 55;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        Bundle params = getIntent().getExtras();
        int idImage = 0;
        if (params != null){
            idImage = params.getInt("idImage");
        }
        ImageView iv = findViewById(R.id.imageView);
        if(idImage == 1){
            iv.setImageResource(R.drawable.teste1);
        }else if(idImage == 2){
            iv.setImageResource(R.drawable.teste2);
        }else if(idImage == 3){
            iv.setImageResource(R.drawable.teste3);
        }

}
    public void cliqueOk(View v){
        EditText et = findViewById(R.id.et_res);
        Intent i = new Intent();
        Bundle data = new Bundle();
        if(et.getText().toString().equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Informe um valor", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            int resultado = Integer.parseInt(et.getText().toString());
            data.putInt("resultado",resultado);
            i.putExtras(data);
            setResult(44,i);
            finish();
        }

    }
    public void cliqueCanc(View v){
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imv = findViewById(R.id.imageView);
        if(requestCode == RESULT_OK){
            if(resultCode == TESTE2){
                imv.setBackgroundResource(R.drawable.teste2);
                //tv.setText(""+resultado);
            }
        }/*else if (requestCode == TESTE2){
            if(resultCode == CONF){
                TextView tv = findViewById(R.id.tv_r2);
                tv.setText(""+resultado);
            }
        }else if (requestCode == TESTE3){
            if(resultCode == CONF){
                TextView tv = findViewById(R.id.tv_r3);
                tv.setText(""+resultado);
            }
        }*/
    }
}
