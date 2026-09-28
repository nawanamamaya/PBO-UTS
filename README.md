# UTS PBO

# RIJA AULIA MAYATRI (2509116011)

# Sistem Manajemen Organisasi Social Project Karyarasa

## Deskripsi Singkat Program

Sistem manajemen program social Karyarasa adalah sistem manajemen program sosial yang dikembangkan menggunakan Bahasa Java. 
Program ini dapat membantu mencatat dan mengelola data program sosial (donasi maupun edukasi) beserta data relawan/pengaju yang ingin mengajukan program tersebut.
Melalui sistem ini, pengguna dapat menambahkan program sosial baru, melihat daftar seluruh program yang terdaftar, menghapus program berdasarkan ID, serta memperbarui anggaran suatu program. Setiap program memiliki dua kategor spesifik, yaitu Program Donasi (berfokus pada pengumpulan barang/dana) dan Program Edukasi (berfokus pada pelatihan/sesi pembelajaran), yang di mana keduanya merupakan turunan dari satu program sosial umum.

## Penjelasan Alur Program
**Inisialisasi**

<img width="500" height="97" alt="image" src="https://github.com/user-attachments/assets/cc5f19de-664b-40e3-9ee9-3e8ea244d7e8" />

Inisialisasi program dimulai dari MainApp yang membuat objek scanner, KaryarasaView, dan KaryarasaController. Saat KaryarasaController dibuat, method muatDataAwak() secara otomatis dipanggil untuk mengisi dua data dummy awal, satunya program donasi dan satu program edukasi ke dalam arraylist program social sehingga data langsung tampil tanpa perlu diinput manual.

**Menu Utama**

<img width="410" height="129" alt="image" src="https://github.com/user-attachments/assets/255b56c1-a389-4a46-b139-4a7ef79c9111" />

Pada menu Utama, program menampilkan menu yang akan berulang menggunakan looping while, dengan 5 pilihan. Yaitu, pertama untuk menambah program sosialnya sekaligus mengisi data relawan/pengaju, yang kedua untuk menampilkan daftar program sosial yang sudah terdata, ketiga adalah untuk menghapus program yang sudah terdata, keempat untuk mengupdate atau mengubah data yang sudah tersimpan/terdata, dan yang terakhir adalah untuk keluar dari program berulang atau dari menu Utama. Pada input menu validasi di dalam MainApp sendiri juga menggunakan try-catch agar hanya angka yang diterima (try-catch di dalam Java adalah system pengaman untuk menghadapi kesalahan saat program sedang berjalan. Simpelnya, sistem ini bertugas untuk mendeteksi baris kode yang rusak, menghentikan kerusakan tersebut agar tidak menyebar, dan mengalihkan program ke dalam rencana cadangan yang disiapkan sehingga sistem tidak keluar atau mati secara mendadak).

**Tambah Program (Opsi 1)**

<img width="403" height="99" alt="image" src="https://github.com/user-attachments/assets/e2655994-3ba5-4149-aaab-2be35af67567" />

Pada bagian awal, kita akan diminta untuk mengisi data dari relawan/pengaju itu sendiri beserta asal lembaga dan jabatannya di dalam lembaga.

<img width="707" height="275" alt="image" src="https://github.com/user-attachments/assets/c45b22a1-d2da-4e8a-b061-86aa5fd2f172" />

Setelah itu, baru kita diminta untuk mengisi detail dari data program sosial yang kita ajukan atau ingin data saat ini, beserta dengan targetnya juga. Dan setelah itu, data-data tersebut akan disimpan di dalam ArrayList.

**Tampilkan Program (Opsi 2)**

<img width="481" height="355" alt="image" src="https://github.com/user-attachments/assets/d9bdab6f-5b46-4edd-b1c2-d3b724adb569" />

Dan jika kita memiliki opsi untuk menampilkan data, maka sistem akan menampilkan detail dari data yang sudah kita tambahkan sebelumnya. 

**Hapus Program (Opsi 3)**

<img width="228" height="88" alt="image" src="https://github.com/user-attachments/assets/5a1e6370-c098-4ab5-aa47-9b924ce5a969" />

Pada bagian ini, pengguna memasukkan ID program yang ingin dihapus lalu sistem akan mencari data berdasarkan ID lalu menghapusnya dari ArrayList jika ditemukan.

**Update Anggaran (Opsi 4)**

<img width="303" height="98" alt="image" src="https://github.com/user-attachments/assets/4474ff03-b8b6-4ff1-95b5-231d5bd3975b" />

Pada bagian ini, pengguna memasukkan ID program, lalu memasukkan nilai anggaran baru yang akan divalidasi dan diperbarui melalui setter setAnggaran().

**Keluar Program (Opsi 5)**

<img width="506" height="203" alt="image" src="https://github.com/user-attachments/assets/2c192946-3220-4250-8b33-7c2a425f5ea6" />

Menghentikan looping utama dan mengakhiri program.

## Penjelasan Penerapan Konsep OOP Utama

### **Encapsulation (Enkapsulasi)**

Konsep pembungkusan data dan penyembunyian informasi diterapkan dengan ketat pada setiap kelas Model.
 
**Penerapan Access Modifier**

<img width="317" height="126" alt="image" src="https://github.com/user-attachments/assets/246db77e-7722-4abf-a88e-6c0081a0a7f3" />

<img width="353" height="53" alt="image" src="https://github.com/user-attachments/assets/5e873288-94b4-40b3-bd87-8e223ea662a0" />

<img width="376" height="56" alt="image" src="https://github.com/user-attachments/assets/e5411cc1-afa9-4d4b-afbd-8900e100cebf" />

<img width="265" height="84" alt="image" src="https://github.com/user-attachments/assets/af599a6c-4f01-428f-9aef-55bc99c15c71" />


Atribut pada kelas dibuat tertutup. Pada ProgramSosial menggunakan protected (agar bisa diakses langsung oleh subclass), sedangkan pada kelas lain seperti ProgramDonasi, ProgramEdukasi, dan Relawan menggunakan private.

**Getter dan Setter Bersyarat**

Akses ke atribut-atribut tersebut dijembatani melalui method public getter dan setter. Di dalam setter, terdapat validasi logika bisnis. Contohnya:

<img width="273" height="40" alt="image" src="https://github.com/user-attachments/assets/cd395a29-c2f1-466b-b761-c26b37aef24b" />
<img width="420" height="47" alt="image" src="https://github.com/user-attachments/assets/06fd9aa4-ee64-4c45-bdc2-b2a898bae802" />

Pada setAnggaran() dan setTargetDonasi(), terdapat pengecekan if (anggaran >= 0). Jika pengguna memasukkan angka negatif, sistem akan menolaknya, mencetak pesan error, dan mengatur nilai ke 0.

<img width="406" height="42" alt="image" src="https://github.com/user-attachments/assets/eef47a80-42ca-4983-8466-1feecb996064" />
<img width="353" height="46" alt="image" src="https://github.com/user-attachments/assets/431144b1-5eea-4057-b57b-a488a7861551" />

Pada setNamaProgram() atau setNama(), terdapat pengecekan agar input tidak boleh kosong (null atau empty).

**Inheritance (Pewarisan)**

Sistem menerapkan pewarisan untuk menghindari duplikasi kode pada atribut yang berulang.

<img width="625" height="270" alt="image" src="https://github.com/user-attachments/assets/9bf4db82-5e8d-4e6b-b62b-1633a0341e6c" />

Superclass (Kelas Induk): ProgramSosial. Menyimpan atribut umum yang dimiliki semua program (ID, Nama, Tujuan, Peserta, Skala, Anggaran, dan objek Relawan pengaju).

<img width="644" height="343" alt="image" src="https://github.com/user-attachments/assets/391ea0ac-2993-4d7e-b376-52103e6e847f" />

Subclass (Kelas Anak 1): ProgramDonasi. Mewarisi ProgramSosial dan menambahkan atribut spesifik: jenisBarang dan targetDonasi.

<img width="683" height="384" alt="image" src="https://github.com/user-attachments/assets/5be40ecc-3c8a-42c4-b06d-388d9946ac14" />

Subclass (Kelas Anak 2): ProgramEdukasi. Mewarisi ProgramSosial dan menambahkan atribut spesifik: jumlahSesi dan materiUtama.

Penggunaan super(). Pada constructor masing-masing subclass, kata kunci super(...) digunakan untuk memanggil constructor dari superclass agar atribut utama tetap terinisialisasi dengan benar.

## Penjelasan Nilai Tambah

**Struktur MVC (Model-View-Controller)**

<img width="212" height="67" alt="image" src="https://github.com/user-attachments/assets/4a956db6-e355-471f-9d3c-85fa3195fd35" />

Package model: Berisi blueprint entitas data, yaitu ProgramSosial, ProgramDonasi, ProgramEdukasi, dan Relawan. Package ini murni hanya berisi data dan logika pengaturannya (getter/setter).


<img width="213" height="28" alt="image" src="https://github.com/user-attachments/assets/870d21d9-d307-4ad8-aef4-d258754b5cd4" />

Package view: Berisi KaryarasaView. Bertugas khusus untuk mengurus antarmuka/tampilan konsol (mencetak menu, mencetak pesan, dan menampilkan daftar data). Tidak ada logika pemrosesan data di sini.


<img width="200" height="31" alt="image" src="https://github.com/user-attachments/assets/87524afb-abbf-4f61-9a70-ff67e561500f" />

Package controller: Berisi KaryarasaController. Bertindak sebagai otak program yang menghubungkan View dan Model. Mengatur logika input (Scanner), mengelola koleksi data (ArrayList), melakukan validasi unik, dan memanggil method dari Model atau View.

**Polymorphism (Polimorfisme)**

Program ini menerapkan dua jenis polimorfisme sekaligus

1. Method Overriding (Dynamic Polymorphism):

   <img width="602" height="195" alt="image" src="https://github.com/user-attachments/assets/3343ae61-3d63-478c-a962-623387cbb7e4" />

   Method tampilkanInfo() yang ada di superclass ProgramSosial ditimpa (override) oleh subclass ProgramDonasi dan ProgramEdukasi. Saat method ini dipanggil, masing-masing subclass memanggil super.tampilkanInfo() untuk mencetak data umum terlebih dahulu, lalu mencetak data spesifiknya.

   - Dynamic Method Dispatch terjadi pada kelas View. Meskipun ArrayList bertipe <ProgramSosial>, saat perulangan memanggil daftarProgram.get(i).tampilkanInfo(), Java secara dinamis akan menjalankan method milik ProgramDonasi atau ProgramEdukasi sesuai dengan wujud asli objek tersebut saat di-instantiate.
     
2. Method Overloading (Static Polymorphism):

   <img width="562" height="336" alt="image" src="https://github.com/user-attachments/assets/99024e32-edba-42fb-94ea-bb498b7a2e46" />

   Pada kelas ProgramSosial, terdapat dua method dengan nama yang sama namun parameter yang berbeda:
   - tampilkanInfo(): Menampilkan data secara lengkap.
   - tampilkanInfo(boolean ringkas): Jika diisi true, hanya akan menampilkan ID, Nama Program, dan Skala saja. (Berguna jika ke depannya butuh menampilkan list dengan tampilan minimalis).

