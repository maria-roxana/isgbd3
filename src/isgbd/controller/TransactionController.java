package isgbd.controller;

import isgbd.model.Transaction;
import isgbd.model.TransactionDao;

/**
 * Created by Laura on 1/24/2018
 */

public class TransactionController {

    private TransactionDao transactionDao;
    private int currentTransactionId;

    public TransactionController() {
        this.transactionDao = new TransactionDao();
    }

    public void updateTransactionsTable(Transaction transaction){
        this.currentTransactionId = transaction.getId();
        transactionDao.updateTransactionsTable(transaction);
    }

    public int getNextId(){
        return transactionDao.getNextId();
    }

    public void endTransaction(){
        transactionDao.endTransaction(currentTransactionId);
    }
}
