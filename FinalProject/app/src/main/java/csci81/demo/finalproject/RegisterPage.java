package csci81.demo.finalproject;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import csci81.demo.finalproject.realm.User;
import io.realm.Realm;

@EActivity(R.layout.activity_register_page)
public class RegisterPage extends AppCompatActivity {

    @ViewById
    EditText nameInput2, passwordInput2, cpwInput;

    @ViewById
    Button saveButton, cancelButton;

    Realm realm;

    @AfterViews
    public void init() {
        realm = Realm.getDefaultInstance();
    }

    @Click(R.id.saveButton)
    public void clickSaveButton() {
        String name = nameInput2.getText().toString();
        String pass = passwordInput2.getText().toString();
        String cPass = cpwInput.getText().toString();
        long count = 0;

        User result = realm.where(User.class)
                .equalTo("name", name)
                .findFirst();

        if (name.equals("")) {
            Toast t = Toast.makeText(this, "Name must not be blank", Toast.LENGTH_LONG);
            t.show();
        } else if (!pass.equals(cPass)) {
            Toast t = Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG);
            t.show();
        } else if (result != null) {
            Toast t = Toast.makeText(this, "User already exists", Toast.LENGTH_LONG);
            t.show();
        } else {
            User newUser = new User();
            newUser.setUserID(UUID.randomUUID().toString());
            newUser.setName(name);
            newUser.setPassword(pass);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newUser);  // save
            realm.commitTransaction();

            count = realm.where(User.class).count();

            Toast t = Toast.makeText(this, "New User saved. Total: " + count, Toast.LENGTH_LONG);
            t.show();

            finish();
        }
    }

    @Click(R.id.cancelButton)
    public void clickCancelButton() {
        finish();
    }

}

