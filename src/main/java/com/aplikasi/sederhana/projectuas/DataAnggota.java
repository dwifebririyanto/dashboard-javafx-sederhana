package com.aplikasi.sederhana.projectuas;

public class DataAnggota {
    private int nimAnggota;

    private String namaAnggota;
    private String jkAnggota;
    private String hpAnggota;
    private String prodiAnggota;

    public DataAnggota(int nimAnggota, String namaAnggota, String jkAnggota, String hpAnggota, String prodiAnggota) {
        this.nimAnggota = nimAnggota;
        this.namaAnggota = namaAnggota;
        this.jkAnggota= jkAnggota;
        this.hpAnggota = hpAnggota;
        this.prodiAnggota = prodiAnggota;
    }

    public int getNimAnggota() {
        return nimAnggota;
    }

    public void setNimAnggota(int nimAnggota) {
        this.nimAnggota = nimAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getJkAnggota() {
        return jkAnggota;
    }

    public void setJkAnggota(String jkAnggota) {
        this.jkAnggota = jkAnggota;
    }

    public String getHpAnggota() {
        return hpAnggota;
    }

    public void setHpAnggota(String hpAnggota) {
        this.hpAnggota = hpAnggota;
    }

    public String getProdiAnggota() {
        return prodiAnggota;
    }

    public void setProdiAnggota(String prodiAnggota) {
        this.prodiAnggota = prodiAnggota;
    }
}
