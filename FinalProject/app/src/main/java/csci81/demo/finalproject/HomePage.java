package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


import csci81.demo.finalproject.realm.Movie;
import csci81.demo.finalproject.realm.User;
import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_home_page)
public class HomePage extends AppCompatActivity {

    @ViewById
    RecyclerView homeRecyclerView;

    @ViewById
    ImageView userImage;

    @ViewById
    EditText searchBox;

    @ViewById
    TextView homeUsername, homeGreeting;

    @ViewById
    Button homeSearchButton, checkoutButton;

    Realm realm;

    @AfterViews
    public void init() {

        userImage.setImageResource(R.mipmap.ic_launcher);

        realm = Realm.getDefaultInstance();

        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String uuid = sp.getString("uuid", null);

        User result = realm.where(User.class)
                .equalTo("userID", uuid)
                .findFirst();

        homeUsername.setText(result.getName());
        homeGreeting.setText("Welcome, " + result.getName() + "!");


//        Movie m = new Movie();
//        m.setTitle("Your Name");
//        m.setRentalCost(100);
//
//        realm.beginTransaction();
//        realm.copyToRealmOrUpdate(m);
//        realm.commitTransaction();

//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
//        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
//        homeRecyclerView.setLayoutManager(mLayoutManager);
//
//        RealmResults<Movie> results = realm.where(Movie.class).findAll();
//
//        MovieAdapter adapter = new MovieAdapter(this, results, true);
//        homeRecyclerView.setAdapter(adapter);
    }

    @Click(R.id.userImage)
    public void clickUserImage() {
        LoginPage_.intent(this).start();
    }

    @Click(R.id.logoutButton)
    public void logOut() {
        LoginPage_.intent(this).start();
        Toast t = Toast.makeText(this, "Successfully logged out", Toast.LENGTH_LONG);
        t.show();
    }

    @Click(R.id.homeSearchButton)
    public void search() {
        Movie result = realm.where(Movie.class)
                .equalTo("title", searchBox.getText().toString())
                .findFirst();
        ResultsPage_.intent(this).start();

    }

    @Click(R.id.checkoutButton)
    public void checkout() {
        //CheckoutPage_.intent(this).start();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }
}
