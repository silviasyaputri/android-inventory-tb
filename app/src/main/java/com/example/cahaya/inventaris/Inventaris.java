package com.example.cahaya.inventaris;

import android.os.Parcel;
import android.os.Parcelable;

public class Inventaris implements Parcelable {

    private String id;
    private String nama;
    private String photo;

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }

    private String gambar_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    private String spesifikasi;
    private String satuan;
    private String kondisi, tahun;
    private String jumlah, harga;

    public Inventaris(String id, String nama, String jumlah, String photo, String spesifikasi, String tahun,
                      String harga, String satuan, String kondisi ) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.photo = photo;
        this.spesifikasi = spesifikasi;
        this.tahun = tahun;
        this.harga = harga;
        this.satuan = satuan;
        this.kondisi = kondisi;
    }

    protected Inventaris(Parcel in) {
        this.id = in.readString();
        this.nama = in.readString();
        this.jumlah = in.readString();
        this.photo = in.readString();
        this.spesifikasi = in.readString();
        this.tahun = in.readString();
        this.harga = in.readString();
        this.satuan = in.readString();
        this.kondisi = in.readString();
    }

    public static final Creator<Inventaris> CREATOR = new Creator<Inventaris>() {
        @Override
        public Inventaris createFromParcel(Parcel in) {
            return new Inventaris(in);
        }

        @Override
        public Inventaris[] newArray(int size) {
            return new Inventaris[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nama);
        dest.writeString(this.jumlah);
        dest.writeString(this.photo);
        dest.writeString(this.spesifikasi);
        dest.writeString(this.tahun);
        dest.writeString(this.harga);
        dest.writeString(this.satuan);
        dest.writeString(this.kondisi);
    }
}
