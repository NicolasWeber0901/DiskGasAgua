package udesc.diskgaseagua.view.client;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Cliente;
import udesc.diskgaseagua.model.Endereco;
import udesc.diskgaseagua.model.Usuario;
import udesc.diskgaseagua.view.Login;
import udesc.diskgaseagua.view.adm.ViewHomeAdm;

public class ViewCadastrarCliente extends AppCompatActivity {

    private EditText tfNome, tfTelefone, tfCpfCadastro, tfEmail, tfRua, tfBairro, tfNumero,
             tfSenha;

    private Button btCadastro;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastrar_cliente);

        mAuth = FirebaseAuth.getInstance();

        iniciarComponentes();

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome         =   tfNome.getText().toString();
                String telefone     =   tfTelefone.getText().toString();
                String cpf          =   tfCpfCadastro.getText().toString();
                String email        =   tfEmail.getText().toString();
                String senha        =   tfSenha.getText().toString();

                String rua          =   tfRua.getText().toString();
                String bairro       =   tfBairro.getText().toString();

                int    numero;

                if(tfNumero.getText().toString().isEmpty()){
                    numero = 0;
                } else {
                    numero = Integer.parseInt(tfNumero.getText().toString());
                }

                if(nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || email.isEmpty() ||
                senha.isEmpty() || rua.isEmpty() || bairro.isEmpty()) {
                    enviarMensagemCurta("Preencha todos os campos!");
                } else {
                    Endereco endereco = new Endereco(rua, bairro, numero, "Dona Emma");
                    Cliente cliente = new Cliente(nome, cpf, senha, email, telefone, endereco);

                    Usuario usuario = new Usuario(email, senha, 2);

                    cadastrarCliente(usuario);
                    salvarCliente(cliente);
                }


            }
        });
    }

    private void iniciarComponentes(){
        tfNome          =   findViewById(R.id.tfNome);
        tfTelefone      =   findViewById(R.id.tfTelefone);
        tfCpfCadastro   =   findViewById(R.id.tfCpfCadastro);
        tfEmail         =   findViewById(R.id.tfEmail);
        tfSenha         =   findViewById(R.id.tfSenhaCadastro);

        tfRua           =   findViewById(R.id.tfRua);
        tfBairro        =   findViewById(R.id.tfBairro);
        tfNumero        =   findViewById(R.id.tfNumero);

        btCadastro      = findViewById(R.id.btCadastro);
    }

    public void enviarMensagemLonga(String mensagem){
        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public void enviarMensagemCurta(String mensagem){
        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void cadastrarCliente(Usuario usuario){

        mAuth.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    String uid = FirebaseAuth.getInstance().getUid();
                    usuario.setUid(uid);

                    salvarUsuario(usuario);

                } else {
                    enviarMensagemCurta("Erro ao gravar.");
                }
            }
        });


    }

    private void salvarCliente(Cliente c){
        Banco.getDb().collection("clientes").
                add(c).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                        enviarMensagemLonga("Cadastrado com Sucesso! Faça o login.");

                        Intent intent = new Intent(ViewCadastrarCliente.this,
                                Login.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        enviarMensagemCurta("Erro ao gravar.");
                        Log.d("Banco", e.toString());

                    }
                });
    }

    private void salvarUsuario(Usuario usuario){
        Banco.getDb().collection("usuarios").
                add(usuario).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                        Log.i("Banco", "Usuario criado com sucesso");

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        enviarMensagemCurta("Erro ao gravar.");
                        Log.d("Banco", e.toString());

                    }
                });
    }
}