package udesc.diskgaseagua.view.adm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import udesc.diskgaseagua.R;

public class ViewHomeAdm extends AppCompatActivity {

    private Button btPedidosAdm, btEstoque, btFornecedores, btClientes, btCaixa, btRelatorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_adm);

        btPedidosAdm    =   findViewById(R.id.btPedidosAdm);
        btEstoque       =   findViewById(R.id.btEstoque);
        btFornecedores  =   findViewById(R.id.btFornecedores);
        btClientes      =   findViewById(R.id.btClientes);
        btCaixa         =   findViewById(R.id.btCaixa);
        btRelatorios    =   findViewById(R.id.btRelatorios);

        btPedidosAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewPedidosAdm.class);
                startActivity(intent);
            }
        });

        btEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewEstoqueAdm.class);
                startActivity(intent);
            }
        });

        btFornecedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewFornecedoresAdm.class);
                startActivity(intent);
            }
        });

        btClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewClientesAdm.class);
                startActivity(intent);
            }
        });

        btCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewCaixaAdm.class);
                startActivity(intent);
            }
        });

        btRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHomeAdm.this, ViewRelatoriosAdm.class);
                startActivity(intent);
            }
        });


    }


}