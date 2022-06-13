package udesc.diskgaseagua.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.view.adm.ViewHomeAdm;
import udesc.diskgaseagua.view.client.ViewCadastrarCliente;

public class Login extends AppCompatActivity {

    private Button btEntrar, btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btEntrar    = findViewById(R.id.btEntrar);
        btCadastrar = findViewById(R.id.btCadastrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ViewHomeAdm.class);
                startActivity(intent);
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ViewCadastrarCliente.class);
                startActivity(intent);
            }
        });
    }
}