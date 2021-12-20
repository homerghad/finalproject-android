package csci81.demo.finalproject;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import csci81.demo.finalproject.realm.Movie;
import csci81.demo.finalproject.realm.User;
import io.realm.Realm;

@EActivity(R.layout.activity_login_page)
public class LoginPage extends AppCompatActivity {

    @ViewById
    EditText nameInput1, passwordInput1;

    @ViewById
    Button signInButton, registerButton, clearButton;

    @ViewById
    CheckBox checkBox;

    Realm realm;

    @AfterViews
    public void init() {

        realm = Realm.getDefaultInstance();

        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String uuid = sp.getString("uuid", null);
        boolean checked = sp.getBoolean("isBoxChecked", false);

        User result = realm.where(User.class)
                .equalTo("userID", uuid)
                .findFirst();

        if (checked) {
            if (result != null) {
                nameInput1.setText(result.getName());
                passwordInput1.setText(result.getPassword());
                checkBox.setChecked(true);
            } else {
                nameInput1.setText("");
                passwordInput1.setText("");
                checkBox.setChecked(false);
            }
        }

        long count = realm.where(Movie.class).count();

        if (count == 0) {
            Movie m1 = new Movie();

            m1.setMovieID(UUID.randomUUID().toString());
            m1.setTitle("Your Name");
            m1.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m1);
            realm.commitTransaction();

        }

        if (count == 0) {
            Movie m2 = new Movie();

            m2.setMovieID(UUID.randomUUID().toString());
            m2.setTitle("Weathering With You");
            m2.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m2);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m3 = new Movie();

            m3.setMovieID(UUID.randomUUID().toString());
            m3.setTitle("Howl's Moving Castle");
            m3.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m3);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m4 = new Movie();

            m4.setMovieID(UUID.randomUUID().toString());
            m4.setTitle("Princess Mononoke");
            m4.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m4);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m5 = new Movie();

            m5.setMovieID(UUID.randomUUID().toString());
            m5.setTitle("My Neighbor Totoro");
            m5.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m5);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m6 = new Movie();

            m6.setMovieID(UUID.randomUUID().toString());
            m6.setTitle("Kiki's Delivery Services");
            m6.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m6);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m7 = new Movie();

            m7.setMovieID(UUID.randomUUID().toString());
            m7.setTitle("Spirited Away");
            m7.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m7);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m8 = new Movie();

            m8.setMovieID(UUID.randomUUID().toString());
            m8.setTitle("Violet Evergarden");
            m8.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m8);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m9 = new Movie();

            m9.setMovieID(UUID.randomUUID().toString());
            m9.setTitle("Hello World");
            m9.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m9);
            realm.commitTransaction();
        }

        if (count == 0) {
            Movie m10 = new Movie();

            m10.setMovieID(UUID.randomUUID().toString());
            m10.setTitle("A Whisker Away");
            m10.setRentalCost(100);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(m10);
            realm.commitTransaction();
        }
    }

    @Click(R.id.signInButton)
    public void clickSignIn() {

        String name = nameInput1.getText().toString();
        String pass = passwordInput1.getText().toString();
        boolean checked = checkBox.isChecked();
        long count = realm.where(Movie.class).count();

        User result = realm.where(User.class)
                .equalTo("name", name)
                .findFirst();

        if (result == null) {
            Toast t = Toast.makeText(this, "No User found", Toast.LENGTH_LONG);
            t.show();
        } else {
            if (result.getName().equals(name) && result.getPassword().equals(pass)) {

                SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("isBoxChecked", checked);
                edit.apply();

                String uuid = result.getUserID();
                edit.putString("uuid", uuid);
                edit.apply();
                HomePage_.intent(this).start();

            } else {
                Toast t = Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }

    @Click(R.id.registerButton)
    public void clickRegisterButton() {
        RegisterPage_.intent(this).start();
    }

    @Click(R.id.clearButton)
    public void clickClearButton() {

        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isBoxChecked", false);
        edit.putString("uuid", null);
        edit.apply();

        Toast t = Toast.makeText(this, "Preferences cleared", Toast.LENGTH_LONG);
        t.show();
    }

    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }
}