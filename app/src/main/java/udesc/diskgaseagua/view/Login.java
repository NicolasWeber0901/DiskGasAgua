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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Usuario;
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

                String email        = tfCpfLogin.getText().toString();
                String senha        = tfSenhaLogin.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    enviarMensagemCurta("Preencha todos os campos!");
                } else {
                    verificaLogin(email, senha);
                }
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

        tfCpfLogin      = findViewById(R.id.tfEmailLogin);
        tfSenhaLogin    = findViewById(R.id.tfSenhaLogin);

        btEntrar        = findViewById(R.id.btEntrar);
        btCadastrar     = findViewById(R.id.btCadastrar);


    }

    private void verificaLogin(String email, String senha){


        Banco.getDb().collection("usuarios")
                .whereEqualTo("email", email)
                .whereEqualTo("senha", senha)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<Usuario> usuarios = queryDocumentSnapshots.toObjects(Usuario.class);

                        Usuario u = usuarios.get(0);

                        if(u.getAcesso() == 1){
                            enviarMensagemCurta("Logado com sucesso!");

                            Intent intent = new Intent(Login.this, ViewHomeAdm.class);
                            startActivity(intent);
                            finish();

                        } else if(u.getAcesso() == 2){
                            enviarMensagemCurta("Logado com sucesso!");

                            Intent intent = new Intent(Login.this, ViewHomeCliente.class);
                            startActivity(intent);
                            finish();

                        } else {
                            enviarMensagemLonga("Erro ao logar!");
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        enviarMensagemLonga("Erro interno de servidor");
                        Log.i("Banco", e.getMessage());
                    }
                });

    }


}