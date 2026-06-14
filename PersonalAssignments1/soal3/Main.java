package soal3;
import model.Mahasiswa;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

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
                2.85);

        // Menampilkan seluruh data mahasiswa
        System.out.println("=== Data Mahasiswa ===\n");

        for (Mahasiswa mhs : daftar) {
            mhs.tampilkanInfo();
        }

        input.close();
    }
}