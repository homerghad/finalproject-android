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

    }

    @Click(R.id.signInButton)
    public void clickSignIn() {

        String name = nameInput1.getText().toString();
        String pass = passwordInput1.getText().toString();
        boolean checked = checkBox.isChecked();

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
                //WelcomeScreen_.intent(this).start();

                //temporary code for testing account page. replace with homepage.
                AccountPage_.intent(this).start();

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