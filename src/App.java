import model.Bank;
import model.Nasabah;
import transaction.Transaksi;

public class App {
    private Nasabah nasabah;

    public boolean login(String nomor, String pin, Bank bank) {
        Nasabah n = bank.cariNasabah(nomor);
        if (n != null && n.login(pin)) {
            this.nasabah = n;
            return true;
        }
        return false;
    }

    public boolean register(Nasabah nasabahBaru, Bank bank) {
        if (bank.cariNasabah(nasabahBaru.getNomorTelepon()) == null) {
            bank.tambahNasabah(nasabahBaru);
            return true;
        }
        return false;
    }

    public boolean buatTransaksi(Transaksi transaksi) {
        return transaksi.proses(nasabah);
    }

    public Nasabah getNasabah() {
        return nasabah;
    }
}

// import java.util.Date;

// abstract class Transaction {
// private String id;
// private Date date;
// private double amount;

// public Transaction(String id, Date date, double amount) {
// this.id = id;
// this.date = date;
// this.amount = amount;
// }

// public String getId() {
// return id;
// }

// public void setId(String id) {
// this.id = id;
// }

// public Date getDate() {
// return date;
// }

// public void setDate(Date date) {
// this.date = date;
// }

// public double getAmount() {
// return amount;
// }

// public void setAmount(double amount) {
// this.amount = amount;
// }

// public abstract boolean process(Customer customer);
// }

// class CashDeposit extends Transaction {
// public CashDeposit(String id, Date date, double amount) {
// super(id, date, amount);
// }

// @Override
// public boolean process(Customer customer) {
// double newBalance = customer.getBalance() + getAmount();
// customer.setBalance(newBalance);
// return true;
// }
// }

// class CashWithdrawal extends Transaction {
// public CashWithdrawal(String id, Date date, double amount) {
// super(id, date, amount);
// }

// @Override
// public boolean process(Customer customer) {
// if (customer.getBalance() >= getAmount()) {
// customer.setBalance(customer.getBalance() - getAmount());
// return true;
// } else {
// System.out.println("Withdrawal failed: insufficient balance.");
// return false;
// }
// }
// }

// class FundTransfer extends Transaction {
// private String destinationAccount;
// private String notes;

// public FundTransfer(String id, Date date, double amount, String
// destinationAccount, String notes) {
// super(id, date, amount);
// this.destinationAccount = destinationAccount;
// this.notes = notes;
// }

// public String getDestinationAccount() {
// return destinationAccount;
// }

// public void setDestinationAccount(String destinationAccount) {
// this.destinationAccount = destinationAccount;
// }

// public String getNotes() {
// return notes;
// }

// public void setNotes(String notes) {
// this.notes = notes;
// }

// @Override
// public boolean process(Customer customer) {
// if (customer.getBalance() >= getAmount()) {
// customer.setBalance(customer.getBalance() - getAmount());
// System.out.println("Transferred to: " + destinationAccount);
// return true;
// } else {
// System.out.println("Transfer failed: insufficient balance.");
// return false;
// }
// }
// }

// class BillPayment extends Transaction {
// private String billId;
// private String paymentMethod;

// public BillPayment(String id, Date date, double amount, String billId, String
// paymentMethod) {
// super(id, date, amount);
// this.billId = billId;
// this.paymentMethod = paymentMethod;
// }

// public String getBillId() {
// return billId;
// }

// public void setBillId(String billId) {
// this.billId = billId;
// }

// public String getPaymentMethod() {
// return paymentMethod;
// }

// public void setPaymentMethod(String paymentMethod) {
// this.paymentMethod = paymentMethod;
// }

// @Override
// public boolean process(Customer customer) {
// if (customer.getBalance() >= getAmount()) {
// customer.setBalance(customer.getBalance() - getAmount());
// System.out.println("Bill paid successfully: " + billId);
// return true;
// } else {
// System.out.println("Bill payment failed: insufficient balance.");
// return false;
// }
// }
// }

// class Bill {
// private String id;
// private String type;
// private boolean status;
// private double amount;

// public String getId() {
// return id;
// }

// public void setId(String id) {
// this.id = id;
// }

// public String getType() {
// return type;
// }

// public void setType(String type) {
// this.type = type;
// }

// public boolean isPaid() {
// return status;
// }

// public void setStatus(boolean status) {
// this.status = status;
// }

// public double getAmount() {
// return amount;
// }

// public void setAmount(double amount) {
// this.amount = amount;
// }

// public boolean pay() {
// if (!status) {
// status = true;
// return true;
// }
// return false;
// }
// }

// class Customer {
// private String fullName;
// private String pin;
// private String nik;
// private String email;
// private String password;
// private String phoneNumber;
// private double balance;

// public String getFullName() {
// return fullName;
// }

// public void setFullName(String fullName) {
// this.fullName = fullName;
// }

// public String getPin() {
// return pin;
// }

// public void setPin(String pin) {
// this.pin = pin;
// }

// public String getNik() {
// return nik;
// }

// public void setNik(String nik) {
// this.nik = nik;
// }

// public String getEmail() {
// return email;
// }

// public void setEmail(String email) {
// this.email = email;
// }

// public String getPassword() {
// return password;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// public String getPhoneNumber() {
// return phoneNumber;
// }

// public void setPhoneNumber(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }

// public double getBalance() {
// return balance;
// }

// public void setBalance(double balance) {
// this.balance = balance;
// }

// public boolean login(String pin) {
// return this.pin.equals(pin);
// }

// public void register(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }
// }

// class Bank {
// private String id;
// private String name;

// public String getId() {
// return id;
// }

// public void setId(String id) {
// this.id = id;
// }

// public String getName() {
// return name;
// }

// public void setName(String name) {
// this.name = name;
// }

// public void manageCustomer(Customer customer) {
// // logic to manage customer
// }

// public boolean verifyTransaction(Transaction transaction) {
// // logic to verify transaction
// return true;
// }

// public void updateBalance(Customer customer, double amount) {
// double newBalance = customer.getBalance() + amount;
// customer.setBalance(newBalance);
// }
// }

// public class App {
// public static void main(String[] args) {
// Customer customer = new Customer();
// customer.setFullName("John Doe");
// customer.setPhoneNumber("08123456789");
// customer.setPin("123456");
// customer.setBalance(500000);

// System.out.println("Initial balance: " + customer.getBalance());

// // Withdraw
// Transaction withdrawal = new CashWithdrawal("TX001", new Date(), 600000);
// withdrawal.process(customer);

// // Deposit
// Transaction deposit = new CashDeposit("TX002", new Date(), 200000);
// deposit.process(customer);

// // Transfer
// Transaction transfer = new FundTransfer("TX003", new Date(), 150000,
// "9876543210", "Rent payment");
// transfer.process(customer);

// // Pay Bill
// Transaction billPayment = new BillPayment("TX004", new Date(), 100000,
// "BL001", "M-Banking");
// billPayment.process(customer);

// System.out.println("Final balance: " + customer.getBalance());
// }
// }