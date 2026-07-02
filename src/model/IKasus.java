package model;

/**
 * Interface IKasus mendefinisikan kontrak atau perilaku yang harus dimiliki
 * oleh setiap class yang merepresentasikan sebuah kasus.
 * Ini adalah contoh penerapan polimorfisme melalui interface.
 */
public interface IKasus {
    /**
     * Metode ini harus mengembalikan kategori dari sebuah kasus
     * berdasarkan kriteria tertentu (mis. beratnya hukuman).
     * @return String yang merepresentasikan kategori kasus.
     */
    String getKategoriHukuman();
}
