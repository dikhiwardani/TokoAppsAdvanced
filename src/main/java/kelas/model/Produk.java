package kelas.model;

public class Produk {

    private final String namaProduk;
    private final long harga;
    private final String jenis;

    public Produk(String nama, long jumlah, String jenis) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama Produk harus ada");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari nol.");
        }
        this.namaProduk = nama.trim();
        this.harga = jumlah;
        this.jenis = jenis;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public long getHarga() {
        return harga;
    }

    public String getJenis() {
        return jenis;
    }

}
