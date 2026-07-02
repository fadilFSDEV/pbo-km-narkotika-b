package model;

/**
 * Class Putusan adalah entitas utama dalam sistem.
 * Merupakan turunan dari KasusHukum dan mengimplementasikan interface IKasus.
 * Class ini merepresentasikan satu data putusan pengadilan narkotika,
 * lengkap dengan semua atributnya.
 */
public class Putusan extends KasusHukum implements IKasus {

    // --- Fields ---
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman; // dalam bulan
    private double vonisDenda;
    private String namaHakim;
    private static int jumlahDibuat = 0;

    // --- Constructors ---

    /**
     * Constructor default (no-arg).
     * Memanggil constructor parent dan menambah counter static.
     */
    public Putusan() {
        super();
        jumlahDibuat++;
    }

    /**
     * Constructor dengan parameter lengkap.
     * Menginisialisasi semua atribut putusan.
     * @param nomorPerkara Nomor registrasi perkara.
     * @param pengadilan Nama pengadilan yang menangani.
     * @param tanggalPutusan Tanggal putusan dijatuhkan.
     * @param namaTerdakwa Nama lengkap terdakwa.
     * @param umurTerdakwa Usia terdakwa saat putusan.
     * @param jenisNarkotika Jenis narkotika yang terlibat.
     * @param beratBarangBukti Berat barang bukti dalam gram.
     * @param pasalDilanggar Pasal UU yang dilanggar.
     * @param peranTerdakwa Peran terdakwa dalam kasus (mis. Pengguna, Kurir).
     * @param vonisHukuman Lamanya hukuman penjara dalam bulan.
     * @param vonisDenda Besaran denda dalam Rupiah.
     * @param namaHakim Nama hakim ketua yang memutuskan.
     */
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

    // --- Static Method ---

    /**
     * Mengembalikan jumlah total objek Putusan yang pernah dibuat.
     * @return Jumlah total objek.
     */
    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    // --- Overridden Methods ---

    /**
     * Menampilkan ringkasan putusan dalam satu baris.
     * (Overriding method dari parent class KasusHukum).
     */
    @Override
    public void tampilkan() {
        System.out.println("Nomor: " + getNomorPerkara() + " | Terdakwa: " + getNamaTerdakwa() + " | Vonis: " + vonisHukuman + " bulan");
    }

    /**
     * Menampilkan detail lengkap atau ringkasan putusan.
     * (Overloading method tampilkan()).
     * @param detail Jika true, tampilkan detail lengkap. Jika false, tampilkan ringkasan.
     */
    public void tampilkan(boolean detail) {
        if (detail) {
            System.out.println("--- Detail Putusan ---");
            System.out.println("Nomor Perkara : " + getNomorPerkara());
            System.out.println("Pengadilan    : " + getPengadilan());
            System.out.println("Tanggal       : " + getTanggalPutusan());
            System.out.println("Nama Terdakwa : " + getNamaTerdakwa());
            System.out.println("Umur          : " + getUmurTerdakwa() + " tahun");
            System.out.println("Jenis         : " + jenisNarkotika);
            System.out.println("Berat Bukti   : " + beratBarangBukti + " gram");
            System.out.println("Pasal         : " + pasalDilanggar);
            System.out.println("Peran         : " + peranTerdakwa);
            System.out.println("Vonis Hukuman : " + vonisHukuman + " bulan");
            System.out.println("Vonis Denda   : Rp " + String.format("%,.0f", vonisDenda));
            System.out.println("Nama Hakim    : " + namaHakim);
        } else {
            tampilkan();
        }
    }

    /**
     * Mengembalikan kategori hukuman berdasarkan lamanya vonis.
     * (Overriding method dari interface IKasus).
     * @return String "Ringan", "Sedang", atau "Berat".
     */
    @Override
    public String getKategoriHukuman() {
        if (vonisHukuman < 12) return "Ringan";      // Di bawah 1 tahun
        else if (vonisHukuman <= 60) return "Sedang"; // 1 - 5 tahun
        else return "Berat";                         // Di atas 5 tahun
    }

    /**
     * Representasi String dari objek Putusan.
     * @return String yang berisi nomor perkara dan nama terdakwa.
     */
    @Override
    public String toString() {
        return "Putusan{" +
                "nomorPerkara='" + getNomorPerkara() + '\'' +
                ", namaTerdakwa='" + getNamaTerdakwa() + '\'' +
                '}';
    }

    // --- Getters and Setters with Validation ---

    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }

    public double getBeratBarangBukti() { return beratBarangBukti; }
    public void setBeratBarangBukti(double beratBarangBukti) {
        if (beratBarangBukti > 0) {
            this.beratBarangBukti = beratBarangBukti;
        }
    }

    public String getPasalDilanggar() { return pasalDilanggar; }
    public void setPasalDilanggar(String pasalDilanggar) { this.pasalDilanggar = pasalDilanggar; }

    public String getPeranTerdakwa() { return peranTerdakwa; }
    public void setPeranTerdakwa(String peranTerdakwa) { this.peranTerdakwa = peranTerdakwa; }

    public int getVonisHukuman() { return vonisHukuman; }
    public void setVonisHukuman(int vonisHukuman) {
        if (vonisHukuman >= 0) {
            this.vonisHukuman = vonisHukuman;
        }
    }

    public double getVonisDenda() { return vonisDenda; }
    public void setVonisDenda(double vonisDenda) {
        if (vonisDenda >= 0) {
            this.vonisDenda = vonisDenda;
        }
    }

    public String getNamaHakim() { return namaHakim; }
    public void setNamaHakim(String namaHakim) { this.namaHakim = namaHakim; }
}
