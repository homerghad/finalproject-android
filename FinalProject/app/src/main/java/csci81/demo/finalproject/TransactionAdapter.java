package csci81.demo.finalproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import csci81.demo.finalproject.ManageTransactionsActivity;
import csci81.demo.finalproject.realm.Rental;
import csci81.demo.finalproject.realm.Transaction;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class TransactionAdapter extends RealmRecyclerViewAdapter<Rental, TransactionAdapter.ViewHolder> {
    // IMPORTANT
    // THE CONTAINING ACTIVITY NEEDS TO BE PASSED SO YOU CAN GET THE LayoutInflator(see below)
    ManageTransactionsActivity activity;

    public TransactionAdapter(ManageTransactionsActivity activity, @Nullable OrderedRealmCollection<Rental> data, boolean autoUpdate) {
        super(data, autoUpdate);

        // THIS IS TYPICALLY THE ACTIVITY YOUR RECYCLERVIEW IS IN
        this.activity = activity;
    }

    // THIS DEFINES WHAT VIEWS YOU ARE FILLING IN
    public class ViewHolder extends RecyclerView.ViewHolder {
        // have a field for each one
        TextView movie;
        TextView quantity;
        TextView status;

        ImageButton returnButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialize them from the itemView using standard style
            movie = itemView.findViewById(R.id.movie);
            quantity = itemView.findViewById(R.id.quantity);
            status = itemView.findViewById(R.id.status);

            // initialize the buttons in the layout
            returnButton = itemView.findViewById(R.id.returnButton);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create the raw view for this ViewHolder
        View v = activity.getLayoutInflater().inflate(R.layout.manage_transaction_row_layout, parent, false);  // VERY IMPORTANT TO USE THIS STYLE

        // assign view to the viewholder
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // gives you the data object at the given position
        Rental rental = getItem(position);

        // copy all the values needed to the appropriate views
        holder.movie.setText(rental.getMovieID().toString());
        holder.quantity.setText(rental.getQuantity());
        holder.status.setText(rental.getStatus());

        // NOTE: MUST BE A STRING NOT INTs, etc.
        // String.valueOf() converts most types to a string
        // holder.age.setText(String.valueOf(u.getAge()));

        // do any other initializations here as well,  e.g. Button listeners
        holder.returnButton.setTag(rental);
        holder.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog((Rental) view.getTag(), activity, "Are you sure you want to return?");
                dialog.show(activity.getSupportFragmentManager(), "dialog");
            }
        });
    }
}
