package udesc.diskgaseagua.view.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import udesc.diskgaseagua.R;

public class ViewPedidosCliente extends AppCompatActivity {

    private Button btSomenteAgua, btSomenteGas, btAmbos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_cliente);


        btSomenteAgua = findViewById(R.id.btSomenteAgua);
        btSomenteGas = findViewById(R.id.btSomenteGas);
        btAmbos = findViewById(R.id.btConfirmarCarrinho);

        btAmbos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPedidosCliente.this, ViewCarrinho.class);
                startActivity(intent);
            }
        });
    }
}