package udesc.diskgaseagua.view.adm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Pedido;
import udesc.diskgaseagua.model.Usuario;

public class ViewPedidosAdm extends AppCompatActivity {

    private TextView tvPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pedidos_adm);

        tvPedidos = findViewById(R.id.tvPedidos);

        Banco.getDb().collection("pedidos")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<Pedido> pedidos = queryDocumentSnapshots.toObjects(Pedido.class);

                        for(Pedido p : pedidos){
                            tvPedidos.append(p.toString() + "\n" + "\n");
                        }
                    }
                });

    }
}