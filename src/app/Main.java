package app;

import controller.KnowledgeController;
import model.KnowledgeRepository;
import model.Putusan;
import model.StatistikPutusan;
import view.ConsoleView;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point utama dari aplikasi Knowledge Management System.
 * Bertanggung jawab untuk inisialisasi komponen MVC dan menjalankan loop menu utama.
 */
public class Main {
    public static void main(String[] args) {
        // Inisialisasi komponen MVC
        KnowledgeRepository repository = new KnowledgeRepository();
        KnowledgeController controller = new KnowledgeController(repository);
        ConsoleView view = new ConsoleView();
        Scanner scanner = new Scanner(System.in);

        view.tampilkanPesan("Selamat datang! " + repository.getTotalData() + " data putusan berhasil dimuat.");

        // Loop menu utama
        while (true) {
            int pilihan = view.tampilkanMenu(scanner);
            switch (pilihan) {
                case 1:
                    // Tampilkan Semua Putusan
                    view.tampilkanDaftarPutusan(controller.getSemuaPutusan());
                    break;
                case 2:
                    // Tambah Putusan Baru
                    String[] data = view.inputFormPutusan(scanner);
                    boolean suksesTambah = controller.tambahPutusan(data);
                    if (suksesTambah) {
                        view.tampilkanPesan("Putusan baru berhasil ditambahkan.");
                    } else {
                        view.tampilkanPesan("Gagal menambahkan putusan. Periksa kembali format angka yang Anda masukkan.");
                    }
                    break;
                case 3:
                    // Cari & Filter Putusan
                    handleSearchAndFilter(scanner, view, controller);
                    break;
                case 4:
                    // Hapus Putusan
                    String nomorHapus = InputHandler.validasiString("Masukkan Nomor Perkara yang akan dihapus: ", scanner);
                    boolean suksesHapus = controller.hapusPutusan(nomorHapus);
                    if (suksesHapus) {
                        view.tampilkanPesan("Putusan dengan nomor " + nomorHapus + " berhasil dihapus.");
                    } else {
                        view.tampilkanPesan("Gagal menghapus. Putusan dengan nomor tersebut tidak ditemukan.");
                    }
                    break;
                case 5:
                    // Tampilkan Statistik
                    StatistikPutusan statistik = controller.getStatistik();
                    view.tampilkanStatistik(statistik);
                    break;
                case 0:
                    // Keluar
                    view.tampilkanPesan("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    scanner.close();
                    return;
            }
        }
    }

    /**
     * Metode helper untuk menangani sub-menu pencarian dan filter.
     */
    private static void handleSearchAndFilter(Scanner scanner, ConsoleView view, KnowledgeController controller) {
        System.out.println("\n--- Cari & Filter ---");
        System.out.println("1. Cari berdasarkan Nomor Perkara");
        System.out.println("2. Cari berdasarkan Nama Terdakwa");
        System.out.println("3. Filter berdasarkan Jenis Narkotika");
        System.out.println("4. Filter berdasarkan Pengadilan");
        System.out.println("5. Filter berdasarkan Rentang Vonis (bulan)");
        int pilihan = InputHandler.validasiPilihan("Pilih mode: ", 1, 5, scanner);

        ArrayList<Putusan> hasil;
        switch (pilihan) {
            case 1:
                String nomor = InputHandler.validasiString("Masukkan Nomor Perkara: ", scanner);
                Putusan p = controller.cariPutusanByNomor(nomor);
                view.tampilkanDetail(p);
                break;
            case 2:
                String nama = InputHandler.validasiString("Masukkan sebagian nama terdakwa: ", scanner);
                hasil = controller.cariPutusanByNama(nama);
                view.tampilkanDaftarPutusan(hasil);
                break;
            case 3:
                String jenis = InputHandler.validasiString("Masukkan jenis narkotika (e.g., Sabu-sabu, Ganja): ", scanner);
                hasil = controller.filterByJenisNarkotika(jenis);
                view.tampilkanDaftarPutusan(hasil);
                break;
            case 4:
                String pengadilan = InputHandler.validasiString("Masukkan nama pengadilan (e.g., PN Surabaya): ", scanner);
                hasil = controller.filterByPengadilan(pengadilan);
                view.tampilkanDaftarPutusan(hasil);
                break;
            case 5:
                int min = InputHandler.validasiInt("Masukkan vonis minimal (bulan): ", scanner);
                int max = InputHandler.validasiInt("Masukkan vonis maksimal (bulan): ", scanner);
                hasil = controller.filterByRentangVonis(min, max);
                view.tampilkanDaftarPutusan(hasil);
                break;
        }
    }
}
