package transaction;

import model.Nasabah;
import model.Tagihan;

public class PembayaranTagihan extends Transaksi {
  private String idTagihan;
  private String metodePembayaran;

  public PembayaranTagihan(String id, double jumlah, String idTagihan, String metodePembayaran) {
    super(id, jumlah);
    this.idTagihan = idTagihan;
    this.metodePembayaran = metodePembayaran;
  }

  @Override
  public boolean proses(Nasabah nasabah) {
    if (nasabah.getSaldo() >= jumlah) {
      nasabah.kurangiSaldo(jumlah);
      nasabah.tambahTransaksi(this);
      return true;
    }
    return false;
  }
}