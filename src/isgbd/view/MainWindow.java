package isgbd.view;

import isgbd.controller.FlowerController;
import isgbd.controller.FlowerVersionController;
import isgbd.controller.TransactionController;
import isgbd.model.Flower;
import isgbd.model.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by maria-roxana on 22.01.2018.
 */
public class MainWindow {

    private JFrame frame;

    private FlowerController flowerController;
    private TransactionController transactionController;
    private FlowerVersionController flowerVersionController;
    private JList<Flower> flowerList;
    private DefaultListModel<Flower> flowers;


    public MainWindow(FlowerController flowerController, TransactionController transactionController, FlowerVersionController flowerVersionController) {
        super();
        this.flowerController = flowerController;
        this.transactionController = transactionController;
        this.flowerVersionController = flowerVersionController;
        initialize();
    }

    public void start() {
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
        frame.setBackground(SystemColor.inactiveCaptionBorder);
        frame.setBounds(100, 100, 610, 334);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        initializeFlowerList();
    }

    private void initializeFlowerList() {

        DefaultListModel<Flower> flowersModel = new DefaultListModel<>();
        for (Flower flower : flowerController.listFlowers()) {
            flowersModel.addElement(flower);
        }

        flowerList = new JList<>(flowersModel);
        flowerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        flowerList.setVisibleRowCount(10);


        JScrollPane scrollPane = new JScrollPane(flowerList);
        scrollPane.setBounds(10, 55, 162, 201);

        frame.getContentPane().add(scrollPane);

        JLabel lblProducts = new JLabel("Flowers");
        lblProducts.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblProducts.setBounds(10, 11, 111, 33);
        frame.getContentPane().add(lblProducts);

        JButton startTransaction = new JButton("START TRANSACTION");
        startTransaction.setFont(new Font("Arial", Font.PLAIN, 14));
        startTransaction.setBounds(200, 70, 200, 23);
        frame.getContentPane().add(startTransaction);

          JButton readFlower = new JButton("Read Flower");
        readFlower.setFont(new Font("Arial", Font.PLAIN, 14));
        readFlower.setBounds(200, 110, 200, 23);
        frame.getContentPane().add(readFlower);

        JButton increaseBuds = new JButton("Increase buds number");
        increaseBuds.setFont(new Font("Arial", Font.PLAIN, 14));
        increaseBuds.setBounds(200, 150, 200, 23);
        frame.getContentPane().add(increaseBuds);

        JButton endTransaction = new JButton("End TRANSACTION");
        endTransaction.setFont(new Font("Arial", Font.PLAIN, 14));
        endTransaction.setBounds(200, 190, 200, 23);
        frame.getContentPane().add(endTransaction);

        startTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction t = new Transaction();
                t.setId(transactionController.getNextId());
                t.setIs_active(true);
                transactionController.updateTransactionsTable(t);
            }
        });

        endTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionController.endTransaction();
            }
        });

        increaseBuds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flowerList.isSelectionEmpty()) {
                    Flower selectedProduct = (Flower) flowerList.getSelectedValue();
                    flowerVersionController.updateFlowerVersion(selectedProduct);
                    System.out.print(selectedProduct);
                }
            }
        });


}

}
