package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Manage;

public class DetailController {

    @FXML
    private Label kodeLabel;
    @FXML
    private Label namaLabel;
    @FXML
    private Label jenisLabel;

    @FXML
    private Label hargaLabel, pesanLabel;
    @FXML
    private ImageView gambarView;
    private Navigator navigator;

    public void setData(Navigator navigator, Manage p) {
        this.navigator = navigator;
        kodeLabel.setText(p.getKode());
        namaLabel.setText(p.getProduk().getNamaProduk());
        jenisLabel.setText(p.getJenis());
        hargaLabel.setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID")).format(p.getProduk().getHarga()));
        if (p.getGambarUri() != null) {
            Image image = new Image(p.getGambarUri(), 640, 480, true, true);
            if (image.isError()) {
                pesanLabel.setText("Lampiran tidak ditemukan atau tidak dapat dibaca.");
            } else {
                gambarView.setImage(image);
            }
        } else {
            pesanLabel.setText("Tanpa lampiran gambar.");
        }
    }

    @FXML
    private void tambahLagi() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }
}
