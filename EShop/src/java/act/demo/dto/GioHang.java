/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.demo.dto;

/**
 *
 * @author Toan
 */
public class GioHang {

    private int maSP;
    private String name;
    private String oldPrice;
    private String newPrice;
    private int giamGia;
    private int soLuong;
    private int maxSoLuong;
    private String image;

    public GioHang() {
    }

    public int getMaxSoLuong() {
        return maxSoLuong;
    }

    public void setMaxSoLuong(int maxSoLuong) {
        this.maxSoLuong = maxSoLuong;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "GioHang{" + "maSP=" + maSP + ", name=" + name + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice + ", giamGia=" + giamGia + ", soLuong=" + soLuong + ", maxSoLuong=" + maxSoLuong + ", image=" + image + '}';
    }

}
