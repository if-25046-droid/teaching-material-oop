package hy.material8database;

import hy.material8database.models.Mahasiswa;
import hy.material8database.repository.MahasiswaRepository;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner scanner = new Scanner(System.in);

    public App() {
        menuUtama();
    }

    private void menuUtama() {
        int pilih;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Jurusan");
            System.out.println("3. Matakuliah");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    menuMahasiswa();
                    break;
                case 2:
                    menuJurusan();
                    break;
                case 3:
                    menuMatakuliah();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
        
    }

    private int bacaAngka() {
        try {
            int angka = Integer.parseInt(scanner.nextLine());
            return angka;
        }catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            return -1;
        }
    }
    private void menuMahasiswa() {
        int pilih;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Lihat Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa Baru");
            System.out.println("3. Edit Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Ambil Matakuliah Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    printAllMahasiswa();
                    break;
                case 2:
                    addNewMahasiswa();
                    break;
                case 3:
                    System.out.println("Fitur edit mahasiswa belum tersedia.");
                    break;
                case 4:
                    System.out.println("Fitur hapus mahasiswa belum tersedia.");
                    break;
                case 5:
                    System.out.println("Fitur ambil matakuliah mahasiswa belum tersedia.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    private void printAllMahasiswa() {
        List<Mahasiswa> allMahasiswa = 
                MahasiswaRepository.getAllMahasiswa();

        System.out.println("\n===== Daftar Mahasiswa:=====");
        if (allMahasiswa.isEmpty()) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
            return;
        }
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nim + " - " + m.nama);
        }
    }

    private void addNewMahasiswa() {

        System.out.println("\n=== Tambah Mahasiswa Baru ===");

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        Mahasiswa Mahasigma = new Mahasiswa(nim, nama, kodeJurusan);
        MahasiswaRepository.addMahasiswa(Mahasigma);

        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void menuJurusan() {
        int pilih;
        do {
              System.out.println("\n=== Menu Jurusan ===");
            System.out.println("1. Lihat Semua Jurusan");
            System.out.println("2. Tambah Jurusan Baru");
            System.out.println("3. Edit Jurusan");
            System.out.println("4. Hapus Jurusan");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    System.out.println("Fitur lihat semua jurusan belum tersedia.");
                    break;
                case 2:
                    System.out.println("Fitur tambah jurusan baru belum tersedia.");
                    break;
                case 3:
                    System.out.println("Fitur edit jurusan belum tersedia.");
                    break;
                case 4:
                    System.out.println("Fitur hapus jurusan belum tersedia.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    private void menuMatakuliah() {
        int pilih;
        do {
            System.out.println("\n=== Menu Matakuliah ===");
            System.out.println("1. Lihat Semua Matakuliah");
            System.out.println("2. Tambah Matakuliah Baru");
            System.out.println("3. Edit Matakuliah");
            System.out.println("4. Hapus Matakuliah");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka();

            switch (pilih) {
                case 1:
                    System.out.println("Fitur lihat semua matakuliah belum tersedia.");
                    break;
                case 2:
                    System.out.println("Fitur tambah matakuliah baru belum tersedia.");
                    break;
                case 3:
                    System.out.println("Fitur edit matakuliah belum tersedia.");
                    break;
                case 4:
                    System.out.println("Fitur hapus matakuliah belum tersedia.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }
    public static void main(String[] args) {
        new App();
    }
}
