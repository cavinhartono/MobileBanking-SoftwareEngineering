package model;

import java.util.ArrayList;
import java.util.List;

import model.Tagihan;
import transaction.Transaksi;

public class Nasabah {
  private String nik;
  private String namaLengkap;
  private String nomorTelepon;
  private String email;
  private String password;
  private String pin;
  private double saldo;

  private List<Transaksi> riwayatTransaksi = new ArrayList<>();
  private List<Tagihan> tagihanList = new ArrayList<>();

  public Nasabah(String nik, String namaLengkap, String nomorTelepon, String email, String password, String pin,
      double saldo) {
    this.namaLengkap = namaLengkap;
    this.nomorTelepon = nomorTelepon;
    this.email = email;
    this.password = password;
    this.pin = pin;
    this.saldo = saldo;
  }

  public boolean login(String pin) {
    return this.pin.equals(pin);
  }

  public boolean register(String nomorTelepon) {
    return this.nomorTelepon.equals(nomorTelepon);
  }

  public String getNamaLengkap() {
    return namaLengkap;
  }

  public String getNik() {
    return nik;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getNomorTelepon() {
    return nomorTelepon;
  }

  public void tambahSaldo(double jumlah) {
    this.saldo += jumlah;
  }

  public boolean kurangiSaldo(double jumlah) {
    if (jumlah <= saldo) {
      saldo -= jumlah;
      return true;
    }

    return false;
  }

  public void updatePin(String newPin) {
    this.pin = newPin;
  }

  public List<Transaksi> getRiwayatTransaksi() {
    return riwayatTransaksi;
  }

  public List<Tagihan> getTagihanList() {
    return tagihanList;
  }

  public void tambahTransaksi(Transaksi transaksi) {
    riwayatTransaksi.add(transaksi);
  }

  public void tambahTagihan(Tagihan tagihan) {
    tagihanList.add(tagihan);
  }

  @Override
  public String toString() {
    return namaLengkap + " - " + nomorTelepon + " - Saldo: " + saldo;
  }
}
