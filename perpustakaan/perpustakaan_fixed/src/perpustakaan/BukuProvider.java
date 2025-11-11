package perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class BukuProvider {
    private static List<Buku> koleksi = new ArrayList<>();

    static {
        // Data contoh
        koleksi.add(new Buku("Sherlock Holmes"));
        koleksi.add(new Buku("Topeng Kaca"));
        koleksi.add(new Buku("Doraemon"));
        koleksi.add(new Buku("Petualangan Doraemon"));
        koleksi.add(new Buku("Thomas and Friends"));
        koleksi.add(new Buku("The Return of Sherlock Holmes"));
        koleksi.add(new Buku("The Adventure of Sherlock Holmes"));
    }

    public static List<Buku> getAll() {
        return new ArrayList<>(koleksi);
    }

    public static List<Buku> cariByJudul(String query) {
        List<Buku> hasil = new ArrayList<>();
        if (query == null || query.isEmpty()) {
            return getAll();
        }
        String q = query.toLowerCase();
        for (Buku b : koleksi) {
            if (b.judul.toLowerCase().contains(q)) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    public static boolean pinjamBuku(String judul) {
        for (Buku b : koleksi) {
            if (b.judul.equalsIgnoreCase(judul)) {
                if (b.dipinjam) return false; // sudah dipinjam
                b.dipinjam = true;
                return true;
            }
        }
        return false;
    }
}
