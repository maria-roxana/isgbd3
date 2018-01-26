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
        frame.setBounds(100, 100, 700, 334);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        initializeFlowerList();
    }

    private void initializeFlowerList() {

        Label detailsLabel = new Label("Details: ");
        detailsLabel.setBounds(20, 70, 50, 23);
        frame.getContentPane().add(detailsLabel);

        TextField details = new TextField();
        details.setBounds(75, 70, 150, 23);
        frame.getContentPane().add(details);

        JButton startTransaction = new JButton("START TRANSACTION");
        startTransaction.setFont(new Font("Arial", Font.PLAIN, 14));
        startTransaction.setBounds(235, 70, 200, 23);
        frame.getContentPane().add(startTransaction);

        Label idLabel1 = new Label("Id: ");
        idLabel1.setBounds(20, 110, 50, 23);
        frame.getContentPane().add(idLabel1);

        TextField readId = new TextField();
        readId.setBounds(75, 110, 50, 23);
        frame.getContentPane().add(readId);

        JButton readFlower = new JButton("Read Flower");
        readFlower.setFont(new Font("Arial", Font.PLAIN, 14));
        readFlower.setBounds(235, 110, 200, 23);
        frame.getContentPane().add(readFlower);

        TextField readOutput = new TextField();
        readOutput.setBounds(450, 110, 150, 23);
        readOutput.setEnabled(false);
        frame.getContentPane().add(readOutput);

        Label labelId2 = new Label("Id: ");
        labelId2.setBounds(20, 150, 50, 23);
        frame.getContentPane().add(labelId2);

        TextField updateId = new TextField();
        updateId.setBounds(75, 150, 50, 23);
        frame.getContentPane().add(updateId);

        Label l3 = new Label("Buds: ");
        l3.setBounds(130, 150, 50, 23);
        frame.getContentPane().add(l3);

        TextField budsNumber = new TextField();
        budsNumber.setBounds(180, 150, 50, 23);
        frame.getContentPane().add(budsNumber);

        JButton increaseBuds = new JButton("Increase buds number");
        increaseBuds.setFont(new Font("Arial", Font.PLAIN, 14));
        increaseBuds.setBounds(235, 150, 200, 23);
        frame.getContentPane().add(increaseBuds);

        JButton endTransaction = new JButton("End TRANSACTION");
        endTransaction.setFont(new Font("Arial", Font.PLAIN, 14));
        endTransaction.setBounds(235, 190, 200, 23);
        frame.getContentPane().add(endTransaction);

        startTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transactionDetails = details.getText();
                transactionController.insertTransaction(transactionDetails);
                details.setText("");
            }
        });

        readFlower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long id = Integer.parseInt(readId.getText());
                Flower flower = flowerController.readFlower(id);
                readOutput.setText(flower.toString());
                readId.setText("");

            }
        });

        increaseBuds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(updateId.getText());
                long buds = Integer.parseInt(budsNumber.getText());
                int transactionId = transactionController.getCurrentTransactionId();
                flowerVersionController.insertFlowerVersion(id, buds, transactionId);
                updateId.setText("");
                budsNumber.setText("");
            }
        });


        endTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionController.endTransaction();
            }
        });
    }
}
