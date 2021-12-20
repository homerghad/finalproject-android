package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import csci81.demo.finalproject.realm.Rental;
import csci81.demo.finalproject.realm.Transaction;
import csci81.demo.finalproject.realm.User;
import io.realm.Realm;
import io.realm.RealmResults;

@EActivity(R.layout.manage_transaction_page)
public class ManageTransactionsActivity extends AppCompatActivity {
    Gson gson = new Gson();

    Realm realm;

    @ViewById
    TextView movie;
    @ViewById
    TextView quantity;
    @ViewById
    TextView status;
    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    public void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        realm.init(this);

        realm = Realm.getDefaultInstance();

        populateRentals();

        // query the things to display
        RealmResults<Rental> list = realm.where(Rental.class).findAll();

        // initialize Adapter
        TransactionAdapter adapter = new TransactionAdapter(this, list,true);
        recyclerView.setAdapter(adapter);

//        SharedPreferences sharedPreferences = getSharedPreferences("userSharedPrefs", MODE_PRIVATE);
//        User loggedUser = gson.fromJson(sharedPreferences.getString("loggedUser", null), User.class);

//        User existingUser = realm.where(User.class)
//                .equalTo("uuid", loggedUser.getUserID())
//                .findFirst();
//
//        if (existingUser != null) {
//            List<Transaction> transactionList = realm.where(Transaction.class)
//                    .findAll();
//
//            for (Transaction transaction : transactionList) {
//
//            }
//        }
    }

    private void populateRentals() {
        Rental rental1 = new Rental();
        rental1.setUserID(UUID.randomUUID().toString());
        rental1.setMovieID(UUID.randomUUID().toString());
        rental1.setTransactionID(UUID.randomUUID().toString());
        rental1.setRentalID(UUID.randomUUID().toString());
        rental1.setRentalDate("01-01-2022");
        rental1.setQuantity(2);
        rental1.setStatus("Pending Return");

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(rental1);  // save
        realm.commitTransaction();

        Rental rental2 = new Rental();
        rental2.setUserID(UUID.randomUUID().toString());
        rental2.setMovieID(UUID.randomUUID().toString());
        rental2.setTransactionID(UUID.randomUUID().toString());
        rental2.setRentalID(UUID.randomUUID().toString());
        rental2.setRentalDate("01-01-2022");
        rental2.setQuantity(2);
        rental2.setStatus("Pending Return");

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(rental2);  // save
        realm.commitTransaction();

        Rental rental3 = new Rental();
        rental3.setUserID(UUID.randomUUID().toString());
        rental3.setMovieID(UUID.randomUUID().toString());
        rental3.setTransactionID(UUID.randomUUID().toString());
        rental3.setRentalID(UUID.randomUUID().toString());
        rental3.setRentalDate("01-01-2022");
        rental3.setQuantity(2);
        rental3.setStatus("Pending Return");

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(rental3);  // save
        realm.commitTransaction();
    }

    @Click(R.id.returnButton)
    public void clickActionReturn() {
        Dialog dialog = new Dialog("Are you sure you want to return ALL?");
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