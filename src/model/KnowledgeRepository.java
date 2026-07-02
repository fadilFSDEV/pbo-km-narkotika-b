package model;

import java.util.ArrayList;

/**
 * Class KnowledgeRepository berfungsi sebagai database berbasis memori (ArrayList)
 * untuk menyimpan, mencari, memfilter, dan mengelola semua objek Putusan.
 * Sesuai dengan peran Knowledge/Database Engineer, class ini juga menginisialisasi
 * data sampel yang dibutuhkan untuk demo aplikasi.
 */
public class KnowledgeRepository {
    private ArrayList<Putusan> daftarPutusan;

    /**
     * Constructor untuk KnowledgeRepository.
     * Langsung menginisialisasi daftar putusan dengan 50 data sampel.
     */
    public KnowledgeRepository() {
        daftarPutusan = new ArrayList<>();
        initSampleData();
    }

    /**
     * Menyimpan sebuah objek Putusan ke dalam repository.
     * @param p Objek Putusan yang akan disimpan.
     */
    public void simpan(Putusan p) {
        if (p != null) {
            daftarPutusan.add(p);
        }
    }

    /**
     * Mencari sebuah Putusan berdasarkan nomor perkaranya.
     * Pencarian tidak case-sensitive.
     * @param nomor Nomor perkara yang dicari.
     * @return Objek Putusan jika ditemukan, jika tidak maka null.
     */
    public Putusan cariByNomor(String nomor) {
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().equalsIgnoreCase(nomor)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Mencari semua Putusan yang nama terdakwanya mengandung kata kunci.
     * Pencarian tidak case-sensitive.
     * @param nama Kata kunci nama terdakwa.
     * @return Sebuah ArrayList berisi Putusan yang cocok.
     */
    public ArrayList<Putusan> cariByNama(String nama) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getNamaTerdakwa().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Memfilter daftar putusan berdasarkan jenis narkotika.
     * @param jenis Jenis narkotika yang akan difilter.
     * @return Sebuah ArrayList berisi Putusan yang cocok.
     */
    public ArrayList<Putusan> filterByJenis(String jenis) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getJenisNarkotika().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Memfilter daftar putusan berdasarkan nama pengadilan.
     * @param pengadilan Nama pengadilan yang akan difilter.
     * @return Sebuah ArrayList berisi Putusan yang cocok.
     */
    public ArrayList<Putusan> filterByPengadilan(String pengadilan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getPengadilan().equalsIgnoreCase(pengadilan)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Memfilter daftar putusan berdasarkan rentang vonis hukuman.
     * @param minBulan Vonis minimal dalam bulan (inklusif).
     * @param maxBulan Vonis maksimal dalam bulan (inklusif).
     * @return Sebuah ArrayList berisi Putusan yang cocok.
     */
    public ArrayList<Putusan> filterByRentangVonis(int minBulan, int maxBulan) {
        ArrayList<Putusan> hasil = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getVonisHukuman() >= minBulan && p.getVonisHukuman() <= maxBulan) {
                hasil.add(p);
            }
        }
        return hasil;
    }
    
    /**
     * Menghapus sebuah Putusan dari repository berdasarkan nomor perkaranya.
     * @param nomor Nomor perkara dari Putusan yang akan dihapus.
     * @return true jika berhasil dihapus, false jika tidak ditemukan.
     */
    public boolean hapus(String nomor) {
        Putusan p = cariByNomor(nomor);
        if (p != null) {
            daftarPutusan.remove(p);
            return true;
        }
        return false;
    }

    /**
     * Mengembalikan seluruh daftar putusan yang ada di repository.
     * @return Sebuah ArrayList berisi semua objek Putusan.
     */
    public ArrayList<Putusan> getDaftarSemua() {
        return daftarPutusan;
    }

    /**
     * Mengembalikan jumlah total data putusan yang tersimpan.
     * @return Jumlah total data.
     */
    public int getTotalData() {
        return daftarPutusan.size();
    }

    /**
     * Metode internal untuk menginisialisasi 50 data sampel.
     */
    private void initSampleData() {
        // 50 Data Sampel
        daftarPutusan.add(new Putusan("1001/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-01-15", "Budi Santoso", 28, "Sabu-sabu", 0.5, "Pasal 112", "Pengguna", 12, 5000000.0, "Ahmad Hakim"));
        daftarPutusan.add(new Putusan("1002/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-02-20", "Citra Lestari", 22, "Ganja", 50.0, "Pasal 111", "Kurir", 48, 10000000.0, "Bambang Wijoyo"));
        daftarPutusan.add(new Putusan("005/Pid.Sus/2025/PN Jkt", "PN Jakarta Pusat", "2025-03-10", "Doni Firmansyah", 35, "Ekstasi", 10.0, "Pasal 114", "Bandar", 120, 1000000000.0, "Cahyo Nugroho"));
        daftarPutusan.add(new Putusan("006/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-04-01", "Eka Putri", 25, "Sabu-sabu", 1.2, "Pasal 112", "Pengguna", 18, 8000000.0, "Dedi Mulyadi"));
        daftarPutusan.add(new Putusan("007/Pid.Sus/2024/PN Mdn", "PN Medan", "2024-05-12", "Fajar Nugraha", 30, "Heroin", 5.0, "Pasal 114", "Pengedar", 96, 500000000.0, "Farida Hanum"));
        daftarPutusan.add(new Putusan("008/Pid.Sus/2025/PN Smg", "PN Semarang", "2025-01-20", "Gita Permata", 21, "Ganja", 250.0, "Pasal 111", "Penyimpan", 36, 5000000.0, "Gatot Subroto"));
        daftarPutusan.add(new Putusan("009/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-06-18", "Hadi Prabowo", 40, "Sabu-sabu", 15.0, "Pasal 114", "Bandar", 180, 2000000000.0, "Hasanuddin"));
        daftarPutusan.add(new Putusan("010/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-07-22", "Indah Cahyani", 26, "Ekstasi", 50.0, "Pasal 112", "Pengguna", 24, 15000000.0, "I Gede Made"));
        daftarPutusan.add(new Putusan("011/Pid.Sus/2025/PN Jkt", "PN Jakarta Pusat", "2025-02-11", "Joko Susilo", 33, "Ganja", 1000.0, "Pasal 114", "Bandar", 144, 1500000000.0, "Jefri Nichol"));
        daftarPutusan.add(new Putusan("012/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-08-30", "Kartika Sari", 29, "Sabu-sabu", 0.8, "Pasal 127", "Pecandu", 6, 0.0, "Kartini"));
        daftarPutusan.add(new Putusan("013/Pid.Sus/2024/PN Sby", "PN Surabaya", "2024-09-05", "Lutfi Hakim", 24, "Ganja", 150.0, "Pasal 111", "Kurir", 60, 12000000.0, "Luhut Panjaitan"));
        daftarPutusan.add(new Putusan("014/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-03-01", "Maya Indah", 20, "Ekstasi", 5.0, "Pasal 112", "Pengguna", 12, 4000000.0, "Maruli Simanjuntak"));
        daftarPutusan.add(new Putusan("015/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-10-10", "Nanda Putra", 31, "Sabu-sabu", 2.0, "Pasal 112", "Pengguna", 20, 10000000.0, "Nadiem Makarim"));
        daftarPutusan.add(new Putusan("016/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-11-15", "Oscar Maulana", 38, "Heroin", 2.0, "Pasal 114", "Pengedar", 84, 400000000.0, "Otto Hasibuan"));
        daftarPutusan.add(new Putusan("017/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-04-20", "Putri Amelia", 23, "Ganja", 80.0, "Pasal 111", "Penyimpan", 30, 3000000.0, "Puan Maharani"));
        daftarPutusan.add(new Putusan("018/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-12-01", "Qomarudin", 45, "Sabu-sabu", 25.0, "Pasal 114", "Bandar", 240, 3000000000.0, "Quraish Shihab"));
        daftarPutusan.add(new Putusan("019/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-01-25", "Rian Ardianto", 27, "Ekstasi", 20.0, "Pasal 112", "Pengguna", 30, 20000000.0, "Ridwan Kamil"));
        daftarPutusan.add(new Putusan("020/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-05-05", "Sari Wangi", 22, "Sabu-sabu", 0.3, "Pasal 127", "Pecandu", 4, 0.0, "Sandiaga Uno"));
        daftarPutusan.add(new Putusan("021/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-02-14", "Toni Stark", 39, "Ganja", 500.0, "Pasal 114", "Bandar", 132, 1200000000.0, "Tony Hidayat"));
        daftarPutusan.add(new Putusan("022/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-03-28", "Umar Bakri", 50, "Sabu-sabu", 1.5, "Pasal 112", "Pengguna", 15, 7000000.0, "Umar Said"));
        daftarPutusan.add(new Putusan("023/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-06-10", "Vina Panduwinata", 28, "Ekstasi", 15.0, "Pasal 112", "Pengguna", 28, 18000000.0, "Vicky Prasetyo"));
        daftarPutusan.add(new Putusan("024/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-04-19", "Wawan Kurniawan", 32, "Ganja", 300.0, "Pasal 111", "Kurir", 72, 25000000.0, "Wowo Subianto"));
        daftarPutusan.add(new Putusan("025/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-05-21", "Xena Warrior", 29, "Sabu-sabu", 3.0, "Pasal 112", "Pengguna", 22, 12000000.0, "Xavier"));
        daftarPutusan.add(new Putusan("026/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-07-18", "Yanto Basna", 25, "Heroin", 1.0, "Pasal 114", "Pengedar", 72, 300000000.0, "Yasonna Laoly"));
        daftarPutusan.add(new Putusan("027/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-06-30", "Zulham Zamrun", 36, "Ganja", 50.0, "Pasal 111", "Penyimpan", 24, 2000000.0, "Zulkifli Hasan"));
        daftarPutusan.add(new Putusan("028/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-07-07", "Andik Vermansah", 31, "Sabu-sabu", 0.9, "Pasal 127", "Pecandu", 7, 0.0, "Andi Mallarangeng"));
        daftarPutusan.add(new Putusan("029/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-08-17", "Bambang Pamungkas", 40, "Ekstasi", 30.0, "Pasal 114", "Bandar", 150, 1800000000.0, "Bambang Soesatyo"));
        daftarPutusan.add(new Putusan("030/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-08-20", "Cristian Gonzales", 45, "Ganja", 200.0, "Pasal 111", "Kurir", 66, 20000000.0, "Chris John"));
        daftarPutusan.add(new Putusan("031/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-09-11", "Deddy Corbuzier", 42, "Sabu-sabu", 5.0, "Pasal 112", "Pengguna", 30, 25000000.0, "Dedi Mulyadi"));
        daftarPutusan.add(new Putusan("032/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-09-22", "Evan Dimas", 26, "Ganja", 120.0, "Pasal 111", "Penyimpan", 40, 8000000.0, "Erick Thohir"));
        daftarPutusan.add(new Putusan("033/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-10-28", "Firman Utina", 38, "Ekstasi", 8.0, "Pasal 112", "Pengguna", 16, 6000000.0, "Fahri Hamzah"));
        daftarPutusan.add(new Putusan("034/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-11-30", "Gading Marten", 37, "Sabu-sabu", 1.1, "Pasal 127", "Pecandu", 8, 0.0, "Gibran Rakabuming"));
        daftarPutusan.add(new Putusan("035/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-10-01", "Hamka Hamzah", 39, "Heroin", 3.0, "Pasal 114", "Pengedar", 100, 800000000.0, "Hatta Rajasa"));
        daftarPutusan.add(new Putusan("036/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-12-25", "Irfan Bachdim", 32, "Ganja", 70.0, "Pasal 111", "Penyimpan", 32, 4000000.0, "Iwan Fals"));
        daftarPutusan.add(new Putusan("037/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-02-18", "Jajang Mulyana", 33, "Sabu-sabu", 0.7, "Pasal 112", "Pengguna", 10, 3000000.0, "Jusuf Kalla"));
        daftarPutusan.add(new Putusan("038/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-11-11", "Kurnia Meiga", 31, "Ekstasi", 12.0, "Pasal 112", "Pengguna", 20, 10000000.0, "Kaesang Pangarep"));
        daftarPutusan.add(new Putusan("039/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-03-17", "Laudya Cynthia Bella", 33, "Sabu-sabu", 0.4, "Pasal 127", "Pecandu", 5, 0.0, "Luhut Panjaitan"));
        daftarPutusan.add(new Putusan("040/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-04-21", "Makan Konate", 29, "Ganja", 400.0, "Pasal 114", "Bandar", 125, 1100000000.0, "Mahfud MD"));
        daftarPutusan.add(new Putusan("041/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-12-12", "Nagita Slavina", 33, "Sabu-sabu", 0.2, "Pasal 127", "Pecandu", 3, 0.0, "Najwa Shihab"));
        daftarPutusan.add(new Putusan("042/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-05-15", "Okto Maniani", 30, "Ekstasi", 25.0, "Pasal 114", "Pengedar", 110, 900000000.0, "Oesman Sapta"));
        daftarPutusan.add(new Putusan("043/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-06-20", "Patrich Wanggai", 33, "Ganja", 90.0, "Pasal 111", "Kurir", 50, 15000000.0, "Prabowo Subianto"));
        daftarPutusan.add(new Putusan("044/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-01-30", "Raffi Ahmad", 34, "Sabu-sabu", 1.8, "Pasal 112", "Pengguna", 19, 9000000.0, "Rano Karno"));
        daftarPutusan.add(new Putusan("045/Pid.Sus/2024/PN Smg", "PN Semarang", "2024-07-25", "Syahrini", 38, "Ekstasi", 7.0, "Pasal 112", "Pengguna", 14, 5000000.0, "Susi Pudjiastuti"));
        daftarPutusan.add(new Putusan("046/Pid.Sus/2024/PN Mks", "PN Makassar", "2024-08-10", "Titus Bonai", 32, "Ganja", 600.0, "Pasal 114", "Bandar", 140, 1300000000.0, "Tito Karnavian"));
        daftarPutusan.add(new Putusan("047/Pid.Sus/2025/PN Sby", "PN Surabaya", "2025-02-28", "Uus", 30, "Sabu-sabu", 0.6, "Pasal 127", "Pecandu", 6, 0.0, "Ulin Yusron"));
        daftarPutusan.add(new Putusan("048/Pid.Sus/2024/PN Jkt", "PN Jakarta Pusat", "2024-09-20", "Vicky Nitinegoro", 37, "Ganja", 180.0, "Pasal 111", "Penyimpan", 55, 18000000.0, "Virgoun"));
        daftarPutusan.add(new Putusan("049/Pid.Sus/2024/PN Bdg", "PN Bandung", "2024-10-25", "Wulan Guritno", 40, "Ekstasi", 3.0, "Pasal 112", "Pengguna", 10, 2000000.0, "Wiranto"));
        daftarPutusan.add(new Putusan("050/Pid.Sus/2025/PN Mdn", "PN Medan", "2025-03-15", "Zaskia Gotik", 31, "Sabu-sabu", 0.5, "Pasal 112", "Pengguna", 12, 5000000.0, "Zainudin Amali"));
    }
}
