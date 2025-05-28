package transaction;

import java.util.Date;

import model.Nasabah;

public abstract class Transaksi {
  protected String id;
  protected Date tanggal;
  protected double jumlah;

  public Transaksi(String id, double jumlah) {
    this.id = id;
    this.jumlah = jumlah;
    this.tanggal = new Date();
  }

  public abstract boolean proses(Nasabah nasabah);
}