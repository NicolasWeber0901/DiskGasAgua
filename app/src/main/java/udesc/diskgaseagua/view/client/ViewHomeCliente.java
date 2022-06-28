package udesc.diskgaseagua.view.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import udesc.diskgaseagua.R;
import udesc.diskgaseagua.view.client.ViewPedidosCliente;

import androidx.appcompat.app.AppCompatActivity;

public class ViewHomeCliente extends AppCompatActivity {



    private Button btPedidosCliente, btHistoricoComprasCliente, btContasPagarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_cliente);

        btPedidosCliente = findViewById(R.id.btPedidosCliente);
        btHistoricoComprasCliente = findViewById(R.id.btHistoricoComprasCliente);
        btContasPagarCliente = findViewById(R.id.btContasPagarCliente);


        btPedidosCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewPedidosCliente.class);
                startActivity(intent);
            }
        });

        btHistoricoComprasCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeCliente.this, ViewHistoricoComprasCliente.class);
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
