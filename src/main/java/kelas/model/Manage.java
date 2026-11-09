package kelas.model;

public class Manage {

    private final String kode;
    private final Produk produk;
    private final String gambarUri;

    public Manage(String kode, Produk produk, String gambarUri) {
        if (kode == null || kode.isBlank() || produk == null) {
            throw new IllegalArgumentException("Data produk tidak lengkap.");
        }
        this.kode = kode;
        this.produk = produk;
        this.gambarUri = gambarUri;
    }

    public String getKode() {
        return kode;
    }

    public Produk getProduk() {
        return produk;
    }

    public String getGambarUri() {
        return gambarUri;
    }

    public String getJenis() {
        return produk.getJenis();
    }

    public String getNamaProduk() {
        return produk.getNamaProduk();
    }

    public long getHarga() {
        return produk.getHarga();
    }

}
