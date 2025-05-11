import javax.swing.*;

public class MainContentPanels {
    public JPanel getHomePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Home Panel"));
        return panel;
    }
    public JScrollPane getCharacterScrollPane() {
        // Inisialisasi daftar karakter asli
        CharachterList1 charList = new CharachterList1();
        CharachterLibrary library = charList.getLibrary();
        return new JScrollPane(library);
    }
    public JPanel getTierListPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Tier List Panel"));
        return panel;
    }
}
