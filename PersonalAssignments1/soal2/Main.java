package soal2;
import model.Mahasiswa;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array objek mahasiswa
        Mahasiswa[] daftar = new Mahasiswa[5];

        daftar[0] = new Mahasiswa(
                "Andi Pratama",
                "2440001",
                "Teknik Informatika",
                3.75);

        daftar[1] = new Mahasiswa(
                "Budi Santoso",
                "2440002",
                "Sistem Informasi",
                3.40);

        daftar[2] = new Mahasiswa(
                "Citra Lestari",
                "2440003",
                "Teknik Informatika",
                3.90);

        daftar[3] = new Mahasiswa(
                "Joni Suhartono",
                "2440004",
                "Teknik Industri",
                3.00);

        daftar[4] = new Mahasiswa(
                "Bulan Suci",
                "2440005",
                "Akuntansi",
                3.20);

        // Input NIM yang ingin diupdate
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimCari = input.nextLine();

        boolean ditemukan = false;

        // Mencari mahasiswa berdasarkan NIM
        for (int i = 0; i < daftar.length; i++) {

            if (daftar[i].getNim().equals(nimCari)) {

                System.out.print("Masukkan IPK baru: ");
                double ipkBaru = input.nextDouble();

                // Memperbarui IPK
                daftar[i].updateIpk(ipkBaru);

                System.out.println("\nData berhasil diperbarui!");

                System.out.println("\n=== Data Mahasiswa ===");
                daftar[i].tampilkanInfo();

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }

        input.close();
    }
}