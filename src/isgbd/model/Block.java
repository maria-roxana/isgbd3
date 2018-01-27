package isgbd.model;

/**
 * Created by maria-roxana on 27.01.2018.
 */
public class Block {
    private int id;
    private int flowerId;
    private int transactionId;
    private String type;

    public Block(int id, int flowerId, int transactionId, String type) {
        this.id = id;
        this.flowerId = flowerId;
        this.transactionId = transactionId;
        this.type = type;
    }

    public Block(int flowerId, int transactionId, String type) {
        this.flowerId = flowerId;
        this.transactionId = transactionId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
