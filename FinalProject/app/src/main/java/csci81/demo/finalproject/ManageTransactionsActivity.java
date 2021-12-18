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

import androidx.appcompat.app.AppCompatActivity;
import csci81.demo.finalproject.realm.Rental;
import csci81.demo.finalproject.realm.Transaction;
import csci81.demo.finalproject.realm.User;
import io.realm.Realm;

@EActivity(R.layout.manage_transaction_row_layout)
public class ManageTransactionsActivity extends AppCompatActivity {
    Gson gson = new Gson();

    Realm realm;

    @ViewById
    TextView movie;
    @ViewById
    TextView quantity;
    @ViewById
    TextView status;

    @AfterViews
    public void init() {
        realm.init(this);

        realm = Realm.getDefaultInstance();
        SharedPreferences sharedPreferences = getSharedPreferences("userSharedPrefs", MODE_PRIVATE);
        User loggedUser = gson.fromJson(sharedPreferences.getString("loggedUser", null), User.class);

        User existingUser = realm.where(User.class)
                .equalTo("uuid", loggedUser.getUserID())
                .findFirst();

        if (existingUser != null) {
            List<Transaction> transactionList = realm.where(Transaction.class)
                    .findAll();

            for (Transaction transaction : transactionList) {

            }
        }
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