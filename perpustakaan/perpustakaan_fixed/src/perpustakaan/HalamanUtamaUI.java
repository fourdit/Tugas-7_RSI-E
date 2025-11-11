package perpustakaan;

import javax.swing.*;
import java.awt.*;

public class HalamanUtamaUI extends JFrame {
    public HalamanUtamaUI() {
        setTitle("Aplikasi Perpustakaan");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnCari = new JButton("Cari Buku");
        JButton btnPinjam = new JButton("Lihat Peminjaman");
        JButton btnKeluar = new JButton("Keluar");

        btnCari.addActionListener(e -> {
            dispose();
            new FormPencarian().setVisible(true);
        });

        btnPinjam.addActionListener(e -> {
            dispose();
            new FormPeminjaman().setVisible(true);
        });

        btnKeluar.addActionListener(e -> System.exit(0));

        add(btnCari);
        add(btnPinjam);
        add(btnKeluar);
    }
}