package transaction;

import model.Nasabah;
import model.Tagihan;

public class PembayaranTagihan extends Transaksi {
  private Tagihan tagihan;

  public PembayaranTagihan(String id, double jumlah, Tagihan tagihan) {
    super(id, jumlah);
    this.tagihan = tagihan;
  }

  @Override
  public boolean proses(Nasabah nasabah) {
    if (nasabah.kurangiSaldo(jumlah)) {
      tagihan.bayar();
      return true;
    }
    return false;
  }
}