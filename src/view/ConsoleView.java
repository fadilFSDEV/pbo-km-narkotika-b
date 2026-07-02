package view;

import model.Putusan;
import model.StatistikPutusan;
import util.InputHandler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class ConsoleView bertanggung jawab untuk semua interaksi dengan pengguna
 * melalui konsol. Menampilkan data dan menerima input.
 */
public class ConsoleView {

    /**
     * Menampilkan menu utama dan meminta pilihan dari pengguna.
     * @param sc Objek Scanner untuk membaca input.
     * @return Pilihan menu yang valid dari pengguna.
     */
    public int tampilkanMenu(Scanner sc) {
        System.out.println("\n--- KNOWLEDGE MANAGEMENT SYSTEM PUTUSAN NARKOTIKA ---");
        System.out.println("1. Tampilkan Semua Putusan");
        System.out.println("2. Tambah Putusan Baru");
        System.out.println("3. Cari & Filter Putusan");
        System.out.println("4. Hapus Putusan");
        System.out.println("5. Tampilkan Statistik");
        System.out.println("0. Keluar");
        return InputHandler.validasiPilihan("Pilih menu: ", 0, 5, sc);
    }

    /**
     * Menampilkan daftar putusan dalam format tabel yang rapi.
     * @param daftar List putusan yang akan ditampilkan.
     */
    public void tampilkanDaftarPutusan(ArrayList<Putusan> daftar) {
        System.out.println("\n--- DAFTAR PUTUSAN ---");
        if (daftar == null || daftar.isEmpty()) {
            tampilkanPesan("Tidak ada data putusan yang cocok.");
            return;
        }
        // Header Tabel
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-25s | %-20s | %-15s | %-5s | %-10s |\n", "No.", "Nomor Perkara", "Terdakwa", "Jenis Narkotika", "Vonis", "Kategori");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        // Isi Tabel
        int i = 1;
        for (Putusan p : daftar) {
            System.out.printf("| %-3d | %-25s | %-20s | %-15s | %-5d bln | %-10s |\n",
                    i++,
                    p.getNomorPerkara(),
                    p.getNamaTerdakwa(),
                    p.getJenisNarkotika(),
                    p.getVonisHukuman(),
                    p.getKategoriHukuman());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        tampilkanPesan("Total " + daftar.size() + " data ditampilkan.");
    }

    /**
     * Menampilkan detail satu putusan secara lengkap.
     * @param p Objek Putusan yang akan ditampilkan.
     */
    public void tampilkanDetail(Putusan p) {
        if (p != null) {
            p.tampilkan(true); // Menggunakan method tampilkan(true) yang sudah ada di Putusan
        } else {
            tampilkanPesan("Putusan tidak ditemukan.");
        }
    }

    /**
     * Menampilkan laporan statistik.
     * @param stat Objek StatistikPutusan yang akan ditampilkan.
     */
    public void tampilkanStatistik(StatistikPutusan stat) {
        if (stat != null && stat.getTotalPutusan() > 0) {
            stat.tampilkanLaporan();
        } else {
            tampilkanPesan("Statistik tidak dapat dibuat (tidak ada data).");
        }
    }

    /**
     * Menampilkan pesan informasi ke pengguna.
     * @param pesan Teks pesan yang akan ditampilkan.
     */
    public void tampilkanPesan(String pesan) {
        System.out.println("\n[INFO] " + pesan);
    }

    /**
     * Menampilkan form untuk menginput data putusan baru.
     * Menggunakan InputHandler untuk validasi setiap field.
     * @param sc Objek Scanner untuk membaca input.
     * @return Sebuah array of String berisi data mentah dari pengguna.
     */
    public String[] inputFormPutusan(Scanner sc) {
        System.out.println("\n--- FORM INPUT PUTUSAN BARU ---");
        String[] data = new String[12];
        data[0] = InputHandler.validasiString("Nomor Perkara: ", sc);
        data[1] = InputHandler.validasiString("Pengadilan: ", sc);
        data[2] = InputHandler.validasiString("Tanggal Putusan (YYYY-MM-DD): ", sc);
        data[3] = InputHandler.validasiString("Nama Terdakwa: ", sc);
        data[4] = String.valueOf(InputHandler.validasiInt("Umur Terdakwa: ", sc));
        data[5] = InputHandler.validasiString("Jenis Narkotika: ", sc);
        data[6] = String.valueOf(InputHandler.validasiDouble("Berat Barang Bukti (gram): ", sc));
        data[7] = InputHandler.validasiString("Pasal yang Dilanggar: ", sc);
        data[8] = InputHandler.validasiString("Peran Terdakwa: ", sc);
        data[9] = String.valueOf(InputHandler.validasiInt("Vonis Hukuman (bulan): ", sc));
        data[10] = String.valueOf(InputHandler.validasiDouble("Vonis Denda (Rp): ", sc));
        data[11] = InputHandler.validasiString("Nama Hakim Ketua: ", sc);
        return data;
    }
}
