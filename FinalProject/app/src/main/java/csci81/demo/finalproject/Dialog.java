package csci81.demo.finalproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import csci81.demo.finalproject.realm.Rental;
import io.realm.Realm;

public class Dialog extends AppCompatDialogFragment {
    private Rental rental;
    private ManageTransactionsActivity activity;
    private String dialogTitle;
    private Realm realm;

    public Dialog (String dialogTitle) {
        this.dialogTitle = dialogTitle;
        this.realm = Realm.getDefaultInstance();
    }

    public Dialog(Rental rental, ManageTransactionsActivity activity, String dialogTitle) {
        this.rental = rental;
        this.activity = activity;
        this.dialogTitle = dialogTitle;
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        builder.setView(view).setTitle(dialogTitle).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (rental != null) {
                    activity.delete(rental);
                } else {
                    realm.beginTransaction();
                    realm.deleteAll();
                    realm.commitTransaction();
                    realm.close();
                }
            }
        });

        return builder.create();
    }
}
