package transaction;

import model.Nasabah;

public class Transfer extends Transaksi {
  private String tujuanRekening;
  private String catatan;

  public Transfer(String id, double jumlah, String tujuanRekening, String catatan) {
    super(id, jumlah);
    this.tujuanRekening = tujuanRekening;
    this.catatan = catatan;
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
