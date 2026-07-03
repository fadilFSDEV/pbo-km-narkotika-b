# KMS Putusan Pengadilan Narkotika

## Deskripsi Proyek
Proyek ini adalah Knowledge Management System (KMS) untuk mengelola putusan pengadilan pidana narkotika di Indonesia. Dibangun menggunakan bahasa Java (JDK 11+) dengan menerapkan arsitektur MVC (Model-View-Controller) dan prinsip-prinsip Pemrograman Berorientasi Objek (OOP) seperti enkapsulasi, polimorfisme, dan pewarisan.

---

## Cara Setup dan Menjalankan

Ada beberapa cara untuk menjalankan proyek ini.

### Cara A: Clone Langsung dari IntelliJ IDEA (Paling Mudah)

1.  **Buka IntelliJ IDEA.**
2.  Jika Anda berada di layar selamat datang, klik **Get from VCS**. Jika proyek lain terbuka, pilih **File > New > Project from Version Control**.
3.  Salin dan tempel URL repository berikut ke dalam kolom URL:
    ```
    https://github.com/fadilFSDEV/pbo-km-narkotika-b.git
    ```
4.  Klik **Clone**. IntelliJ IDEA akan secara otomatis mengunduh dan membuka proyek.
5.  Setelah proyek terbuka, cari file `src/app/Main.java`, klik kanan, dan pilih **Run 'Main.main()'**.

### Cara B: Clone Manual, Buka dengan IntelliJ IDEA

1.  **Clone via Terminal:** Buka terminal dan jalankan perintah:
    ```bash
    git clone https://github.com/fadilFSDEV/pbo-km-narkotika-b.git
    ```
2.  **Buka Proyek di IDE:**
    - Buka IntelliJ IDEA, pilih **File > Open...**
    - Arahkan dan pilih folder `pbo-km-narkotika-b` yang baru saja di-clone.
3.  **Jalankan Aplikasi:**
    - Cari file `src/app/Main.java`, klik kanan, dan pilih **Run 'Main.main()'**.

### Cara C: Melalui Command Line (Terminal)

1.  **Clone via Terminal:**
    ```bash
    git clone https://github.com/fadilFSDEV/pbo-km-narkotika-b.git
    cd pbo-km-narkotika-b
    ```
2.  **Kompilasi:** Pindah ke direktori `src` dan jalankan perintah kompilasi.
    ```bash
    cd src
    javac model/*.java controller/*.java view/*.java util/*.java app/*.java
    ```
3.  **Jalankan:**
    ```bash
    java app.Main
    ```

---

## Video Demo Aplikasi
(https://youtu.be/PSSWF9nA_rw?si=Ups49HfXpG-DZhja)

## Anggota Kelompok
- Muhammad Habib Fadillah - 202510370110034 - Kelas B (Peran: Knowledge/Database Engineer - Branch: feature/model)
- M. Rasyiduta Prasetya - 202510370110042 - Kelas B (Peran: GUI Designer/View Developer - Branch: feature/view)
- Moch.Janata Djava Nur Saputra - 202510370110044 - Kelas B (Peran: Backend Developer/Controller Engineer - Branch: feature/controller)
