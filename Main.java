public class Main {

    public static void main(String[] args) {

        // Membuat array untuk menyimpan 5 objek Mahasiswa
        Mahasiswa[] daftar = new Mahasiswa[5];

        // Membuat 5 objek mahasiswa dengan data berbeda
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

        // Menampilkan seluruh data mahasiswa menggunakan loop
        System.out.println("=== Data Mahasiswa ===");

        for (int i = 0; i < daftar.length; i++) {
            daftar[i].tampilkanInfo();
        }
    }
}