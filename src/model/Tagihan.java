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
}
