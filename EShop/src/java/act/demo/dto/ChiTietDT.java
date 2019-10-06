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
public class ChiTietDT {

    private int maCT;
    private String ram;
    private String rom;
    private String cpu;
    private String heDH;
    private String manHinh;
    private String sim;
    private String cameraT;
    private String cameraS;
    private int maSP;

    public ChiTietDT() {
    }

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHeDH() {
        return heDH;
    }

    public void setHeDH(String heDH) {
        this.heDH = heDH;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getCameraT() {
        return cameraT;
    }

    public void setCameraT(String cameraT) {
        this.cameraT = cameraT;
    }

    public String getCameraS() {
        return cameraS;
    }

    public void setCameraS(String cameraS) {
        this.cameraS = cameraS;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    @Override
    public String toString() {
        return "ChiTietDT{" + "maCT=" + maCT + ", ram=" + ram + ", rom=" + rom + ", cpu=" + cpu + ", heDH=" + heDH + ", manHinh=" + manHinh + ", sim=" + sim + ", cameraT=" + cameraT + ", cameraS=" + cameraS + ", maSP=" + maSP + '}';
    }

}
