package udesc.diskgaseagua.view.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import udesc.diskgaseagua.R;

import androidx.appcompat.app.AppCompatActivity;

public class ViewHomeCliente extends AppCompatActivity {



    private Button btPedidosCliente, btHistoricoCompraCliente, btContasPagarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_cliente);

        btPedidosCliente = findViewById(R.id.btPedidosCliente);
        btHistoricoCompraCliente = findViewById(R.id.btHistoricoCompraCliente);
        btContasPagarCliente = findViewById(R.id.btContasPagarCliente);


        btPedidosCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewPedidosCliente.class);
                startActivity(intent);
            }
        });

        btHistoricoCompraCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewHistoricoCompraCliente.class);
                startActivity(intent);
            }
        });

        btHistoricoCompraCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewHistoricoCompraCliente.class);
                startActivity(intent);
            }
        });

        btContasPagarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewContasPagarCliente.class);
                startActivity(intent);
            }
        });


    }
}
