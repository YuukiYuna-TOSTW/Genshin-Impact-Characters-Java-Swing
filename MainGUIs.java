import javax.swing.*;
import java.awt.*;

public class MainGUIs extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelKananBawah;

    public MainGUIs() {
        // Konfigurasi JFrame
        setTitle("Genshin Impact Characters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 850);

        // Panel kiri atas
        JPanel panelKiriAtas = new JPanel();
        panelKiriAtas.setLayout(new BoxLayout(panelKiriAtas, BoxLayout.Y_AXIS));
        panelKiriAtas.setBorder(BorderFactory.createEmptyBorder(13, 10, 10, 10));
        panelKiriAtas.setBackground(new Color(34, 32, 33));

        JLabel label = new JLabel("Genshin Impact Characters List");
        label.setForeground(Color.WHITE);
        panelKiriAtas.add(label);

        // Panel kanan atas
        JPanel panelKananAtas = new JPanel();
        panelKananAtas.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelKananAtas.setBackground(new Color(34, 32, 33));

        // Membuat instance Button untuk menggunakan fungsi createStyledButton
        Button buttonHelper = new Button();

        // Kotak pertama (Join Discord)
        JButton kotak1 = buttonHelper.createStyledButton("Join Discord");
        kotak1.setBackground(new Color(40, 40, 255));
        panelKananAtas.add(kotak1);

        // Kotak kedua (Buy us a Ko-Fi)
        JButton kotak2 = buttonHelper.createStyledButton("Buy us a Ko-Fi");
        kotak2.setBackground(new Color(255, 40, 40));
        panelKananAtas.add(kotak2);

        // Panel kiri bawah
        JPanel panelKiriBawah = new JPanel();
        panelKiriBawah.setLayout(new BorderLayout());

        // Menambahkan sidebar agar mengisi seluruh bagian panel kiri bawah
        SidebarButton sidebar = new SidebarButton();
        panelKiriBawah.add(sidebar, BorderLayout.CENTER);

        // Panel kanan bawah dengan CardLayout
        panelKananBawah = new JPanel();
        cardLayout = new CardLayout();
        panelKananBawah.setLayout(cardLayout);

        // Memuat konten panel dari file terpisah
        MainContentPanels contentPanels = new MainContentPanels();

        // Tambahkan panel daftar karakter dari CharachterList
        CharachterList1 charList1 = new CharachterList1();
        CharachterLibrary library1 = charList1.getLibrary();
        panelKananBawah.add(new JScrollPane(library1), "Character List 1");

        CharachterList2 charList2 = new CharachterList2();
        CharachterLibrary library2 = charList2.getLibrary();
        panelKananBawah.add(new JScrollPane(library2), "Character List 2");

        CharachterList3 charList3 = new CharachterList3();
        CharachterLibrary library3 = charList3.getLibrary();
        panelKananBawah.add(new JScrollPane(library3), "Character List 3");

        CharachterList4 charList4 = new CharachterList4();
        CharachterLibrary library4 = charList4.getLibrary();
        panelKananBawah.add(new JScrollPane(library4), "Character List 4");

        CharachterList5 charList5 = new CharachterList5();
        CharachterLibrary library5 = charList5.getLibrary();
        panelKananBawah.add(new JScrollPane(library5), "Character List 5");

        CharachterList6 charList6 = new CharachterList6();
        CharachterLibrary library6 = charList6.getLibrary();
        panelKananBawah.add(new JScrollPane(library6), "Character List 6");

        CharachterList7 charList7 = new CharachterList7();
        CharachterLibrary library7 = charList7.getLibrary();
        panelKananBawah.add(new JScrollPane(library7), "Character List 7");

        CharachterList8 charList8 = new CharachterList8();
        CharachterLibrary library8 = charList8.getLibrary();
        panelKananBawah.add(new JScrollPane(library8), "Character List 8");

        // Tambahkan panel lain ke CardLayout
        panelKananBawah.add(contentPanels.getHomePanel(), "Home");
        panelKananBawah.add(contentPanels.getCharacterScrollPane(), "Characters");
        panelKananBawah.add(contentPanels.getTierListPanel(), "TierList");

        // Membuat JSplitPane untuk panel bawah (kiri dan kanan)
        JSplitPane splitPaneBawah = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelKiriBawah, panelKananBawah);
        splitPaneBawah.setDividerLocation(200); // Sidebar memiliki lebar tetap 200px
        splitPaneBawah.setResizeWeight(0); // Sidebar tidak berubah ukurannya
        splitPaneBawah.setDividerSize(0);

        // Membuat JSplitPane untuk panel atas (kiri dan kanan)
        JSplitPane panelAtas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelKiriAtas, panelKananAtas);
        panelAtas.setDividerLocation(400);
        panelAtas.setResizeWeight(0.5); // Kedua panel atas berbagi ukuran secara proporsional
        panelAtas.setDividerSize(0);

        // Membuat JSplitPane utama (atas dan bawah)
        JSplitPane splitPaneUtama = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelAtas, splitPaneBawah);
        splitPaneUtama.setDividerLocation(50); // Panel atas lebih kecil dari panel bawah
        splitPaneUtama.setResizeWeight(0); // Panel atas mengambil 20% dari tinggi
        splitPaneUtama.setDividerSize(0);

        // Hubungkan SidebarButton dengan CardLayout dan panel
        sidebar.setCardLayout(cardLayout, panelKananBawah);

        add(splitPaneUtama);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUIs mainGUIs = new MainGUIs();
            mainGUIs.setVisible(true);
        });
    }
}
