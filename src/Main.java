import model.*;
import transaction.*;
import util.FileHelper;

import java.text.*;
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
    double jumlah;
    int choice;

    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

    formatRp.setCurrencySymbol("Rp. ");
    formatRp.setMonetaryDecimalSeparator(',');
    formatRp.setGroupingSeparator('.');
    kursIndonesia.setDecimalFormatSymbols(formatRp);

    for (Nasabah nasabah : nasabahList) {
      bank.tambahNasabah(nasabah);
    }

    System.out.println(bank.getNasabahList().size());

    App app = new App();

    System.out.println("Selamat Datang!");
    System.out.println("BluBCA");

    System.out.print("Masukan nomor telepon : ");
    String nomorTelepon = ip.nextLine();
    System.out.print("Masukan PIN           : ");
    String pin = ip.nextLine();

    if (!app.login(nomorTelepon, pin, bank)) {
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
      app.login(nomorTelepon, pinNasabah, bank);
    }

    do {
      System.out.println("Saldo saya: " + kursIndonesia.format(app.getNasabah().getSaldo()));
      System.out.println("1. Transfer Dana\n2. Setor Tunai\n3. Tarik Tunai\n4.Beli T\n5. Keluar");
      System.out.print("Pilih Menu: ");
      choice = ip.nextInt();
      switch (choice) {
        case 1:
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
        default:
          System.err.println("Keluar...");
          break;
      }
    } while (choice != 4);
  }
}
