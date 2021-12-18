package csci81.demo.finalproject.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Rental extends RealmObject {

    @PrimaryKey
    private String rentalID;

    private String transactionID; //FK
    private String userID; //FK
    private String movieID; //FK

    private String status;
    private String rentalDate;
    private String returnDate;
    private int quantity;

    public Rental() {
    }

    public Rental(String rentalID, String userID, String movieID, String rentalDate, String returnDate, int quantity) {
        this.rentalID = rentalID;
        this.userID = userID;
        this.movieID = movieID;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.quantity = quantity;
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID='" + rentalID + '\'' +
                ", userID='" + userID + '\'' +
                ", movieID='" + movieID + '\'' +
                ", rentalDate='" + rentalDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
