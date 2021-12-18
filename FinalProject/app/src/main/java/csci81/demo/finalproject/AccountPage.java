package csci81.demo.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import csci81.demo.finalproject.realm.User;
import io.realm.Realm;

@EActivity(R.layout.activity_account_page)
public class AccountPage extends AppCompatActivity {

    @ViewById
    TextView accPageUsername;

    @ViewById
    Button changePass, manageInteractions;

    Realm realm;

    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();

        SharedPreferences sp = getSharedPreferences( "MyPrefs",MODE_PRIVATE);
        String uuid = sp.getString("uuid", null);

        User user = realm.where(User.class)
                .equalTo( "userID", uuid)
                .findFirst();

        accPageUsername.setText(user.getName());
    }

    @Click(R.id.changePass)
    public void changePass() {
        ChangePassword_.intent(this).start();
    }

    @Click(R.id.manageInteractions)
    public void manageInteractions() {
        ManageTransactionsActivity_.intent(this).start();
    }

    @Click(R.id.accPageBack)
    public void accPageBack() {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }
}