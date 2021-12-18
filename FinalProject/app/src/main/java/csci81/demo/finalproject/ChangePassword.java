package csci81.demo.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import csci81.demo.finalproject.realm.User;
import io.realm.Realm;

@EActivity(R.layout.activity_change_password)
public class ChangePassword extends AppCompatActivity {

    Realm realm;

    @ViewById
    TextView changePassUser, changePassPass, changeConfirmPass;

    @ViewById
    Button changePassSave, changePassCancel;


    @AfterViews
    public void init(){
        realm = Realm.getDefaultInstance();

        SharedPreferences sp = getSharedPreferences( "MyPrefs",MODE_PRIVATE);
        String uuid = sp.getString("uuid", null);

        //set user
        User user = realm.where(User.class)
                .equalTo( "userID", uuid)
                .findFirst();

        //fill in EditText with existing user data
        changePassUser.setText(user.getName());
        changePassPass.setText(user.getPassword());
        changeConfirmPass.setText(user.getPassword());
    }

    @Click(R.id.changePassSave)
    public void changePassSave() {
        SharedPreferences sp = getSharedPreferences( "MyPrefs",MODE_PRIVATE);
        String uuid = sp.getString("uuid", null);

        //set user
        User user = realm.where(User.class)
                .equalTo( "userID", uuid)
                .findFirst();
//
        String username = changePassUser.getText().toString();
        String password = changePassPass.getText().toString();
        String confPass = changeConfirmPass.getText().toString();

        if (username.equals("")){
            Toast t = Toast.makeText(this, "Name must not be blank", Toast.LENGTH_LONG);
            t.show();
        }else{
            //Check if user exists
            User result = realm.where(User.class)
                    .equalTo("name", username)
                    .findFirst();

            if (result != null && !username.equals(user.getName())) {
                Toast t = Toast.makeText(this, "User already exists", Toast.LENGTH_LONG);
                t.show();
            } else if (password.equals("") || confPass.equals("")) {
                Toast t = Toast.makeText(this, "Password must not be blank", Toast.LENGTH_LONG);
                t.show();
            } else if (!password.equals(confPass)) {
                Toast t = Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG);
                t.show();
            } else {

                //save edits
                realm.beginTransaction();
                user.setName(username);
                user.setPassword(password);
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();

                Toast t = Toast.makeText(this, "Changes saved", Toast.LENGTH_LONG);
                t.show();

                finish();
            }
        }
    }

    @Click(R.id.changePassCancel)
    public void ChangePassCancel() {
            finish();
    }


    public void onDestroy() {
        super.onDestroy();
        if (!realm.isClosed()) {
            realm.close();
        }
    }
}