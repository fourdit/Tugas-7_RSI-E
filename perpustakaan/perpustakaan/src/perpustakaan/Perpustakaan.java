package perpustakaan;

import javax.swing.SwingUtilities;

public class Perpustakaan {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HalamanUtamaUI().setVisible(true);
        });
    }
}
