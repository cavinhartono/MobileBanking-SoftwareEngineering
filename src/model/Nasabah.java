package model;

public class Nasabah {
  private String nik;
  private String namaLengkap;
  private String nomorTelepon;
  private String email;
  private String password;
  private String pin;
  private double saldo;

  public Nasabah(String nik, String namaLengkap, String nomorTelepon, String email, String password, String pin,
      double saldo) {
    this.nik = nik;
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

  @Override
  public String toString() {
    return namaLengkap + " - " + nomorTelepon + " - Saldo: " + saldo;
  }
}
