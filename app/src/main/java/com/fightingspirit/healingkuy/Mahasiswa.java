package com.fightingspirit.healingkuy;

// 6 Juli 2022, 10119002, Firman Sahita, IF1
public class Mahasiswa {
    private String mNim;
    private String mNama;
    private int mPic;

    public Mahasiswa(String nim, String nama, int pic) {
        mNim = nim;
        mNama = nama;
        mPic = pic;
    }

    public String getNim() {
        return mNim;
    }

    public String getNama() {
        return mNama;
    }

    public int getPic() {
        return mPic;
    }
}
