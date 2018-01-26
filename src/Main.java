import isgbd.controller.FlowerController;
import isgbd.controller.FlowerVersionController;
import isgbd.controller.TransactionController;
import isgbd.view.MainWindow;

public class Main {

    public static void main(String[] args) {
        FlowerController flowerController = new FlowerController();
        TransactionController transactionController = new TransactionController();
        FlowerVersionController flowerVersionController = new FlowerVersionController();
        MainWindow window= new MainWindow(flowerController, transactionController, flowerVersionController);
        window.start();
    }
}
