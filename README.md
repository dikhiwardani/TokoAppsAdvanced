# 🛒 Toko App Advance

Aplikasi desktop berbasis **JavaFX** untuk mengelola stok produk toko: menambah produk beserta foto, melihat detailnya, serta mencari, memfilter, dan menghapus data pada tabel daftar produk.

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)

---

## 📑 Daftar Isi

- [Fitur](#-fitur)
- [Tampilan Aplikasi](#-tampilan-aplikasi)
- [Teknologi](#-teknologi)
- [Struktur Project](#-struktur-project)
- [Prasyarat](#-prasyarat)
- [Cara Menjalankan](#-cara-menjalankan)
- [Panduan Penggunaan](#-panduan-penggunaan)
- [Catatan Penting](#-catatan-penting)
- [Pengembang](#-pengembang)

---

## ✨ Fitur

- **Tambah produk baru** dengan nama, jenis (Makanan / Minuman), harga, dan foto.
- **Validasi input**: nama wajib diisi, harga harus bilangan bulat positif, foto hanya PNG/JPEG maksimal 5 MB.
- **Kode produk otomatis** dengan format `PR-001`, `PR-002`, dan seterusnya.
- **Halaman detail** yang menampilkan kode, nama, jenis, harga (format Rupiah), dan foto produk.
- **Daftar produk** dalam tabel dengan fitur:
  - pencarian berdasarkan kode atau nama,
  - filter berdasarkan jenis produk,
  - hapus data dengan dialog konfirmasi.

## 🖼️ Tampilan Aplikasi

### 1. Form Tambah Produk

Halaman utama untuk memasukkan produk baru.

![Form Tambah Produk](docs/screenshots/form.png)

### 2. Daftar Produk

Tabel produk dengan fitur cari, filter, tambah, lihat detail, dan hapus.

![Daftar Produk](docs/screenshots/daftar.png)

### 3. Detail Produk

Rincian produk yang baru disimpan atau yang dipilih dari daftar.

![Detail Produk](docs/screenshots/detail.png)

## 🧰 Teknologi

| Komponen | Versi |
| --- | --- |
| Java (JDK) | 17 atau lebih baru |
| JavaFX (`controls`, `fxml`) | 21 |
| Apache Maven | 3.8+ |
| javafx-maven-plugin | 0.0.8 |

## 📂 Struktur Project

```text
TokoAppAdvance/
├── contoh-gambar/
│   └── lampiran-latihan.png        # Gambar contoh untuk uji coba
├── docs/
│   └── screenshots/                # Screenshot untuk README
├── src/main/
│   ├── java/kelas/
│   │   ├── MainApp.java            # Entry point aplikasi
│   │   ├── Navigator.java          # Pengatur perpindahan halaman
│   │   ├── controller/
│   │   │   ├── FormController.java
│   │   │   ├── DaftarController.java
│   │   │   └── DetailController.java
│   │   ├── data/
│   │   │   └── DataPembelian.java  # Penyimpanan data di memori
│   │   └── model/
│   │       ├── Manage.java
│   │       └── Produk.java
│   └── resources/kelas/
│       ├── form.fxml
│       ├── daftar.fxml
│       ├── detail.fxml
│       └── styles/app.css
├── nbactions.xml
└── pom.xml
```

## ✅ Prasyarat

Pastikan perangkat sudah terpasang:

1. **JDK 17 atau lebih baru**. Cek dengan:
   ```bash
   java -version
   ```
2. **Apache Maven 3.8+**. Cek dengan:
   ```bash
   mvn -version
   ```
3. **Git** (untuk meng-clone repository).

> JavaFX tidak perlu diunduh manual karena sudah diatur sebagai dependency Maven.

## 🚀 Cara Menjalankan

### Opsi 1: Lewat terminal (Maven)

```bash
# 1. Clone repository
git clone https://github.com/USERNAME/TokoAppAdvance.git

# 2. Masuk ke folder project
cd TokoAppAdvance

# 3. Jalankan aplikasi
mvn clean javafx:run
```

Saat pertama kali dijalankan, Maven akan mengunduh dependency sehingga prosesnya butuh koneksi internet dan waktu sedikit lebih lama.

### Opsi 2: Lewat NetBeans

1. Buka **File → Open Project**, lalu pilih folder `TokoAppAdvance`.
2. Klik kanan project, pilih **Run** (atau tekan `F6`).

### Opsi 3: Lewat IntelliJ IDEA / VS Code

1. Buka folder project sebagai **Maven project**.
2. Jalankan perintah `javafx:run` dari panel Maven, atau jalankan class `kelas.MainApp`.

## 📖 Panduan Penggunaan

1. **Tambah produk**: isi *Nama produk*, pilih *Jenis produk*, isi *Harga Produk* (angka saja, contoh `300000`), lalu klik **Pilih Gambar** untuk menambahkan foto (opsional). Klik **Simpan dan Lihat Detail**.
2. **Lihat detail**: setelah disimpan, aplikasi langsung membuka halaman detail produk.
3. **Kelola daftar**: klik **Lihat Daftar** untuk membuka tabel produk.
   - Ketik kode atau nama pada kolom pencarian, lalu klik **Cari**.
   - Pilih jenis pada filter untuk mempersempit hasil, klik **Reset** untuk mengembalikan tampilan.
   - Pilih satu baris, lalu klik **Lihat Detail** atau **Hapus**.
4. Gambar contoh untuk uji coba tersedia di folder `contoh-gambar/`.

## ⚠️ Catatan Penting

- Data produk disimpan **di memori (in-memory)**, sehingga seluruh data akan hilang ketika aplikasi ditutup.
- Foto produk hanya dibaca dari **file lokal** dan tidak diunggah ke server.
- Project ini sudah menyertakan dependency `mysql-connector-java`, tetapi belum digunakan pada versi saat ini.

## 👤 Pengembang

Dibuat oleh **[NAMA KAMU](https://github.com/USERNAME)**.
