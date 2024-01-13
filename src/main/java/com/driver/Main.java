package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
      SavingsAccount s1=new SavingsAccount("Gautam Raj",1000.00,500.00,10.0);
      CurrentAccount c1=new CurrentAccount("Jannat Raj",10500.00,"TRADE");
      StudentAccount student=new StudentAccount("Ram",4500.00,"University");

      String studentAccountNO=s1.generateAccountNumber(54321,15);
      student.deposit(500.00);
      student.withdraw(100.00);

    }
}