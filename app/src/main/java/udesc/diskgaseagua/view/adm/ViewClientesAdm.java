package udesc.diskgaseagua.view.adm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.dao.Banco;
import udesc.diskgaseagua.model.Cliente;
import udesc.diskgaseagua.model.Usuario;

public class ViewClientesAdm extends AppCompatActivity {

    private RecyclerView rcListaClientes;
    private ArrayList<Cliente> clientes;
    private ViewClientesAdapter viewClientesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clientes_adm);

        rcListaClientes = findViewById(R.id.rcListaClientes);
        rcListaClientes.setHasFixedSize(true);
        rcListaClientes.setLayoutManager(new LinearLayoutManager(this));

        clientes = new ArrayList<Cliente>();
        viewClientesAdapter = new ViewClientesAdapter(this, clientes);

        rcListaClientes.setAdapter(viewClientesAdapter);

        buscarClientes();

    }

    private void buscarClientes() {

        Banco.getDb().collection("clientes")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            Log.i("Erro", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if(dc.getType() == DocumentChange.Type.ADDED){

                                clientes.add(dc.getDocument().toObject(Cliente.class));

                            }

                            viewClientesAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }
}