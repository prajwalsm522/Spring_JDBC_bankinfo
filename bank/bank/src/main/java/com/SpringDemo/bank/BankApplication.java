package com.SpringDemo.bank;

import com.SpringDemo.bank.Controllers.bank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BankApplication.class, args);

        bank ob = new bank();
		ob.displayInfo();



	}

}
