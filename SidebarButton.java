import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SidebarButton extends Button {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public SidebarButton() {
        // Mengatur layout dan ukuran sidebar
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 400)); // Set preferred size
        setMinimumSize(new Dimension(200, 400));   // Set minimum size
        setMaximumSize(new Dimension(200, 400));   // Set maximum size

        // Mengatur warna latar belakang sidebar
        setBackground(new Color(50, 50, 50)); // Warna abu-abu gelap

        add(Box.createRigidArea(new Dimension(0, 20))); // Spasi awal
        initializeButtons();
    }

    private void initializeButtons() {
        String[] buttonLabels = {"Character List 1", "Character List 2", "Character List 3", "Character List 4", "Character List 5", "Character List 6", "Character List 7", "Character List 8"};
        Color[] buttonColors = {Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY};

        for (int i = 0; i < buttonLabels.length; i++) {
            addButton(buttonLabels[i], buttonColors[i]);
        }
    }

    private void addButton(String text, Color color) {
        // Memanfaatkan fungsi createStyledButton dari class Button
        JButton btn = createStyledButton(text);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set uniform size for all buttons
        Dimension buttonSize = new Dimension(150, 40);
        btn.setPreferredSize(buttonSize);
        btn.setMinimumSize(buttonSize);
        btn.setMaximumSize(buttonSize);

        // Set button background color
        btn.setBackground(color);

        // Tambahkan ActionListener untuk mengubah tampilan halaman
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cardLayout != null && cardPanel != null) {
                    cardLayout.show(cardPanel, text); // Ubah tampilan berdasarkan nama tombol
                }
            }
        });

        add(btn);
        add(Box.createRigidArea(new Dimension(0, 10))); // Spasi antar tombol
    }

    public void setCardLayout(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
    }
}