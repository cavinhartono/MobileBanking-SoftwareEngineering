package model;

import java.util.ArrayList;
import java.util.List;

import transaction.Transaksi;

public class Bank {
  private String nama;
  private List<Nasabah> daftarNasabah;

  public Bank(String nama) {
    this.nama = nama;
    this.daftarNasabah = new ArrayList<>();
  }

  public void tambahNasabah(Nasabah nasabah) {
    daftarNasabah.add(nasabah);
  }

  public boolean verifikasiTransaksi(Transaksi transaksi, Nasabah nasabah) {
    return transaksi.proses(nasabah);
  }
}