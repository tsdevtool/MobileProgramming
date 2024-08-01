package com.crissiiu.nguyenhuycuong.models;

import java.util.ArrayList;
import java.util.List;

public class MonHoc {
    public String getTenHinh() {
        return tenHinh;
    }

    public void setTenHinh(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "tenHinh='" + tenHinh + '\'' +
                ", maHP='" + maHP + '\'' +
                ", tenHP='" + tenHP + '\'' +
                ", tenGV='" + tenGV + '\'' +
                '}';
    }

    private String tenHinh;
    private String maHP;
    private String tenHP;
    private String tenGV;

    public MonHoc(String tenHinh, String maHP, String tenGV, String tenHP) {
        this.tenHinh = tenHinh;
        this.maHP = maHP;
        this.tenGV = tenGV;
        this.tenHP = tenHP;
    }

    public static List<MonHoc> LayDSMonHoc(){
        List<MonHoc> lsMonHoc = new ArrayList<>();
        lsMonHoc.add(new MonHoc("didong", "CMP354","Lap trinh di dong", "Nguyen Van A"));
        lsMonHoc.add(new MonHoc("java", "CMP324","Lap trinh Java","Nguyen Van B"));
        lsMonHoc.add(new MonHoc("window", "CMP332","Lap trinh windows", "Nguyen Van C"));
        return lsMonHoc;
    }
}
