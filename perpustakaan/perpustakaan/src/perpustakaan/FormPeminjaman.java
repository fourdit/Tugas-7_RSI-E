package perpustakaan;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormPeminjaman extends JFrame {
    private JTable tabel;
    private DefaultListModel<String> modelList;

    public FormPeminjaman() {
        setTitle("Daftar Buku yang Dipinjam");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modelList = new DefaultListModel<>();
        JList<String> list = new JList<>(modelList);
        JScrollPane scroll = new JScrollPane(list);

        JButton btnKembali = new JButton("Kembali ke Menu");
        btnKembali.addActionListener(e -> {
            dispose();
            new HalamanUtamaUI().setVisible(true);
        });

        add(scroll, BorderLayout.CENTER);
        add(btnKembali, BorderLayout.SOUTH);

        tampilkanPinjaman();
    }

    private void tampilkanPinjaman() {
        modelList.clear();
        List<String> pinjaman = PeminjamanController.getDaftarPinjaman();
        if (pinjaman.isEmpty()) {
            modelList.addElement("Belum ada buku yang dipinjam.");
        } else {
            for (String judul : pinjaman) {
                modelList.addElement(judul);
            }
        }
    }
}