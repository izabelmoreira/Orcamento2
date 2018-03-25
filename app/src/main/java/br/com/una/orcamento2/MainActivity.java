package br.com.una.orcamento2;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtPiso, txtParede, txtTotal;
    private float total, totalPiso, totalParede;
    private Button btnPiso;
    private Button btnParede;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 385 ) {
            if (resultCode == 1 ) {
                if (data != null) {
                    Float resultado = data.getFloatExtra("resultado",0);
                    totalPiso = resultado;
                    txtPiso.setText("R$" + resultado);
                }
            }
        }
        if (requestCode == 385 ) {
            if (resultCode == 2) {
                if (data != null) {
                    Float resultado = data.getFloatExtra("resultado",0);
                    totalParede = resultado;
                    txtParede.setText("R$" + resultado);
                }
            }
        }

        total = totalPiso + totalParede;
        txtTotal.setText("R$" + Float.toString(total));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPiso = findViewById(R.id.txtPiso);
        txtParede = findViewById(R.id.txtParede);

        txtTotal = findViewById(R.id.txtTotal);

        btnPiso = (Button) findViewById(R.id.btnPiso);
        btnPiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PisoActivity.class);
                startActivityForResult(intent, 385);
            }
        });

        btnParede = (Button) findViewById(R.id.btnParede);
        btnParede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ParedeActivity.class);
                startActivityForResult(intent, 385);
            }
        });

    }
}
