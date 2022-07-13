package udesc.diskgaseagua.view.adm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import udesc.diskgaseagua.R;
import udesc.diskgaseagua.model.Cliente;

public class ViewClientesAdapter extends RecyclerView.Adapter<ViewClientesAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Cliente> clientes;

    public ViewClientesAdapter(Context context, ArrayList<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public ViewClientesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.card_cliente, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClientesAdapter.MyViewHolder holder, int position) {

        Cliente cliente = clientes.get(position);

        holder.nome.setText(cliente.getNome());
        holder.cpf.setText(cliente.getCpf());
        holder.telefone.setText(cliente.getTelefone());
        holder.endereco.setText(cliente.getEndereco().toString());

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome, cpf, telefone, endereco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.clientesNome);
            cpf = itemView.findViewById(R.id.clientesCpf);
            telefone = itemView.findViewById(R.id.clientesTelefone);
            endereco= itemView.findViewById(R.id.clientesEndereco);
        }
    }
}
