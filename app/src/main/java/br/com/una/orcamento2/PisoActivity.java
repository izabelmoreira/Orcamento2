package br.com.una.orcamento2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PisoActivity extends AppCompatActivity {

    private EditText edtQuantidade;
    private Boolean finalizar = false;
    private Button btnOk;
    private Button btnCancel;
    private RadioGroup rgOpcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piso);
        edtQuantidade = findViewById(R.id.edtQuantidade);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (edtQuantidade.length() == 0) {

                    AlertDialog.Builder mensagem = new AlertDialog.Builder(PisoActivity.this);
                    mensagem.setTitle("Atenção!");
                    mensagem.setMessage("Obrigatório digitar a quantidade");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                } else {

                    float resultado = 0;
                    String valor="";

                    edtQuantidade = findViewById(R.id.edtQuantidade);
                    valor = edtQuantidade.getText().toString();


                    rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);

                    int op = rgOpcoes.getCheckedRadioButtonId();

                    if (op == R.id.rb1Piso){
                        resultado =  Float.parseFloat(valor) * 75;
                        finalizar = true;
                    }
                        else if (op == R.id.rb2Piso){
                        resultado = Float.parseFloat(valor)* 125;
                        finalizar = true;
                    }
                        else {
                        resultado = Float.parseFloat(valor) * 100;
                        finalizar = true;
                    }

                    if (finalizar == true) {
                        Intent intent = new Intent();
                        intent.putExtra("resultado", resultado);
                        setResult(1, intent);
                        finish();
                    }


                }

            }


        });
    }
}
