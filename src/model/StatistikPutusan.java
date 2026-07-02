package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class StatistikPutusan bertanggung jawab untuk melakukan kalkulasi statistik
 * dari sekumpulan data putusan.
 * Objek dari class ini dibuat dengan menerima daftar putusan, lalu menghitung
 * berbagai metrik seperti rata-rata, modus, dll.
 */
public class StatistikPutusan {
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private Map<String, Integer> distribusiPeran;

    /**
     * Constructor untuk StatistikPutusan.
     * @param daftar ArrayList Putusan yang akan dianalisis.
     */
    public StatistikPutusan(ArrayList<Putusan> daftar) {
        if (daftar != null && !daftar.isEmpty()) {
            hitungSemua(daftar);
        }
    }

    /**
     * Metode internal untuk menjalankan semua kalkulasi statistik.
     * @param daftar Daftar putusan sebagai sumber data.
     */
    private void hitungSemua(ArrayList<Putusan> daftar) {
        this.totalPutusan = daftar.size();
        
        long totalVonis = 0;
        double totalDenda = 0;
        
        HashMap<String, Integer> jenisCount = new HashMap<>();
        this.distribusiPeran = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            jenisCount.put(p.getJenisNarkotika(), jenisCount.getOrDefault(p.getJenisNarkotika(), 0) + 1);
            this.distribusiPeran.put(p.getPeranTerdakwa(), this.distribusiPeran.getOrDefault(p.getPeranTerdakwa(), 0) + 1);
        }

        this.rataRataVonis = (double) totalVonis / this.totalPutusan;
        this.rataRataDenda = totalDenda / this.totalPutusan;

        int maxJenis = 0;
        for (Map.Entry<String, Integer> entry : jenisCount.entrySet()) {
            if (entry.getValue() > maxJenis) {
                maxJenis = entry.getValue();
                this.jenisNarkotikaTerbanyak = entry.getKey();
            }
        }
    }

    /**
     * Menampilkan laporan statistik yang telah dihitung ke konsol.
     */
    public void tampilkanLaporan() {
        System.out.println("=== Laporan Statistik Putusan ===");
        System.out.println("Total Putusan        : " + totalPutusan);
        System.out.println("Rata-rata Vonis      : " + String.format("%.2f", rataRataVonis) + " bulan");
        System.out.println("Rata-rata Denda      : Rp " + String.format("%,.2f", rataRataDenda));
        System.out.println("Jenis Narkotika Max  : " + (jenisNarkotikaTerbanyak != null ? jenisNarkotikaTerbanyak : "N/A"));
        System.out.println("Distribusi Peran     :");
        if (distribusiPeran != null && !distribusiPeran.isEmpty()) {
            for (Map.Entry<String, Integer> entry : distribusiPeran.entrySet()) {
                System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " kasus");
            }
        } else {
            System.out.println("  - Tidak ada data peran.");
        }
    }

    // --- Getters ---
    public int getTotalPutusan() { return totalPutusan; }
    public double getRataRataVonis() { return rataRataVonis; }
    public double getRataRataDenda() { return rataRataDenda; }
    public String getJenisNarkotikaTerbanyak() { return jenisNarkotikaTerbanyak; }
    public Map<String, Integer> getDistribusiPeran() { return distribusiPeran; }
}
