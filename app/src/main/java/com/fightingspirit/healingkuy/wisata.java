package com.fightingspirit.healingkuy;

// 6 Juli 2022, 10119032, Ginanjar Tubagus Gumilar, IF1
public class wisata {
    private String foto;
    private String lokasi;
    private String nama;
    private String alamat;
    private String lok_lat;
    private String lok_long;

    public wisata() {}

    // Getter and setter method
    public String getFoto()
    {
        return foto;
    }
    public void setFoto(String foto)
    {
        this.foto = foto;
    }
    public String getLokasi()
    {
        return lokasi;
    }
    public void setLokasi(String lokasi)
    {
        this.lokasi = lokasi;
    }
    public String getNama()
    {
        return nama;
    }
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    public String getAlamat()
    {
        return alamat;
    }
    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }
    public String getLok_lat(String lok_lat) {return lok_lat;}
    public void setLok_lat(){this.lok_lat = lok_lat;}
    public String getLok_long(String lok_long){return lok_long;}
    public void setLok_long(){this.lok_long = lok_long;}
}
