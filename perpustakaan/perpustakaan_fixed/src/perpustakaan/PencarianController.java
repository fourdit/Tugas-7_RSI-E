package perpustakaan;

import java.util.ArrayList;
import java.util.List;

public class PencarianController {
    public List<Buku> cariBuku(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            return new ArrayList<Buku>();
        }
        return BukuProvider.cariByJudul(judul);
    }
}
