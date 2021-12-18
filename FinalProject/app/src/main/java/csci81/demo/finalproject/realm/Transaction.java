package csci81.demo.finalproject.realm;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Transaction extends RealmObject {

    @PrimaryKey
    private String transactionID;

    private String rentalID;
    private String userID;
    private int amount;
    private String transactionDate;

    public Transaction() {
    }

    public Transaction(String transactionID, String rentalID, String userID, int amount, String transactionDate) {
        this.transactionID = transactionID;
        this.rentalID = rentalID;
        this.userID = userID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", rentalID='" + rentalID + '\'' +
                ", userID='" + userID + '\'' +
                ", amount=" + amount +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}

