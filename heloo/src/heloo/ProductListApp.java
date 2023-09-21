package heloo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductListApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

            JScrollPane scrollPane = new JScrollPane(contentPane);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JButton addButton = new JButton("Add Product");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addProduct(contentPane);
                }
            });

            frame.add(addButton, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private static void addProduct(JPanel contentPane) {
        JPanel productPanel = new JPanel();
        productPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 예시 이미지 아이콘
        ImageIcon imageIcon = new ImageIcon("C:/Users/whrnj/OneDrive/바탕 화면/KakaoTalk_20210111_214454422.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        productPanel.add(imageLabel);

        JLabel nameLabel = new JLabel("Product Name");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        productPanel.add(nameLabel);

        JLabel priceLabel = new JLabel("$99.99");
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        productPanel.add(priceLabel);

        contentPane.add(productPanel);

        // 패널을 새로 추가했으므로 화면을 다시 그리도록 요청
        contentPane.revalidate();
    }
}
