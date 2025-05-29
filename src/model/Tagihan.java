package model;

public class Tagihan {
  private String id;
  private String jenis;
  private double jumlah;
  private boolean isBayar;

  public Tagihan(String id, String jenis, double jumlah) {
    this.id = id;
    this.jenis = jenis;
    this.jumlah = jumlah;
    this.isBayar = false;
  }

  public boolean bayar() {
    return !isBayar ? true : false;
  }

  public String getId() {
    return id;
  }

  public String getJenis() {
    return jenis;
  }

  public double getJumlah() {
    return jumlah;
  }

  public boolean isBayar() {
    return isBayar;
  }
}
