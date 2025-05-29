package util;

import model.Nasabah;
import model.Bank;

import java.io.*;
import java.util.*;

public class FileHelper {
  public static List<Nasabah> loadNasabah(String filePath) {
    List<Nasabah> nasabahList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      reader.readLine(); // skip header
      String line;
      while ((line = reader.readLine()) != null) {
        String[] split = line.split(";");
        Nasabah n = new Nasabah(split[0], split[1], split[2], split[3], split[4], split[5],
            Double.parseDouble(split[6]));
        nasabahList.add(n);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return nasabahList;
  }

  public static List<Bank> loadBank(String filePath) {
    List<Bank> bankList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      reader.readLine(); // skip header
      String line;
      while ((line = reader.readLine()) != null) {
        String[] split = line.split(";");
        Bank b = new Bank(split[0], split[1]);
        bankList.add(b);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bankList;
  }
}
