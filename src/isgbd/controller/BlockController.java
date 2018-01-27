package isgbd.controller;

import isgbd.model.Block;
import isgbd.model.BlockDao;
import isgbd.util.BlockType;

/**
 * Created by maria-roxana on 27.01.2018.
 */
public class BlockController {
    private BlockDao blockDao;

    public BlockController() {
        this.blockDao = new BlockDao();
    }

    public int addBlock(final int flowerId, final int transactionId,
                        final BlockType type) {
        return blockDao.addBlock(new Block(flowerId, transactionId, type.getValue()));
    }
}
