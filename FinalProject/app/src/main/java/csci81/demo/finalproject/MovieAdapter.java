package csci81.demo.finalproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.UUID;

import csci81.demo.finalproject.realm.Movie;
import csci81.demo.finalproject.realm.Transaction;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

public class MovieAdapter extends RealmRecyclerViewAdapter<Movie, MovieAdapter.ViewHolder> {

    Realm realm;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, price;
        ImageButton add;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movieTitle);
            price = itemView.findViewById(R.id.moviePrice);

            add = itemView.findViewById(R.id.addToCart);
        }
    }

    HomePage homePage;

    public MovieAdapter(HomePage activity, OrderedRealmCollection<Movie> data, boolean autoUpdate) {
        super(data, autoUpdate);
        homePage = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = homePage.getLayoutInflater().inflate(R.layout.video_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = getItem(position);

        holder.title.setText(movie.getTitle());
        holder.price.setText(Double.toString(movie.getRentalCost()));

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = homePage.getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();

                String transcationID = UUID.randomUUID().toString();

                String movieID = (transcationID.toString());
                edit.putString("movieID", movieID);
                edit.apply();

                Toast t = Toast.makeText(homePage, "Added to Cart", Toast.LENGTH_LONG);
                t.show();

            }


        });
    }

}

