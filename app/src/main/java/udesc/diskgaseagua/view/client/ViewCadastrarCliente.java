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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Cliente;
import udesc.diskgaseagua.model.Endereco;
import udesc.diskgaseagua.view.Login;
import udesc.diskgaseagua.view.adm.ViewHomeAdm;

public class ViewCadastrarCliente extends AppCompatActivity {

    private EditText tfNome, tfTelefone, tfCpfCadastro, tfDataNasc, tfRua, tfBairro, tfNumero,
            tfCidade, tfSenha;

    private Button btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cadastrar_cliente);

        iniciarComponentes();

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome         =   tfNome.getText().toString();
                String telefone     =   tfTelefone.getText().toString();
                String cpf          =   tfCpfCadastro.getText().toString();
                String dataNasc     =   tfDataNasc.getText().toString();
                String senha        =   tfSenha.getText().toString();

                String rua          =   tfRua.getText().toString();
                String bairro       =   tfBairro.getText().toString();
                int    numero       =   Integer.parseInt(tfNumero.getText().toString());
                String cidade       =   tfCidade.getText().toString();

                Endereco endereco = new Endereco(rua, bairro, numero, cidade);
                Cliente cliente = new Cliente(nome, cpf, senha, telefone, dataNasc, endereco);

                cadastrarCliente(cliente);
            }
        });
    }

    private void iniciarComponentes(){
        tfNome          =   findViewById(R.id.tfNome);
        tfTelefone      =   findViewById(R.id.tfTelefone);
        tfCpfCadastro   =   findViewById(R.id.tfCpfCadastro);
        tfDataNasc      =   findViewById(R.id.tfDataNasc);
        tfSenha         =   findViewById(R.id.tfSenhaCadastro);

        tfRua           =   findViewById(R.id.tfRua);
        tfBairro        =   findViewById(R.id.tfBairro);
        tfNumero        =   findViewById(R.id.tfNumero);
        tfCidade        =   findViewById(R.id.tfCidade);

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

    private void cadastrarCliente(Cliente c){

        Banco.getDb().collection("clientes").
                add(c).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                        enviarMensagemLonga("Cadastrado com Sucesso! Faça o login.");

                        Intent intent = new Intent(ViewCadastrarCliente.this,
                                Login.class);
                        startActivity(intent);
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