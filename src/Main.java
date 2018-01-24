import isgbd.controller.FlowerController;
import isgbd.view.MainWindow;

public class Main {

    public static void main(String[] args) {
        FlowerController flowerController = new FlowerController();
        MainWindow window= new MainWindow(flowerController);
        window.start();
    }
}
