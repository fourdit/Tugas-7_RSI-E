package perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class PeminjamanController {
    private static List<String> daftarPinjaman = new ArrayList<>();

    public static boolean pinjam(String judul) {
        if (BukuProvider.pinjamBuku(judul)) {
            daftarPinjaman.add(judul);
            return true;
        }
        return false;
    }

    public static List<String> getDaftarPinjaman() {
        return new ArrayList<>(daftarPinjaman);
    }
}