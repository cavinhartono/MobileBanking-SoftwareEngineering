package util;

import java.text.*;
import java.util.Locale;

public class CurrencyFormatter {
  public static String toRupiah(Number amount) {
    Locale indonesiaLocale = new Locale("id", "ID");
    NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesiaLocale);
    return (amount != null) ? rupiahFormat.format(amount) : "Rp0";
  }
}
