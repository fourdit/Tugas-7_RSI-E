package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FormJatuhTempo extends JFrame {
    private DefaultTableModel model;
    private JTable table;

    // Data simulasi: tanggal peminjaman
    private static Map<String, LocalDate> tanggalPinjam = new HashMap<>();

    public FormJatuhTempo() {
        setTitle("Daftar Buku Jatuh Tempo");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Kolom tabel
        String[] kolom = {"Judul Buku", "Tanggal Pinjam", "Status"};
        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        // Tombol kembali
        JButton btnKembali = new JButton("Kembali ke Menu");
        btnKembali.addActionListener(e -> {
            dispose();
            new HalamanUtamaUI().setVisible(true);
        });

        add(scroll, BorderLayout.CENTER);
        add(btnKembali, BorderLayout.SOUTH);

        muatDataJatuhTempo();
    }

    // Simulasikan beberapa tanggal pinjam agar bisa muncul di tabel
    public static void catatPeminjaman(String judul) {
        tanggalPinjam.put(judul, LocalDate.now());
    }

    private void muatDataJatuhTempo() {
        model.setRowCount(0);
        LocalDate hariIni = LocalDate.now();

        if (tanggalPinjam.isEmpty()) {
            model.addRow(new Object[]{"-", "-", "Belum ada data pinjaman"});
            return;
        }

        for (Map.Entry<String, LocalDate> entry : tanggalPinjam.entrySet()) {
            String judul = entry.getKey();
            LocalDate tglPinjam = entry.getValue();
            long selisih = java.time.temporal.ChronoUnit.DAYS.between(tglPinjam, hariIni);

            String status = selisih > 7 ? "Jatuh Tempo (" + selisih + " hari)" : "Masih dalam batas";
            model.addRow(new Object[]{judul, tglPinjam.toString(), status});
        }
    }
}