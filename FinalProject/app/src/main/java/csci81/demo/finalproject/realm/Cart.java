package csci81.demo.finalproject.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Cart extends RealmObject {

    @PrimaryKey
    private String cartID;

    private String rentalID;
    private String userID;
    private String transactionDate;

    public Cart() {

    }

    public Cart(String cartID, String rentalID, String userID, String transactionDate) {
        this.cartID = cartID;
        this.rentalID = rentalID;
        this.userID = userID;
        this.transactionDate = transactionDate;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
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

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID='" + cartID + '\'' +
                ", rentalID='" + rentalID + '\'' +
                ", userID='" + userID + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
