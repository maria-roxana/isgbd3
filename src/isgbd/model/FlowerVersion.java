package isgbd.model;

/**
 * Created by maria-roxana on 24.01.2018.
 */
public class FlowerVersion {

    private Long id;
    private int flowerId;
    private Long buds;
    private int blockId;

    public FlowerVersion() {
    }

    public FlowerVersion(Long id, int flowerId, Long buds) {
        this.id = id;
        this.flowerId = flowerId;
        this.buds = buds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public Long getBuds() {
        return buds;
    }

    public void setBuds(Long buds) {
        this.buds = buds;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

}

