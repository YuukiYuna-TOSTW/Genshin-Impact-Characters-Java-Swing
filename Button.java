import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;


class Button extends JPanel {
    protected Color bgColor = new Color(30, 30, 40);
    
    public Button() {
        setBackground(bgColor);
    }
    
    protected JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(50, 50, 70));
        btn.setFocusPainted(false); // Menghilangkan efek fokus
        btn.setBorderPainted(false); // Menghilangkan border tombol
        return btn;
    }
}