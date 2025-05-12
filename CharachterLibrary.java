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
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        card.setImage(image, imageName);

        // Tambahkan MouseListener untuk pop up info karakter dengan gambar
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Panel custom untuk pop up
                JPanel panel = new JPanel(new BorderLayout(10, 10));
                JLabel imgLabel = new JLabel();
                imgLabel.setIcon(new ImageIcon(image.getScaledInstance(120, 180, Image.SCALE_SMOOTH)));
                JLabel infoLabel = new JLabel("<html><body style='width:200px'>" + info + "</body></html>");
                infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                panel.add(imgLabel, BorderLayout.WEST);
                panel.add(infoLabel, BorderLayout.CENTER);

                JOptionPane.showMessageDialog(card, panel, imageName, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cardImages.add(card);
        containerPanel.add(card); // Menambahkan CardImage ke containerPanel
        revalidate(); // Memperbarui layout
        repaint(); // Meminta panel untuk menggambar ulang
    }
}
