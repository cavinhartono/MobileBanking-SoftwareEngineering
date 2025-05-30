import model.*;
import transaction.*;
import util.*;

import java.util.*;

/**
 *
 * @author Cavin Hartono
 * @goal Kepentingan Implementasi Tugas Akhir
 *       pada Mata Kuliah Rekayasa Perangkat Lunak
 * @date Tanggal: Senin, 26 Mei 2025
 */

public class Main {
  private static Scanner ip = new Scanner(System.in);

  public static void main(String[] args) {
    List<Nasabah> nasabahList = FileHelper.loadNasabah("src\\data\\nasabah.txt");
    List<Bank> bankList = FileHelper.loadBank("src\\data\\bank.txt");
    Bank bank = bankList.get(0);
    for (Nasabah nasabah : nasabahList)
      bank.tambahNasabah(nasabah);
    boolean isAuth;
    double jumlah;
    int choice;

    App app = new App();

    System.out.println("Selamat Datang di BluBCA!");

    System.out.print("Masukan nomor telepon : ");
    String nomorTelepon = ip.nextLine();
    System.out.print("Masukan PIN           : ");
    String pin = ip.nextLine();

    isAuth = app.login(nomorTelepon, pin, bank);

    if (!isAuth) {
      System.out.println("Nomor belum terdaftar. Proses registrasi...");
      System.out.print("Masukkan Nama Lengkap: ");
      String namaLengkapNasabahBaru = ip.nextLine();
      System.out.print("Masukkan NIK         : ");
      String nikNasabahBaru = ip.nextLine();
      System.out.print("Masukkan Email       : ");
      String email = ip.nextLine();
      System.out.print("Masukkan Password    : ");
      String password = ip.nextLine();
      System.out.print("Masukkan PIN         : ");
      String pinNasabah = ip.nextLine();
      Nasabah nasabah = new Nasabah(nikNasabahBaru, namaLengkapNasabahBaru, nomorTelepon, email, password, pinNasabah,
          0);
      bank.tambahNasabah(nasabah);
      isAuth = app.login(nomorTelepon, pinNasabah, bank);
    }

    if (isAuth) {
      do {
        System.out.println("Saldo saya: " + CurrencyFormatter.toRupiah(app.getNasabah().getSaldo()));
        System.out.println(
            "1. Transfer Dana\n2. Setor Tunai\n3. Tarik Tunai\n4. Bayar Tagihan\n5. List Tagihan\n6. Lihat Riwayat Transaksi\n7. Keluar");
        System.out.print("Pilih Menu: ");
        choice = ip.nextInt();
        switch (choice) {
          case 1:
            System.out.print("Masukan Nomor Tujuan  : ");
            String tujuanRekening = ip.nextLine();
            System.out.print("Jumlah                : ");
            jumlah = ip.nextDouble();
            ip.nextLine();
            System.out.print("Catatan               : ");
            String catatanKecil = ip.nextLine();

            if (bank.cariNasabah(tujuanRekening) != null) {
              System.out.println(
                  app.buatTransaksi(new Transfer(UUID.randomUUID().toString(), jumlah, tujuanRekening, catatanKecil))
                      ? "Transfer berhasil!"
                      : "Saldo tidak mencukupi.");
            } else {
              System.out.println("Nasabah tujuan tidak ditemukan.");
            }
            break;
          case 2:
            System.out.print("Masukan jumlah setor: ");
            jumlah = ip.nextDouble();
            app.buatTransaksi(new SetorTunai(UUID.randomUUID().toString(), jumlah));
            break;
          case 3:
            System.out.print("Masukan jumlah tarik: ");
            jumlah = ip.nextDouble();
            System.out.println(app.buatTransaksi(new TarikTunai(UUID.randomUUID().toString(), jumlah))
                ? "Berhasil tarik tunai!"
                : "Saldo tidak mencukupi.");
            break;
          case 4:
            List<Tagihan> tagihan = app.getNasabah().getTagihanList();
            for (int i = 0; i < tagihan.size(); i++) {
              Tagihan t = tagihan.get(i);
              System.out
                  .println(i + ". " + t.getJenis() + " - " + t.getJumlah() + " - " + (t.isBayar() ? "Lunas" : "Belum"));
            }
            System.out.print("Pilih tagihan: ");
            int index = ip.nextInt();
            ip.nextLine();

            if (index >= 0 && index < tagihan.size()) {
              Tagihan t = tagihan.get(index);
              if (!t.isBayar()) {
                PembayaranTagihan pt = new PembayaranTagihan(UUID.randomUUID().toString(), t.getJumlah(), t.getId(),
                    "Saldo");

                if (app.buatTransaksi(pt)) {
                  t.bayar();
                  System.out.println("Tagihan berhasil dibayar!");
                } else {
                  System.out.println("Saldo tidak cukup untuk membayar tagihan.");
                }
              } else {
                System.out.println("Tagihan sudah lunas");
              }
            }
            break;
          case 5:
            if (app.getNasabah().getTagihanList().isEmpty()) {
              System.out.println("Tidak ada tagihan.");
            } else
              for (Tagihan t : app.getNasabah().getTagihanList())
                System.out.println(
                    t.getJumlah() + " - " + t.getJenis() + " - " + (t.isBayar() ? "Sudah bayar" : "Belum bayar"));
            break;
          case 6:
            List<Transaksi> riwayat = app.getNasabah().getRiwayatTransaksi();
            if (riwayat.isEmpty()) {
              System.out.println("Belum ada transaksi");
            } else {
              for (Transaksi transaksi : riwayat) {
                System.out.println(
                    transaksi.getClass().getSimpleName() + " - " + transaksi.getJumlah() + transaksi.getTanggal());
              }
            }
            break;
          default:
            System.err.println("Keluar...");
            break;
        }
      } while (choice != 7);
    }
  }
}
