package controller;

import model.ProgramSosial;
import model.ProgramDonasi;
import model.ProgramEdukasi;
import model.Relawan;
import view.KaryarasaView;
import java.util.ArrayList;
import java.util.Scanner;


public class KaryarasaController {
    private ArrayList<ProgramSosial> daftarProgram;
    private Scanner scanner;
    private KaryarasaView view;

    public KaryarasaController(Scanner scanner, KaryarasaView view) {
        this.daftarProgram = new ArrayList<>();
        this.scanner = scanner;
        this.view = view;
        muatDataAwal();
    }

    // Dummy data awal
    private void muatDataAwal() {
        Relawan relawan1 = new Relawan("Siti Amara", "0812-3456-7890",
                "Komunitas Peduli Kasih", "Ketua Relawan");
        ProgramDonasi donasiAwal = new ProgramDonasi(
                "PD001", "Donasi Pangan Ramadhan",
                "Membantu warga terdampak kekurangan pangan",
                50, "Lokal", 5000000, relawan1,
                "Sembako", 10000000);
        daftarProgram.add(donasiAwal);

        Relawan relawan2 = new Relawan("Budi Santoso", "0813-1122-3344",
                "Yayasan Cerdas Bangsa", "Koordinator Program");
        ProgramEdukasi edukasiAwal = new ProgramEdukasi(
                "PE001", "Pelatihan Literasi Digital",
                "Meningkatkan kemampuan digital anak muda",
                30, "Nasional", 7500000, relawan2,
                6, "Dasar-dasar Internet & Keamanan Data");
        daftarProgram.add(edukasiAwal);
    }

    public void tambahProgram() {
        view.tampilkanPesan("\n--- 1. INFORMASI PENGAJU / RELAWAN ---");
        System.out.print("Nama Pengaju       : ");
        String nama = scanner.nextLine();
        System.out.print("Kontak (No HP/WA)  : ");
        String kontak = scanner.nextLine();
        System.out.print("Asal Lembaga       : ");
        String asalLembaga = scanner.nextLine();
        System.out.print("Jabatan di Lembaga : ");
        String jabatan = scanner.nextLine();
        Relawan pengajuBaru = new Relawan(nama, kontak, asalLembaga, jabatan);

        view.tampilkanPesan("\n--- 2. DETAIL PROGRAM SOSIAL ---");
        String idProgram = mintaIdUnik();
        System.out.print("Nama Program       : ");
        String namaProgram = scanner.nextLine();
        System.out.print("Tujuan Program     : ");
        String tujuan = scanner.nextLine();
        int jumlahPeserta = mintaAngkaInt("Jumlah Peserta     : ");
        System.out.print("Skala Program (cth: Lokal/Nasional): ");
        String skala = scanner.nextLine();
        double anggaran = mintaAngkaDouble("Anggaran (Rp)      : ");

        System.out.println("\nPilih Jenis Program:");
        System.out.println("1. Program Donasi");
        System.out.println("2. Program Edukasi");
        int tipe = mintaAngkaIntRentang("Pilihan (1/2)      : ", 1, 2);

        ProgramSosial programBaru;
        if (tipe == 2) {
            int jumlahSesi = mintaAngkaInt("Jumlah Sesi        : ");
            System.out.print("Materi Utama       : ");
            String materi = scanner.nextLine();
            programBaru = new ProgramEdukasi(idProgram, namaProgram, tujuan, jumlahPeserta,
                    skala, anggaran, pengajuBaru, jumlahSesi, materi);
        } else {
            System.out.print("Jenis Barang       : ");
            String jenisBarang = scanner.nextLine();
            double target = mintaAngkaDouble("Target Donasi (Rp) : ");
            programBaru = new ProgramDonasi(idProgram, namaProgram, tujuan, jumlahPeserta,
                    skala, anggaran, pengajuBaru, jenisBarang, target);
        }

        daftarProgram.add(programBaru);
        view.tampilkanPesan("\n>> Program sosial beserta data pengaju berhasil ditambahkan!");
    }

    public void tampilkanProgram() {
        view.tampilkanDaftarProgram(daftarProgram);
    }

    public void hapusProgram() {
        System.out.print("Masukkan ID Program yang akan dihapus: ");
        String idTarget = scanner.nextLine();

        ProgramSosial programHapus = null;

        for (ProgramSosial p : daftarProgram) {
            if (p.getIdProgram().equalsIgnoreCase(idTarget)) {
                programHapus = p;
                break;
            }
        }

        if (programHapus != null) {
            daftarProgram.remove(programHapus);
            view.tampilkanPesan(">> Program sosial berhasil dihapus!");
        } else {
            view.tampilkanPesan(">> Program dengan ID tersebut tidak ditemukan.");
        }
    }

    public void updateAnggaran() {
        System.out.print("Masukkan ID Program yang akan diupdate anggarannya: ");
        String idTarget = scanner.nextLine();

        ProgramSosial programDitemukan = null;

        for (ProgramSosial p : daftarProgram) {
            if (p.getIdProgram().equalsIgnoreCase(idTarget)) {
                programDitemukan = p;
                break;
            }
        }

        if (programDitemukan != null) {
            double anggaranBaru = mintaAngkaDouble("Anggaran Baru (Rp): ");
            programDitemukan.setAnggaran(anggaranBaru); 
            view.tampilkanPesan(">> Anggaran program berhasil diperbarui!");
        } else {
            view.tampilkanPesan(">> Program dengan ID tersebut tidak ditemukan.");
        }
    }

    // ==================== Helper Validasi Input ====================

    private String mintaIdUnik() {
        String id;
        while (true) {
            System.out.print("ID Program         : ");
            id = scanner.nextLine();
            if (id == null || id.trim().isEmpty()) {
                System.out.println(">> ERROR: ID Program tidak boleh kosong!");
                continue;
            }
            boolean duplikat = false;
            for (ProgramSosial p : daftarProgram) {
                if (p.getIdProgram().equalsIgnoreCase(id)) {
                    duplikat = true;
                    break;
                }
            }
            if (duplikat) {
                System.out.println(">> ERROR: ID Program sudah digunakan, gunakan ID lain!");
                continue;
            }
            break;
        }
        return id;
    }

    private int mintaAngkaInt(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(">> ERROR: Masukkan harus berupa angka bulat!");
            }
        }
    }

    private int mintaAngkaIntRentang(String label, int min, int max) {
        while (true) {
            int nilai = mintaAngkaInt(label);
            if (nilai >= min && nilai <= max) {
                return nilai;
            }
            System.out.println(">> ERROR: Pilihan harus antara " + min + " dan " + max + "!");
        }
    }

    private double mintaAngkaDouble(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();      
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println(">> ERROR: Masukkan harus berupa angka!");
            }
        }
    }
}