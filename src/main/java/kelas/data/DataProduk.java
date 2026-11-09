package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Manage;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<Manage> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Manage> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Manage tambah(Produk produk, String uri) {
        //TR%03d  Bagian ini digunakan untuk membuat kode pembelian, misalnya TR001, TR002, dan seterusnya.
        Manage p = new Manage(String.format("PR-%03d", urutan), produk, uri);
        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(Manage p) {
        daftar.remove(p);
    }
}
