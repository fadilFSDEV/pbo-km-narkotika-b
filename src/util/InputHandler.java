package util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class untuk menangani dan memvalidasi semua jenis input dari pengguna.
 * Mencegah program crash karena input yang tidak valid.
 */
public class InputHandler {

    /**
     * Meminta pengguna memasukkan pilihan menu (integer) dalam rentang tertentu.
     * Akan terus meminta hingga input valid.
     * @param prompt Pesan yang ditampilkan ke pengguna.
     * @param min Nilai minimum yang diterima.
     * @param max Nilai maksimum yang diterima.
     * @param sc Objek Scanner untuk membaca input.
     * @return Integer pilihan yang valid.
     */
    public static int validasiPilihan(String prompt, int min, int max, Scanner sc) {
        int pilihan = -1;
        while (true) {
            try {
                System.out.print(prompt);
                pilihan = sc.nextInt();
                if (pilihan >= min && pilihan <= max) {
                    sc.nextLine(); // Membersihkan buffer setelah nextInt()
                    return pilihan;
                } else {
                    System.out.println("[ERROR] Pilihan tidak valid. Harap masukkan angka antara " + min + " dan " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid. Harap masukkan sebuah angka.");
                sc.next(); // Membersihkan input yang salah dari buffer
            }
        }
    }

    /**
     * Meminta pengguna memasukkan sebuah integer.
     * Akan terus meminta hingga input valid.
     * @param prompt Pesan yang ditampilkan ke pengguna.
     * @param sc Objek Scanner untuk membaca input.
     * @return Integer yang valid.
     */
    public static int validasiInt(String prompt, Scanner sc) {
        int nilai = 0;
        while (true) {
            try {
                System.out.print(prompt);
                nilai = sc.nextInt();
                sc.nextLine(); // Membersihkan buffer setelah nextInt()
                return nilai;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid. Harap masukkan sebuah angka (integer).");
                sc.next(); // Membersihkan input yang salah dari buffer
            }
        }
    }

    /**
     * Meminta pengguna memasukkan sebuah double.
     * Akan terus meminta hingga input valid.
     * @param prompt Pesan yang ditampilkan ke pengguna.
     * @param sc Objek Scanner untuk membaca input.
     * @return Double yang valid.
     */
    public static double validasiDouble(String prompt, Scanner sc) {
        double nilai = 0.0;
        while (true) {
            try {
                System.out.print(prompt);
                nilai = sc.nextDouble();
                sc.nextLine(); // Membersihkan buffer setelah nextDouble()
                return nilai;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid. Harap masukkan sebuah angka (double).");
                sc.next(); // Membersihkan input yang salah dari buffer
            }
        }
    }

    /**
     * Meminta pengguna memasukkan sebuah String.
     * Memastikan String yang dimasukkan tidak kosong.
     * @param prompt Pesan yang ditampilkan ke pengguna.
     * @param sc Objek Scanner untuk membaca input.
     * @return String yang tidak kosong.
     */
    public static String validasiString(String prompt, Scanner sc) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("[ERROR] Input tidak boleh kosong.");
            }
        }
    }
}
