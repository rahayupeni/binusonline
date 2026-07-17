import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Class untuk menyimpan data pelanggan
class Pelanggan {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;

    public Pelanggan(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
    }
}

// Class utama
public class SistemKasir {

    // Queue untuk antrean pelanggan (FIFO)
    private Queue<Pelanggan> antrean = new LinkedList<>();

    // Stack untuk riwayat transaksi (LIFO)
    private Stack<Pelanggan> riwayat = new Stack<>();

    // ==========================
    // Method Tambah Antrian
    // ==========================
    public void tambahAntrian(String nomor, String nama, double total) {

        Pelanggan pelanggan = new Pelanggan(nomor, nama, total);

        antrean.offer(pelanggan);

        System.out.println("Pelanggan berhasil ditambahkan ke antrean.");
    }

    // ==========================
    // Method Layani Pelanggan
    // ==========================
    public void layaniPelanggan() {

        if (antrean.isEmpty()) {
            System.out.println("Tidak ada pelanggan dalam antrean.");
            return;
        }

        // Mengambil pelanggan pertama dari antrean
        Pelanggan pelanggan = antrean.poll();

        // Menyimpan ke riwayat transaksi
        riwayat.push(pelanggan);

        System.out.println("\n=== Pelanggan Dilayani ===");
        System.out.println("Nomor Antrian : " + pelanggan.nomorAntrian);
        System.out.println("Nama          : " + pelanggan.namaPelanggan);
        System.out.println("Total Belanja : Rp " + pelanggan.totalBelanja);

        System.out.println("Transaksi berhasil disimpan.");
    }

    // ==========================
    // Method Tampilkan Antrian
    // ==========================
    public void tampilkanAntrian() {

        if (antrean.isEmpty()) {
            System.out.println("Antrean pelanggan kosong.");
            return;
        }

        System.out.println("\n===== ANTREAN PELANGGAN =====");

        int nomor = 1;

        for (Pelanggan pelanggan : antrean) {

            System.out.println(nomor + ".");
            System.out.println("Nomor Antrian : " + pelanggan.nomorAntrian);
            System.out.println("Nama          : " + pelanggan.namaPelanggan);
            System.out.println("Total Belanja : Rp " + pelanggan.totalBelanja);
            System.out.println("---------------------------");

            nomor++;
        }

        System.out.println("Jumlah Antrean : " + antrean.size());
    }

    // ==========================
    // Method Riwayat Transaksi
    // ==========================
    public void tampilkanRiwayat() {

        if (riwayat.isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("\n===== RIWAYAT TRANSAKSI =====");

        // Menampilkan dari transaksi terbaru
        for (int i = riwayat.size() - 1; i >= 0; i--) {

            Pelanggan pelanggan = riwayat.get(i);

            System.out.println("Nomor Antrian : " + pelanggan.nomorAntrian);
            System.out.println("Nama          : " + pelanggan.namaPelanggan);
            System.out.println("Total Belanja : Rp " + pelanggan.totalBelanja);
            System.out.println("---------------------------");
        }
    }

    // ==========================
    // Main Program
    // ==========================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SistemKasir kasir = new SistemKasir();

        int pilihan;

        do {

            System.out.println("\n===== SISTEM KASIR =====");
            System.out.println("1. Tambah Antrian Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            long start = System.nanoTime();

            switch (pilihan) {

                case 1:

                    System.out.print("Masukkan Nomor Antrian : ");
                    String nomor = input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan : ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Total Belanja : ");
                    double total = input.nextDouble();
                    input.nextLine();

                    kasir.tambahAntrian(nomor, nama, total);

                    break;

                case 2:

                    kasir.layaniPelanggan();

                    break;

                case 3:

                    kasir.tampilkanAntrian();

                    break;

                case 4:

                    kasir.tampilkanRiwayat();

                    break;

                case 5:

                    System.out.println("Program selesai.");

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");
            }

            long end = System.nanoTime();

            System.out.println("Waktu eksekusi : " + (end - start) + " ns");

        } while (pilihan != 5);

        input.close();
    }
}