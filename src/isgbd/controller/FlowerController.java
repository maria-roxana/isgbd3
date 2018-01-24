package isgbd.controller;

import isgbd.model.Flower;
import isgbd.model.FlowerDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.01.2018.
 */
public class FlowerController {
    private FlowerDao flowerDao;

    public FlowerController() {
        flowerDao=new FlowerDao();
    }

    public List<Flower> listFlowers(){
        return flowerDao.getFlowers();
    }
}