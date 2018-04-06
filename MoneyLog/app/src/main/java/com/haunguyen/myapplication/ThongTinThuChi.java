package com.haunguyen.myapplication;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Hau Nguyen on 02-Apr-18.
 */

public class ThongTinThuChi implements Serializable {
    private String noidung;
    private String sotien;
    private boolean hinhthuc;
    private String date;

    public ThongTinThuChi() {
        this.noidung = noidung;
        this.sotien = sotien;
        this.hinhthuc = hinhthuc;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public boolean isHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(boolean hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateFormat(String d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }
    @Override
    public String toString() {
        return "Nội dung: " + this.noidung + "\n" + "Số tiền: " + this.sotien + "\n" + "Hình thức: " + ((this.hinhthuc == true) ? "Thu" : "Chi") + "\n" + "Ngày: " + this.date;
    }
}
