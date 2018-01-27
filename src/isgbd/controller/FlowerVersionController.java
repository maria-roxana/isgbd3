package isgbd.controller;

import isgbd.model.FlowerVersion;
import isgbd.model.FlowerVersionDao;

/**
 * Created by Laura on 1/24/2018
 */

public class FlowerVersionController {

    private FlowerVersionDao flowerVersionDao;

    public FlowerVersionController() {
        this.flowerVersionDao = new FlowerVersionDao();
    }

    public void insertFlowerVersion(int id, long buds, int blockId) {
        FlowerVersion flowerVersion = new FlowerVersion();
        flowerVersion.setBuds(buds);
        flowerVersion.setFlowerId(id);
        flowerVersion.setBlockId(blockId);
        flowerVersionDao.insertFlowerVersions(flowerVersion);
    }


}
