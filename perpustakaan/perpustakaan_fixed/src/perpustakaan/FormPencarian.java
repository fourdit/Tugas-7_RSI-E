package perpustakaan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class FormPencarian extends JFrame {
    private JTextField txtCari;
    private JButton btnCari, btnPinjam, btnKembali;
    private JTable tblHasil;
    private DefaultTableModel model;

    public FormPencarian() {
        setTitle("Pencarian & Peminjaman Buku");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelAtas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAtas.add(new JLabel("Cari Judul Buku:"));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        panelAtas.add(txtCari);
        panelAtas.add(btnCari);

        String[] kolom = {"Judul Buku"};
        model = new DefaultTableModel(kolom, 0);
        tblHasil = new JTable(model);
        JScrollPane scroll = new JScrollPane(tblHasil);

        JPanel panelBawah = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPinjam = new JButton("Pinjam Buku");
        btnKembali = new JButton("Kembali");
        panelBawah.add(btnPinjam);
        panelBawah.add(btnKembali);

        add(panelAtas, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        btnCari.addActionListener(e -> cariBuku());
        txtCari.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                cariBuku();
            }
        });

        btnPinjam.addActionListener(e -> pinjamBuku());
        btnKembali.addActionListener(e -> {
            dispose();
            new HalamanUtamaUI().setVisible(true);
        });

        tampilkanSemuaBuku();
    }

    private void cariBuku() {
        String query = txtCari.getText().trim();
        List<Buku> hasil = BukuProvider.cariByJudul(query);
        refreshTable(hasil);
    }

    private void tampilkanSemuaBuku() {
        List<Buku> semua = BukuProvider.getAll();
        refreshTable(semua);
    }

    private void refreshTable(List<Buku> list) {
        model.setRowCount(0);
        for (Buku b : list) {
            model.addRow(new Object[]{b.judul});
        }
    }

    private void pinjamBuku() {
        int row = tblHasil.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih buku terlebih dahulu!");
            return;
        }
        String judul = (String) model.getValueAt(row, 0);
        boolean sukses = PeminjamanController.pinjam(judul);

        if (sukses) {
            JOptionPane.showMessageDialog(this, "Buku \"" + judul + "\" berhasil dipinjam!");
        } else {
            JOptionPane.showMessageDialog(this, "Buku \"" + judul + "\" sudah dipinjam atau tidak tersedia.");
        }
    }
}