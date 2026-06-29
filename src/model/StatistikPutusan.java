package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {
    private int totalPutusan;
    private double rataRataVonis;
    private double rataRataDenda;
    private String jenisNarkotikaTerbanyak;
    private String[] distribusiPeran;

    public StatistikPutusan(ArrayList<Putusan> daftar) {
        if (daftar != null && !daftar.isEmpty()) {
            hitungSemua(daftar);
        }
    }

    private void hitungSemua(ArrayList<Putusan> daftar) {
        totalPutusan = daftar.size();
        
        long totalVonis = 0;
        double totalDenda = 0;
        
        HashMap<String, Integer> jenisCount = new HashMap<>();
        HashMap<String, Integer> peranCount = new HashMap<>();

        for (Putusan p : daftar) {
            totalVonis += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            jenisCount.put(p.getJenisNarkotika(), jenisCount.getOrDefault(p.getJenisNarkotika(), 0) + 1);
            peranCount.put(p.getPeranTerdakwa(), peranCount.getOrDefault(p.getPeranTerdakwa(), 0) + 1);
        }

        rataRataVonis = (double) totalVonis / totalPutusan;
        rataRataDenda = totalDenda / totalPutusan;

        int maxJenis = 0;
        for (Map.Entry<String, Integer> entry : jenisCount.entrySet()) {
            if (entry.getValue() > maxJenis) {
                maxJenis = entry.getValue();
                jenisNarkotikaTerbanyak = entry.getKey();
            }
        }

        distribusiPeran = new String[peranCount.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : peranCount.entrySet()) {
            distribusiPeran[i++] = entry.getKey() + ": " + entry.getValue();
        }
    }

    public void tampilkanLaporan() {
        System.out.println("=== Statistik Putusan ===");
        System.out.println("Total Putusan        : " + totalPutusan);
        System.out.println("Rata-rata Vonis      : " + String.format("%.2f", rataRataVonis) + " bulan");
        System.out.println("Rata-rata Denda      : Rp " + String.format("%.2f", rataRataDenda));
        System.out.println("Jenis Narkotika Max  : " + jenisNarkotikaTerbanyak);
        System.out.println("Distribusi Peran     :");
        if (distribusiPeran != null) {
            for (String peran : distribusiPeran) {
                System.out.println("  - " + peran);
            }
        }
    }

    public int getTotalPutusan() { return totalPutusan; }
    public double getRataRataVonis() { return rataRataVonis; }
    public double getRataRataDenda() { return rataRataDenda; }
    public String getJenisNarkotikaTerbanyak() { return jenisNarkotikaTerbanyak; }
    public String[] getDistribusiPeran() { return distribusiPeran; }
}
