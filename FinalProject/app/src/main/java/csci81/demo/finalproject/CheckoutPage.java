package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import csci81.demo.finalproject.realm.Movie;
import csci81.demo.finalproject.realm.Rental;
import csci81.demo.finalproject.realm.Transaction;
import csci81.demo.finalproject.realm.User;
import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.activity_checkout_page)
public class CheckoutPage extends AppCompatActivity {
    Gson gson = new Gson();

    Realm realm;

    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    public void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        realm.init(this);

        realm = Realm.getDefaultInstance();

        // query the things to display
        RealmResults<Transaction> list = realm.where(Transaction.class).findAll();

        // initialize Adapter
        CartAdapter adapter = new CartAdapter(this, list,true);
        recyclerView.setAdapter(adapter);
    }

    @Click(R.id.checkoutClearButton)
    public void clickActionReturn() {
        Dialog dialog = new Dialog("Are you sure you want to clear ALL?");
        dialog.show(this.getSupportFragmentManager(), "dialog");
    }

    public void delete(Rental rental) {
        if (rental.isValid()) {
            realm.beginTransaction();
            rental.deleteFromRealm();
            realm.commitTransaction();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }

    private void showLongToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
