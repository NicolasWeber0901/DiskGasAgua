package udesc.diskgaseagua.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.view.adm.ViewHomeAdm;
import udesc.diskgaseagua.view.client.ViewCadastrarCliente;
import udesc.diskgaseagua.view.client.ViewHomeCliente;

public class Login extends AppCompatActivity {

    private Button btEntrar, btCadastrar;
    private EditText tfCpfLogin, tfSenhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        iniciarComponentes();

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cpf      = tfCpfLogin.getText().toString();
                String senha    = tfSenhaLogin.getText().toString();

                Banco.getDb().collection("administrador")
                        .whereEqualTo("cpf", cpf)
                        .whereEqualTo("senha", senha)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {

                                        enviarMensagemLonga("Logado com sucesso");

                                        Intent intent = new Intent(Login.this, ViewHomeAdm.class);
                                        startActivity(intent);
                                    }
                                } else {
                                    enviarMensagemLonga("Verifique os dados");
                                    Log.w("Banco", "Error getting documents.", task.getException());
                                }
                            }
                        });
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

    public void enviarMensagemLonga(String mensagem){
        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public void enviarMensagemCurta(String mensagem){
        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void iniciarComponentes() {

        tfCpfLogin      = findViewById(R.id.tfCpfLogin);
        tfSenhaLogin    = findViewById(R.id.tfSenhaLogin);

        btEntrar        = findViewById(R.id.btEntrar);
        btCadastrar     = findViewById(R.id.btCadastrar);


    }

}