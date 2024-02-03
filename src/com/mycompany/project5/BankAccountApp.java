package com.mycompany.project5;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read a CSV File then create new accounts based on that data
        String file = "C:\\Users\\User\\Desktop\\Files\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")){
                accounts.add(new Savings(name, sSn, initDeposit));
            }else{
                accounts.add(new Checking(name, sSn, initDeposit));
            }
        }

        for (Account acc : accounts){
            System.out.println("\n********************");
            acc.showInfo();
        }

    }
}
