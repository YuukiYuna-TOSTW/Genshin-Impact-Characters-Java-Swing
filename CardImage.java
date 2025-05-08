import javax.swing.*;
import java.awt.*;

public class CardImage extends JPanel {
    private Image image;
    private String imageName;
    private int imageWidth = 90; // Default lebar gambar
    private int imageHeight = 140; // Default tinggi gambar

    // Ukuran tetap untuk kotak pembungkus (persegi)
    private static final int BOX_SIZE = 150; // Ukuran sisi kotak (panjang = lebar)
    private static final int IMAGE_PADDING = 10; // Padding di sekitar gambar
    private static final int TEXT_HEIGHT = 25; // Tinggi area untuk teks di bawah gambar

    public CardImage() {
        // Mengatur ukuran tetap untuk CardImage
        setPreferredSize(new Dimension(BOX_SIZE, BOX_SIZE + TEXT_HEIGHT));
        setMinimumSize(new Dimension(BOX_SIZE, BOX_SIZE + TEXT_HEIGHT));
        setMaximumSize(new Dimension(BOX_SIZE, BOX_SIZE + TEXT_HEIGHT));
        setLayout(null); // Menonaktifkan layout manager agar ukuran tetap

        // Mengatur warna latar belakang kotak menjadi putih
        setBackground(Color.WHITE);
    }

    public void setImage(Image image, String imageName) {
        this.image = image;
        this.imageName = imageName;
        repaint();
    }

    public void setImageSize(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gambar latar belakang untuk kotak
        g.setColor(getBackground()); // Menggunakan warna latar belakang yang diatur (putih)
        g.fillRect(0, 0, getWidth(), getHeight());

        if (image != null) {
            // Gambar gambar dengan ukuran yang ditentukan
            int x = (getWidth() - imageWidth) / 2; // Pusatkan gambar secara horizontal
            int y = IMAGE_PADDING; // Margin atas
            g.drawImage(image, x, y, imageWidth, imageHeight, this);
        }

        if (imageName != null) {
            // Gambar nama gambar di bawah gambar
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(imageName);
            int x = (getWidth() - textWidth) / 2;
            int y = BOX_SIZE + (TEXT_HEIGHT - fm.getHeight()) / 2 + fm.getAscent(); // Pusatkan teks di area teks
            g.drawString(imageName, x, y);
        }
    }
}