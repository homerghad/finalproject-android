package csci81.demo.finalproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import csci81.demo.finalproject.realm.Movie;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;

public class MovieAdapterV2 extends RealmRecyclerViewAdapter<Movie, MovieAdapterV2.ViewHolder> {

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

    ResultsPage resultsPage;

    public MovieAdapterV2(ResultsPage activity, OrderedRealmCollection<Movie> data, boolean autoUpdate) {
        super(data, autoUpdate);
        resultsPage = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = resultsPage.getLayoutInflater().inflate(R.layout.video_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = getItem(position);

        holder.title.setText(movie.getTitle());
        holder.price.setText(Double.toString(movie.getRentalCost()));

    }

}

