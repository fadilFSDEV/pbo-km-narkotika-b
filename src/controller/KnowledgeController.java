package controller;

import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;

import java.util.ArrayList;

/**
 * Class KnowledgeController bertindak sebagai jembatan antara View dan Model.
 * Menerima input dari View, memprosesnya, memanggil metode di Model,
 * dan mengembalikan hasilnya ke View.
 */
public class KnowledgeController {
    private final KnowledgeRepository repository;

    /**
     * Constructor untuk KnowledgeController.
     * @param repository Instance dari KnowledgeRepository yang akan digunakan.
     */
    public KnowledgeController(KnowledgeRepository repository) {
        this.repository = repository;
    }

    /**
     * Memproses data mentah dari form input untuk menambah putusan baru.
     * @param data Array of String berisi data dari pengguna.
     * @return true jika berhasil, false jika terjadi error saat parsing.
     */
    public boolean tambahPutusan(String[] data) {
        try {
            // Data sudah divalidasi sebagai tipe yang benar oleh InputHandler di View
            String nomorPerkara = data[0];
            String pengadilan = data[1];
            String tanggalPutusan = data[2];
            String namaTerdakwa = data[3];
            int umurTerdakwa = Integer.parseInt(data[4]);
            String jenisNarkotika = data[5];
            double beratBarangBukti = Double.parseDouble(data[6]);
            String pasalDilanggar = data[7];
            String peranTerdakwa = data[8];
            int vonisHukuman = Integer.parseInt(data[9]);
            double vonisDenda = Double.parseDouble(data[10]);
            String namaHakim = data[11];

            Putusan p = new Putusan(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa, umurTerdakwa,
                                    jenisNarkotika, beratBarangBukti, pasalDilanggar, peranTerdakwa,
                                    vonisHukuman, vonisDenda, namaHakim);
            repository.simpan(p);
            return true;
        } catch (NumberFormatException e) {
            // Meskipun sudah divalidasi, ini sebagai pengaman tambahan
            System.err.println("[CONTROLLER ERROR] Gagal mem-parsing data angka: " + e.getMessage());
            return false;
        }
    }

    /**
     * Menghapus putusan berdasarkan nomor perkaranya.
     * @param nomorPerkara Nomor perkara yang akan dihapus.
     * @return true jika berhasil, false jika tidak ditemukan.
     */
    public boolean hapusPutusan(String nomorPerkara) {
        return repository.hapus(nomorPerkara);
    }

    /**
     * Mencari putusan berdasarkan nomor perkaranya.
     * @param nomorPerkara Nomor perkara yang dicari.
     * @return Objek Putusan jika ditemukan, jika tidak maka null.
     */
    public Putusan cariPutusanByNomor(String nomorPerkara) {
        return repository.cariByNomor(nomorPerkara);
    }

    /**
     * Mencari putusan berdasarkan nama terdakwa.
     * @param nama Kata kunci nama yang dicari.
     * @return ArrayList Putusan yang cocok.
     */
    public ArrayList<Putusan> cariPutusanByNama(String nama) {
        return repository.cariByNama(nama);
    }

    /**
     * Memfilter putusan berdasarkan jenis narkotika.
     * @param jenis Jenis narkotika yang dicari.
     * @return ArrayList Putusan yang cocok.
     */
    public ArrayList<Putusan> filterByJenisNarkotika(String jenis) {
        return repository.filterByJenis(jenis);
    }

    /**
     * Mengambil semua data putusan dari repository.
     * @return ArrayList berisi semua Putusan.
     */
    public ArrayList<Putusan> getSemuaPutusan() {
        return repository.getDaftarSemua();
    }

    /**
     * Membuat dan mengembalikan objek statistik dari data saat ini.
     * @return Objek StatistikPutusan.
     */
    public StatistikPutusan getStatistik() {
        return new StatistikPutusan(repository.getDaftarSemua());
    }
}
