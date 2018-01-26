package isgbd.controller;

import isgbd.model.Transaction;
import isgbd.model.TransactionDao;
import isgbd.util.Utils;

/**
 * Created by Laura on 1/24/2018
 */

public class TransactionController {

    private TransactionDao transactionDao;
    private int currentTransactionId;
    private Utils utils;

    public TransactionController() {
        this.transactionDao = new TransactionDao();
    }

    public void insertTransaction(String details){
        Transaction t = new Transaction();
        t.setDetails(details);
        t.setIs_active(true);
        t.setTimestamp(utils.getCurrentTimeStamp());
        this.currentTransactionId = transactionDao.insertTransaction(t);
    }

    public void endTransaction(){
        System.out.println(this.currentTransactionId);
        transactionDao.endTransaction(this.currentTransactionId);
    }

    public int getCurrentTransactionId(){
        return currentTransactionId;
    }


}
