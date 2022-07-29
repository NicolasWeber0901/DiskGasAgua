package udesc.diskgaseagua.view.client;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import java.util.Calendar;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Pedido;
import udesc.diskgaseagua.view.Login;


public class ViewCarrinho extends AppCompatActivity {

    private Button btCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_carrinho);

        btCarrinho = findViewById(R.id.btConfirmarCarrinho);

        btCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pedido pedido = new Pedido(Banco.getUser().getUid(), "Pix", 130, Calendar.getInstance().getTime());

                Banco.getDb().collection("pedidos")
                        .add(pedido).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                enviarMensagemLonga("Pedido cadastrado");

                                Intent intent = new Intent(ViewCarrinho.this,
                                        ViewPedidosCliente.class);
                                startActivity(intent);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                enviarMensagemCurta("Erro ao gravar");
                            }
                        });
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
}


