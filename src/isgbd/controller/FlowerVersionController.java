package isgbd.controller;

import isgbd.model.Flower;
import isgbd.model.FlowerVersionDao;

/**
 * Created by Laura on 1/24/2018
 */

public class FlowerVersionController {

    private FlowerVersionDao flowerVersionDao;

    public FlowerVersionController() {
        this.flowerVersionDao = new FlowerVersionDao();
    }

    public void insertFlowerVersion(Flower flower){
        flowerVersionDao.insertFlowerVersions(flower);
    }
}
