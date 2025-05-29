package transaction;

import model.Nasabah;

public class TarikTunai extends Transaksi {
  public TarikTunai(String id, double jumlah) {
    super(id, jumlah);
  }

  @Override
  public boolean proses(Nasabah nasabah) {
    return nasabah.kurangiSaldo(jumlah);
  }
}
