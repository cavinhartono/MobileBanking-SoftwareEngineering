package transaction;

import model.Nasabah;

public class SetorTunai extends Transaksi {
  public SetorTunai(String id, double jumlah) {
    super(id, jumlah);
  }

  @Override
  public boolean proses(Nasabah nasabah) {
    nasabah.tambahSaldo(jumlah);
    return true;
  }
}
