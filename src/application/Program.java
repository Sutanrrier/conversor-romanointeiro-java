package application;

import java.util.Scanner;

import Exceptions.ConversorException;
import util.Conversor;

public class Program {

	public static void main(String[] args) {
		try {
			Conversor conversor = new Conversor();
			Scanner sc = new Scanner(System.in);
			
			String romanNumber;
			System.out.print("Digite o número romano: ");	
			romanNumber = sc.next();
			
			conversor.checker(romanNumber);
			conversor.conversor(romanNumber);
			
			sc.close();
		}
		catch(ConversorException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
