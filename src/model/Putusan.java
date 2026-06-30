package model;

/**
 * Class Putusan merepresentasikan satu entitas data putusan pengadilan narkotika.
 * Class ini menyimpan semua detail terkait sebuah kasus, mulai dari data terdakwa
 * hingga vonis yang dijatuhkan.
 */

public class Putusan extends KasusHukum implements IKasus {
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman; // bulan
    private double vonisDenda;
    private String namaHakim;
    private static int jumlahDibuat = 0;

    public Putusan() {
        super();
        jumlahDibuat++;
    }

    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan, String namaTerdakwa, int umurTerdakwa,
                   String jenisNarkotika, double beratBarangBukti, String pasalDilanggar, String peranTerdakwa,
                   int vonisHukuman, double vonisDenda, String namaHakim) {
        super(nomorPerkara, pengadilan, tanggalPutusan, namaTerdakwa, umurTerdakwa);
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;
        jumlahDibuat++;
    }

    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    @Override
    public void tampilkan() {
        System.out.println("Nomor: " + getNomorPerkara() + " | Terdakwa: " + getNamaTerdakwa() + " | Vonis: " + vonisHukuman + " bulan");
    }

    public void tampilkan(boolean detail) {
        if (detail) {
            System.out.println("--- Detail Putusan ---");
            System.out.println("Nomor Perkara : " + getNomorPerkara());
            System.out.println("Pengadilan    : " + getPengadilan());
            System.out.println("Tanggal       : " + getTanggalPutusan());
            System.out.println("Nama Terdakwa : " + getNamaTerdakwa());
            System.out.println("Umur          : " + getUmurTerdakwa());
            System.out.println("Jenis         : " + jenisNarkotika);
            System.out.println("Berat Bukti   : " + beratBarangBukti + " gram");
            System.out.println("Pasal         : " + pasalDilanggar);
            System.out.println("Peran         : " + peranTerdakwa);
            System.out.println("Vonis Hukuman : " + vonisHukuman + " bulan");
            System.out.println("Vonis Denda   : Rp " + vonisDenda);
            System.out.println("Nama Hakim    : " + namaHakim);
        } else {
            tampilkan();
        }
    }

    @Override
    public String getKategoriHukuman() {
        if (vonisHukuman < 12) return "Ringan";
        else if (vonisHukuman <= 60) return "Sedang";
        else return "Berat";
    }

    @Override
    public String toString() {
        return "Putusan{" +
                "nomorPerkara='" + getNomorPerkara() + '\'' +
                ", namaTerdakwa='" + getNamaTerdakwa() + '\'' +
                '}';
    }

    // Getters and Setters
    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }
    public double getBeratBarangBukti() { return beratBarangBukti; }
    public void setBeratBarangBukti(double beratBarangBukti) { this.beratBarangBukti = beratBarangBukti; }
    public String getPasalDilanggar() { return pasalDilanggar; }
    public void setPasalDilanggar(String pasalDilanggar) { this.pasalDilanggar = pasalDilanggar; }
    public String getPeranTerdakwa() { return peranTerdakwa; }
    public void setPeranTerdakwa(String peranTerdakwa) { this.peranTerdakwa = peranTerdakwa; }
    public int getVonisHukuman() { return vonisHukuman; }
    public void setVonisHukuman(int vonisHukuman) { this.vonisHukuman = vonisHukuman; }
    public double getVonisDenda() { return vonisDenda; }
    public void setVonisDenda(double vonisDenda) { this.vonisDenda = vonisDenda; }
    public String getNamaHakim() { return namaHakim; }
    public void setNamaHakim(String namaHakim) { this.namaHakim = namaHakim; }
}
