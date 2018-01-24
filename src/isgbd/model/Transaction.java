package isgbd.model;

import java.sql.Timestamp;

/**
 * Created by user on 24.01.2018.
 */
public class Transaction {
    private int id;
    private String details;
    private Timestamp timestamp;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}