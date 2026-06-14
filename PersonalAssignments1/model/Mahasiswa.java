package model;

// Class Mahasiswa
public class Mahasiswa {

    // Atribut private
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;


    // Constructor untuk menginisialisasi data mahasiswa
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter NIM
    public String getNim() {
        return nim;
    }

    // Getter IPK
    public double getIpk() {
        return ipk;
    }

    // Setter IPK
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Method untuk update IPK
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // Method cek kelulusan
    public String cekKelulusan() {
        if (ipk >= 3.00) {
            return "Lulus";
        } else {
            return "Belum Lulus";
        }
    }

    // Method menentukan predikat akademik
    public String hitungPredikat() {

        if (ipk >= 3.75) {
            return "Dengan Pujian";
        } else if (ipk >= 3.50) {
            return "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }

    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.println("IPK      : " + ipk);
        System.out.println("Status   : " + cekKelulusan());
        System.out.println("Predikat  : " + hitungPredikat());
        System.out.println();
    }
}