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

public class ParedeActivity extends AppCompatActivity {

    EditText edtQuantidade2;
    private Boolean finalizar = false;
    private Button btnOk2;
    private Button btnCancel2;
    private RadioGroup rgOpcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parede);
        edtQuantidade2 = findViewById(R.id.edtQuantidade2);

        btnCancel2 = findViewById(R.id.btnCancel2);
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOk2 = findViewById(R.id.btnOk2);
        btnOk2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (edtQuantidade2.length() == 0) {

                    AlertDialog.Builder mensagem = new AlertDialog.Builder(ParedeActivity.this);
                    mensagem.setTitle("Atenção!");
                    mensagem.setMessage("Obrigatório digitar a quantidade");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                } else {

                    float resultado = 0;
                    String valor = "";

                    edtQuantidade2 = findViewById(R.id.edtQuantidade2);
                    valor = edtQuantidade2.getText().toString();

                    rgOpcoes = (RadioGroup) findViewById(R.id.rgOpcoes);

                    int op = rgOpcoes.getCheckedRadioButtonId();

                    if (op == R.id.rb1Parede) {
                        resultado = Float.parseFloat(valor) * 35;
                        finalizar = true;
                    } else if (op == R.id.rb2Parede) {
                        resultado = Float.parseFloat(valor) * 55;
                        finalizar = true;
                    }


                    if (finalizar == true) {
                        Intent intent = new Intent();
                        intent.putExtra("resultado", resultado);
                        setResult(2, intent);
                        finish();
                    }


                }

            }
        });
    }
}
