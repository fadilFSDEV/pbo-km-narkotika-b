package model;

/**
 * Abstract class KasusHukum berfungsi sebagai parent class untuk semua jenis kasus.
 * Class ini mendefinisikan atribut dan perilaku dasar yang dimiliki oleh
 * sebuah kasus hukum, seperti nomor perkara, nama terdakwa, dll.
 */
public abstract class KasusHukum {
    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;

    /**
     * Constructor default.
     */
    public KasusHukum() {
    }

    /**
     * Constructor dengan parameter untuk menginisialisasi atribut dasar kasus.
     * @param nomorPerkara Nomor registrasi perkara.
     * @param pengadilan Nama pengadilan yang menangani.
     * @param tanggalPutusan Tanggal putusan dijatuhkan.
     * @param namaTerdakwa Nama lengkap terdakwa.
     * @param umurTerdakwa Usia terdakwa saat putusan.
     */
    public KasusHukum(String nomorPerkara, String pengadilan, String tanggalPutusan, String namaTerdakwa, int umurTerdakwa) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
    }

    /**
     * Metode abstract yang harus diimplementasikan oleh subclass.
     * Bertujuan untuk menampilkan informasi ringkas dari kasus.
     */
    public abstract void tampilkan();

    // --- Getters and Setters ---

    public String getNomorPerkara() {
        return nomorPerkara;
    }

    public void setNomorPerkara(String nomorPerkara) {
        this.nomorPerkara = nomorPerkara;
    }

    public String getPengadilan() {
        return pengadilan;
    }

    public void setPengadilan(String pengadilan) {
        this.pengadilan = pengadilan;
    }

    public String getTanggalPutusan() {
        return tanggalPutusan;
    }

    public void setTanggalPutusan(String tanggalPutusan) {
        this.tanggalPutusan = tanggalPutusan;
    }

    public String getNamaTerdakwa() {
        return namaTerdakwa;
    }

    public void setNamaTerdakwa(String namaTerdakwa) {
        this.namaTerdakwa = namaTerdakwa;
    }

    public int getUmurTerdakwa() {
        return umurTerdakwa;
    }

    public void setUmurTerdakwa(int umurTerdakwa) {
        if (umurTerdakwa > 0) {
            this.umurTerdakwa = umurTerdakwa;
        }
    }
}
