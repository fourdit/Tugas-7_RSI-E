package perpustakaan;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormLihatPeminjaman extends JFrame {
    private DefaultListModel<String> modelList;

    public FormLihatPeminjaman() {
        setTitle("Daftar Buku yang Sedang Dipinjam");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

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
        List<String> daftar = PeminjamanController.getDaftarPinjaman();
        if (daftar.isEmpty()) {
            modelList.addElement("Belum ada buku yang dipinjam.");
        } else {
            for (String judul : daftar) {
                modelList.addElement(judul);
            }
        }
    }
}
