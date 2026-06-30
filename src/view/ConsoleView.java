package view;

import controller.KnowledgeController;
import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class ConsoleView bertanggung jawab untuk semua interaksi dengan pengguna.
 * Ini termasuk menampilkan menu, menerima input, dan menampilkan data ke konsol.
 */

public class ConsoleView {
    private KnowledgeController controller;
    private Scanner scanner;

    public ConsoleView(KnowledgeController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            int pilihan = tampilkanMenu();
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanSemuaData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    filterData();
                    break;
                case 5:
                    hapusData();
                    break;
                case 6:
                    tampilkanStatistik();
                    break;
                case 7:
                    System.out.println("Keluar dari aplikasi...");
                    running = false;
                    break;
            }
        }
    }

    public int tampilkanMenu() {
        System.out.println("\n=== KMS Putusan Pengadilan Narkotika ===");
        System.out.println("1. Tambah Putusan");
        System.out.println("2. Tampilkan Semua Putusan");
        System.out.println("3. Cari Putusan");
        System.out.println("4. Filter Putusan");
        System.out.println("5. Hapus Putusan");
        System.out.println("6. Lihat Statistik");
        System.out.println("7. Keluar");
        return InputHandler.validasiPilihan("Pilih menu (1-7): ", 1, 7, scanner);
    }

    private void tambahData() {
        System.out.println("\n--- Tambah Putusan ---");
        String[] data = inputFormPutusan(scanner);
        if (controller.tambahPutusan(data)) {
            tampilkanPesan("Putusan berhasil ditambahkan!");
        } else {
            tampilkanPesan("Gagal menambahkan putusan.");
        }
    }

    public String[] inputFormPutusan(Scanner sc) {
        String[] data = new String[12];
        data[0] = InputHandler.validasiString("Nomor Perkara: ", sc);
        data[1] = InputHandler.validasiString("Pengadilan: ", sc);
        data[2] = InputHandler.validasiString("Tanggal Putusan (DD-MM-YYYY): ", sc);
        data[3] = InputHandler.validasiString("Nama Terdakwa: ", sc);
        data[4] = String.valueOf(InputHandler.validasiInt("Umur Terdakwa: ", sc));
        data[5] = InputHandler.validasiString("Jenis Narkotika: ", sc);
        data[6] = String.valueOf(InputHandler.validasiDouble("Berat Barang Bukti (gram): ", sc));
        data[7] = InputHandler.validasiString("Pasal yang Dilanggar: ", sc);
        data[8] = InputHandler.validasiString("Peran Terdakwa: ", sc);
        data[9] = String.valueOf(InputHandler.validasiInt("Vonis Hukuman (bulan): ", sc));
        data[10] = String.valueOf(InputHandler.validasiDouble("Vonis Denda (Rp): ", sc));
        data[11] = InputHandler.validasiString("Nama Hakim: ", sc);
        return data;
    }

    private void tampilkanSemuaData() {
        System.out.println("\n--- Daftar Semua Putusan ---");
        controller.tampilkanSemua();
    }

    private void cariData() {
        System.out.println("\n--- Cari Putusan ---");
        System.out.println("1. Berdasarkan Nomor Perkara");
        System.out.println("2. Berdasarkan Nama Terdakwa");
        int pilihan = InputHandler.validasiPilihan("Pilih mode pencarian (1-2): ", 1, 2, scanner);
        
        String keyword = InputHandler.validasiString("Masukkan kata kunci: ", scanner);
        String mode = (pilihan == 1) ? "nomor" : "nama";
        
        ArrayList<Putusan> hasil = controller.cariPutusan(keyword, mode);
        tampilkanDaftarPutusan(hasil);
    }

    private void filterData() {
        System.out.println("\n--- Filter Putusan ---");
        System.out.println("1. Berdasarkan Jenis Narkotika");
        System.out.println("2. Berdasarkan Pengadilan");
        int pilihan = InputHandler.validasiPilihan("Pilih kriteria (1-2): ", 1, 2, scanner);
        
        String nilai = InputHandler.validasiString("Masukkan nilai filter: ", scanner);
        String kriteria = (pilihan == 1) ? "jenis" : "pengadilan";
        
        ArrayList<Putusan> hasil = controller.filterPutusan(kriteria, nilai);
        tampilkanDaftarPutusan(hasil);
    }

    private void hapusData() {
        System.out.println("\n--- Hapus Putusan ---");
        String nomor = InputHandler.validasiString("Masukkan Nomor Perkara yang akan dihapus: ", scanner);
        if (controller.hapusPutusan(nomor)) {
            tampilkanPesan("Putusan dengan nomor " + nomor + " berhasil dihapus.");
        } else {
            tampilkanPesan("Putusan dengan nomor " + nomor + " tidak ditemukan.");
        }
    }

    private void tampilkanStatistik() {
        StatistikPutusan stat = controller.getStatistik();
        tampilkanStatistik(stat);
    }

    public void tampilkanDaftarPutusan(ArrayList<Putusan> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("Data tidak ditemukan.");
        } else {
            System.out.println("Ditemukan " + list.size() + " data:");
            for (Putusan p : list) {
                tampilkanDetail(p);
                System.out.println("-------------------------");
            }
        }
    }

    public void tampilkanDetail(Putusan p) {
        p.tampilkan(true);
        System.out.println("Kategori Hukuman: " + p.getKategoriHukuman());
    }

    public void tampilkanStatistik(StatistikPutusan stat) {
        stat.tampilkanLaporan();
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(">>> " + pesan);
    }
}
