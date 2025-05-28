package model;

import java.util.ArrayList;
import java.util.List;

import transaction.Transaksi;

public class Bank {
  private String id;
  private String nama;
  private List<Nasabah> daftarNasabah = new ArrayList<>();

  public Bank(String id, String nama) {
    this.id = id;
    this.nama = nama;
  }

  public Nasabah cariNasabah(String nomorTelepon) {
    for (Nasabah nasabah : daftarNasabah) {
      if (nasabah.getNomorTelepon().equals(nomorTelepon)) {
        return nasabah;
      }
    }

    return null;
  }

  public List<Nasabah> getNasabahList() {
    return daftarNasabah;
  }

  public void tambahNasabah(Nasabah nasabah) {
    daftarNasabah.add(nasabah);
  }

  public boolean verifikasiTransaksi(Transaksi transaksi, Nasabah nasabah) {
    return transaksi.proses(nasabah);
  }
}