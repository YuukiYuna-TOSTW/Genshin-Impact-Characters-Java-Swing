import javax.swing.*;
import java.awt.*;

public class ContenButton {
    private JPanel panelKananBawah;
    private CardLayout cardLayout;

    public ContenButton() {
        // Inisialisasi CardLayout dan panel utama
        cardLayout = new CardLayout();
        panelKananBawah = new JPanel(cardLayout);

        // Membuat konten untuk setiap tombol
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.WHITE);
        homePanel.add(new JLabel("Home Content"));

        CharachterList1 charachterList = new CharachterList1();
        JScrollPane characterScrollPane = new JScrollPane(charachterList.getLibrary());

        JPanel tierListPanel = new JPanel();
        tierListPanel.setBackground(Color.CYAN);
        tierListPanel.add(new JLabel("Tier List Content"));

        // Tambahkan panel ke CardLayout
        panelKananBawah.add(homePanel, "Home");
        panelKananBawah.add(characterScrollPane, "Characters");
        panelKananBawah.add(tierListPanel, "TierList");
    }

    public JPanel getPanel() {
        return panelKananBawah;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}