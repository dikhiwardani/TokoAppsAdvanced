package kelas.controller;

import java.io.IOException;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Manage;

public class DaftarController {

    @FXML
    private TableView<Manage> tabel;
    @FXML
    private TableColumn<Manage, String> kodeCol;
    @FXML
    private TableColumn<Manage, String> namaCol;
    @FXML
    private TextField cariField;
    @FXML
    private ComboBox<String> filterJenisBox;
    private CheckBox totalCheck;
    private CheckBox jumlahCheck;
    @FXML
    private Label pesanLabel;
    private Navigator navigator;
    private DataProduk data;
    private final ObservableList<Manage> dataTampilan
            = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Manage, String> kateCol;
    @FXML
    private TableColumn<Manage, Long> hargaCol;
    @FXML
    private void initialize() {
        // KOLOM KODE
        PropertyValueFactory<Manage, String> sumberKode
                = new PropertyValueFactory<Manage, String>("kode");

        kodeCol.setCellValueFactory(sumberKode);

        // KOLOM NAMA PRODUK
        PropertyValueFactory<Manage, String> sumberNama
                = new PropertyValueFactory<Manage, String>("namaProduk");

        namaCol.setCellValueFactory(sumberNama);

        // KOLOM JENIS Makanan
        PropertyValueFactory<Manage, String> sumberJenis
                = new PropertyValueFactory<Manage, String>("jenis");

        kateCol.setCellValueFactory(sumberJenis);

        // KOLOM TOTAL
        PropertyValueFactory<Manage, Long> sumberHarga
                = new PropertyValueFactory<Manage, Long>("harga");

        hargaCol.setCellValueFactory(sumberHarga);

        filterJenisBox.getItems().add("Semua");
        filterJenisBox.getItems().add("Makanan");
        filterJenisBox.getItems().add("Minuman");
        filterJenisBox.setValue("Semua");

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada data yang sesuai."));
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {
        if (data == null) {
            return;
        }
        dataTampilan.clear();
        String kata = cariField.getText().trim().toLowerCase(Locale.ROOT);
        String jenisDipilih = filterJenisBox.getValue();

        for (Manage prdk : data.getDaftar()) {
            String kode = prdk.getKode().toLowerCase(Locale.ROOT);
            String nama = prdk.getNamaProduk().toLowerCase(Locale.ROOT);
            boolean cocokKata = false;
            boolean cocokJenis = false;

            if (kode.contains(kata) || nama.contains(kata)) {
                cocokKata = true;
            }
            if ("Semua".equals(jenisDipilih)) {
                cocokJenis = true;
            } else if (prdk.getJenis().equals(jenisDipilih)) {
                cocokJenis = true;
            }
            if (cocokKata && cocokJenis) {
                dataTampilan.add(prdk);
            }
        }
        tabel.sort();
        pesanLabel.setText("Jumlah data yang tampil: " + dataTampilan.size());
    }

    @FXML
    private void resetPencarian() {
        cariField.clear();
        filterJenisBox.setValue("Semua");
        cari();
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        Manage produk = tabel.getSelectionModel().getSelectedItem();
        if (produk == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        try {
            navigator.bukaDetail(produk);
        } catch (IOException e) {
            pesanLabel.setText("Detail gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void hapus() {
        Manage pembelian = tabel.getSelectionModel().getSelectedItem();
        if (pembelian == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION,
                "Hapus " + pembelian.getKode() + "?",
                ButtonType.YES, ButtonType.NO);
        dialog.initOwner(tabel.getScene().getWindow());
        ButtonType jawaban = dialog.showAndWait().orElse(ButtonType.NO);
        if (jawaban == ButtonType.YES) {
            data.hapus(pembelian);
            cari();
        }
    }
}
