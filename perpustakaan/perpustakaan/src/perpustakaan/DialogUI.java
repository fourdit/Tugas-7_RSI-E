package perpustakaan;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DialogUI {
    public static void showMessage(final String pesan) {
        // Pastikan dijalankan di EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, pesan);
            }
        });
    }

    // Instance-based convenience (tidak wajib)
    public DialogUI(String pesan) {
        showMessage(pesan);
    }
}
