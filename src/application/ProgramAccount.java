package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class ProgramAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data:");
			System.out.print("Account number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			int opcao;
			do {
				
				String msg = "1. Deposit\n2. Withdraw\n0. Encerrar";
				System.out.println(msg);
				opcao = sc.nextInt();
				
				switch (opcao) {

				case 1:
					System.out.print("Enter a amount for deposit: ");
					double amount = sc.nextDouble();
					account.deposit(amount);
					System.out.println("New balance: " + account.getBalance());
					System.out.println();
					break;
				case 2:
					System.out.print("Enter a amount for withdraw: ");
					amount = sc.nextDouble();
					account.withdraw(amount);
					System.out.println("New balance: " + account.getBalance());
					System.out.println();
					break;
				case 0:
					System.out.println(account);
					System.out.println("Programa encerrado");
					break;
				default:
					System.out.println("Opção inválida, tente novamente!");

				}
			} while (opcao != 0);

		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
	}
}
