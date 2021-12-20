package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import csci81.demo.finalproject.realm.Movie;
import csci81.demo.finalproject.realm.Transaction;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

import static android.content.Context.MODE_PRIVATE;

public class CartAdapter extends RealmRecyclerViewAdapter<Transaction, CartAdapter.ViewHolder> {

    Realm realm;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, price;
        ImageButton add;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movieTitle);
            price = itemView.findViewById(R.id.moviePrice);
        }
    }

    CheckoutPage checkoutPage;

    public CartAdapter(CheckoutPage activity, OrderedRealmCollection<Transaction> data, boolean autoUpdate) {
        super(data, autoUpdate);
        checkoutPage = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = checkoutPage.getLayoutInflater().inflate(R.layout.video_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction movie = getItem(position);

        holder.title.setText(movie.getRentalID());
        holder.price.setText("0");

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = checkoutPage.getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();

                String transcationID = UUID.randomUUID().toString();

                String movieID = (transcationID.toString());
                edit.putString("movieID", movieID);
                edit.apply();

                Toast t = Toast.makeText(checkoutPage, "Added to Cart", Toast.LENGTH_LONG);
                t.show();

            }


        });
    }

}

