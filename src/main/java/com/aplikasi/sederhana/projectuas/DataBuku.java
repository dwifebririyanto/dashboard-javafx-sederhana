package com.aplikasi.sederhana.projectuas;

public class DataBuku {

    private int idBuku;

    private String judulBuku;
    private String genreBuku;
    private String penulisBuku;
    private String tahunBuku;

    public DataBuku(int idBuku, String judulBuku, String genreBuku, String penulisBuku, String tahunBuku) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.genreBuku = genreBuku;
        this.penulisBuku = penulisBuku;
        this.tahunBuku = tahunBuku;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getGenreBuku() {
        return genreBuku;
    }

    public void setGenreBuku(String genreBuku) {
        this.genreBuku = genreBuku;
    }

    public String getPenulisBuku() {
        return penulisBuku;
    }

    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku = penulisBuku;
    }

    public String getTahunBuku() {
        return tahunBuku;
    }

    public void setTahunBuku(String tahunBuku) {
        this.tahunBuku = tahunBuku;
    }
}
