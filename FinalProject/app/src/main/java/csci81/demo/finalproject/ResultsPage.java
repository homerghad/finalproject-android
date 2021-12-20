package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import csci81.demo.finalproject.realm.Movie;
import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_results_page)
public class ResultsPage extends AppCompatActivity {

    @ViewById
    RecyclerView searchRecyclerView;

    @ViewById
    Button searchResultsBackButton;

    Realm realm;

    @AfterViews
    public void init() {

        realm = Realm.getDefaultInstance();

        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String searchResults = sp.getString("search", null);


        Movie result = realm.where(Movie.class)
                .equalTo("search", searchResults)
                .findFirst();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        searchRecyclerView.setLayoutManager(mLayoutManager);

        RealmResults<Movie> results = realm.where(Movie.class).findAll();

        MovieAdapterV2 adapter = new MovieAdapterV2(this, results, true);
        searchRecyclerView.setAdapter(adapter);

//        if (result != null) {
//
//            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//            mLayoutManager.setOrientation(RecyclerView.VERTICAL);
//            searchRecyclerView.setLayoutManager(mLayoutManager);
//
//            RealmResults<Movie> results = realm.where(Movie.class).findAll(); //change
//
//            MovieAdapterV2 adapter = new MovieAdapterV2(this, results, true);
//            searchRecyclerView.setAdapter(adapter);
//
//        } else {
//
//            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//            mLayoutManager.setOrientation(RecyclerView.VERTICAL);
//            searchRecyclerView.setLayoutManager(mLayoutManager);
//
//            RealmResults<Movie> results = realm.where(Movie.class).findAll();
//
//            MovieAdapterV2 adapter = new MovieAdapterV2(this, null, true);
//            searchRecyclerView.setAdapter(adapter);
//        }


    }

    @Click(R.id.searchResultsBackButton)
    public void back() {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }
}
