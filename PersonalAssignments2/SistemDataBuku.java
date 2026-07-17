import java.util.Scanner;

// Class Node untuk menyimpan data buku
class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next;

    // Constructor Node
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

// Class utama
public class SistemDataBuku {

    // Head sebagai awal Single Linked List
    private Node head = null;

    // Menyimpan jumlah buku
    private int jumlahBuku = 0;

    // ==========================
    // Method Tambah Buku (Push)
    // ==========================
    public void tambahBuku(String kodeBuku, String judul, String penulis) {

        // Validasi kode buku maksimal 5 karakter
        if (kodeBuku.length() > 5) {
            System.out.println("Kode buku maksimal 5 karakter.");
            return;
        }

        // Membuat node baru
        Node bukuBaru = new Node(kodeBuku, judul, penulis);

        // Jika linked list masih kosong
        if (head == null) {
            head = bukuBaru;
        } else {

            // Mencari node terakhir
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            // Menambahkan node baru di akhir
            current.next = bukuBaru;
        }

        jumlahBuku++;

        System.out.println("Data berhasil ditambahkan!");
    }

    // ==========================
    // Method Hapus Buku (Pop)
    // ==========================
    public void hapusBuku() {

        // Jika linked list kosong
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        // Jika hanya ada satu buku
        if (head.next == null) {

            System.out.println("Buku \"" + head.judul + "\" berhasil dihapus.");

            head = null;
            jumlahBuku--;

            return;
        }

        // Mencari node sebelum node terakhir
        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        System.out.println("Buku \"" + current.next.judul + "\" berhasil dihapus.");

        current.next = null;

        jumlahBuku--;
    }

    // ==========================
    // Method Cari Buku
    // ==========================
    public void cariBuku(String kodeBuku) {

        Node current = head;

        while (current != null) {

            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {

                System.out.println("\n===== DATA BUKU =====");
                System.out.println("Kode Buku : " + current.kodeBuku);
                System.out.println("Judul     : " + current.judul);
                System.out.println("Penulis   : " + current.penulis);

                return;
            }

            current = current.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // ==========================
    // Method Tampilkan Semua Buku
    // ==========================
    public void tampilkanSemuaBuku() {

        if (head == null) {
            System.out.println("Belum ada data buku.");
            return;
        }

        Node current = head;

        System.out.println("\n===== DAFTAR BUKU =====");

        while (current != null) {

            System.out.println("Kode     : " + current.kodeBuku);
            System.out.println("Judul    : " + current.judul);
            System.out.println("Penulis  : " + current.penulis);
            System.out.println("-----------------------------");

            current = current.next;
        }

        System.out.println("Total Buku : " + jumlahBuku);
    }

    // ==========================
    // Main Program
    // ==========================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Membuat objek perpustakaan
        SistemDataBuku perpustakaan = new SistemDataBuku();

        int pilihan;

        do {

            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan newline

            long start = System.nanoTime();

            switch (pilihan) {

                case 1:

                    System.out.print("Masukkan Kode Buku : ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan Judul      : ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan Penulis    : ");
                    String penulis = input.nextLine();

                    perpustakaan.tambahBuku(kode, judul, penulis);

                    break;

                case 2:

                    perpustakaan.hapusBuku();

                    break;

                case 3:

                    System.out.print("Masukkan Kode Buku : ");
                    String cari = input.nextLine();

                    perpustakaan.cariBuku(cari);

                    break;

                case 4:

                    perpustakaan.tampilkanSemuaBuku();

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