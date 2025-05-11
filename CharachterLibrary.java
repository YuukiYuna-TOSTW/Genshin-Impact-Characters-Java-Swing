import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CharachterLibrary extends CardImage {
    private JPanel containerPanel; // Panel untuk menampung kumpulan CardImage
    private ArrayList<CardImage> cardImages;

    public CharachterLibrary() {
        super(); // Memanggil konstruktor CardImage
        cardImages = new ArrayList<>();
        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0, 4, 10, 10)); // Grid dengan 4 kolom, jarak antar elemen 10px
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding di sekitar panel
        containerPanel.setBackground(new Color(60, 60, 70)); // Warna abu-abu gelap dengan sedikit terang

        // Menambahkan containerPanel ke CharachterLibrary
        setLayout(new BorderLayout());
        add(containerPanel, BorderLayout.CENTER);
    }

    // Tambahkan parameter info karakter
    public void addCard(String imagePath, String imageName, String info) {
        CardImage card = new CardImage();
        Image image = new ImageIcon(imagePath).getImage();
        card.setImage(image, imageName);

        // Tambahkan MouseListener untuk pop up info karakter
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(card, info, imageName, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cardImages.add(card);
        containerPanel.add(card); // Menambahkan CardImage ke containerPanel
        revalidate(); // Memperbarui layout
        repaint(); // Meminta panel untuk menggambar ulang
    }
}
