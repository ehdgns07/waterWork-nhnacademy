package com.nhnacademy.springframework.waterwork.repository;

public class WaterFee {
    private int orderNumber = 0;
    private String nameOfCity = null;
    private String sector = null;
    private int level = 0;
    private int sectionStart = 0;
    private int sectionEnd = 0;
    private long fee = 0;
    private long basicFeeOflevel = 0;

    public WaterFee(int orderNumber, String nameOfCity, String sector, int level,
                    int sectionStart, int sectionEnd, long fee, long basicFeeOflevel){
        this.orderNumber = orderNumber;
        this.nameOfCity = nameOfCity;
        this.sector = sector;
        this.level = level;
        this.sectionStart = sectionStart;
        this.sectionEnd = sectionEnd;
        this.fee = fee;
        this.basicFeeOflevel = basicFeeOflevel;
    }
}