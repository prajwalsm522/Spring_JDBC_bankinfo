package com.SpringDemo.bank.Controllers;

import com.SpringDemo.bank.BankApplication;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class bank extends BankApplication implements bankInterface {

    private String bankname;
    private String branchname;
    private String city;


    Statement stm;
    Connection con = null;
    String address = "jdbc:mysql://localhost:3306/bankdb";
    String username = "root";
    String password = "Cat@8050";

    HashMap<String, bank> bankinfo = new HashMap<String, bank>();
    Scanner sc = new Scanner(System.in);

    public bank() {

    }

    public bank(String bankname, String branchname, String city) {
        this.bankname = bankname;
        this.branchname = branchname;
        this.city = city;
    }


    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


//    public void bankOperation() {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(username,password,address);
//            System.out.println("Connection established");
//            stm = con.createStatement();
//            HashMap<String,String> addbank = new HashMap<String,String>();
//            System.out.println("Welcome to Bank");
//            System.out.println("--------------");
//            System.out.println("Enter the bank to add");
//            addbank.put("bankname", sc.next());
//            System.out.println("Enter the branchId");
//            addbank.put("branchname",sc.next());
//            System.out.println("enter the city");
//            addbank.put("city", sc.next());
//            PreparedStatement pstm = con.prepareStatement("INSERT INTO BANK INFO VALUES(?,?,?)");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//        }
    //   }


    public void bankOperation() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(username, password, address);
            System.out.println("Connection Established..");
            stm = con.createStatement();
            System.out.println("enter bankname");
            bankname = sc.next();
            System.out.println("enter branchname");
            branchname = sc.next();
            System.out.println("enter city");
            city = sc.next();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO BANK VALUES(?,?,?)");
            pstm.setString(1, bankname);
            pstm.setString(2, branchname);
            pstm.setString(3, city);
            int rs = pstm.executeUpdate();
            while (rs == 1) {
                System.out.println("bank added");
            }
            bank b = new bank(bankname, branchname, city);
            bankinfo.put(bankname, b);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public String displayInfo() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(username, password, address);
            System.out.println("Connection Established..");
            stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM BANKINFO");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("bankname: " + bankinfo.get("bankname"));
                System.out.println("branchname: " + bankinfo.get("branchname"));
                System.out.println("city: " + bankinfo.get("city"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    return "hello";
    }
}
