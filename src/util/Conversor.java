package util;

import Exceptions.ConversorException;

public class Conversor {
	
	//M�todo que vai checar seu o n�mero romano existe.
	public void checker(String romanNumber) {
		int count=1; //Ser� usado para ver se o n�mero romano digitado � v�lido.
		int i=0; // V�riavel que vai percorrer a string.
		String aux = romanNumber + "F"; //Adiciona um char no final do numero. Usado na hora de fazer as condico�s do 'for'.
		while(aux.charAt(i) != 'F') {
			for(i=0;i<aux.length() - 1;i++) {
				char pos1 = aux.charAt(i);
				char pos2 = aux.charAt(i+1);
				
				//Chars 'L', 'V' e 'D' n�o pode repetir ou virem acompanhados de n�meros maiores que o mesmo.
				if((pos1 == 'L' && pos2 == 'L') || (pos1 == 'V' && pos2 == 'V') || (pos1 == 'D' && pos2 == 'D')){
					throw new ConversorException("N�mero romano inv�lido!");
				}
				
				if((pos1 == 'V' && pos2 != 'I') || (pos1 == 'L' && (pos2 != 'V' && pos2 != 'I')) || (pos1 == 'D' && pos2 == 'M')) {
					throw new ConversorException("N�mero romano inv�lido!");
				}
				
				//Verifica se o char repete na string.
				if((pos1 == pos2) ) {
					count++;
				}
				else {
					count = 1;
				}
				
				//Chars 'I', 'X', 'C' e 'M' n�o podem repetir mais que 3 vezes.
				if(count > 3) {
					throw new ConversorException("N�mero romano inv�lido!");
				}	
			}
		}	
	}
	
	//M�todo para converter o n�mero romano em n�mero inteiro. O mesmo s� pode ser convertido se for v�lido.
	public void conversor(String romanNumber) {
		int I=1, V=5, X=10, L=50, C=100, D=500, M=1000; //Numeros romanos e seus valores.
		String aux = romanNumber + "F"; //Adiciona um char no final do numero. Usado na hora de fazer as condico�s do 'for'.
		int i=0; // V�riavel que vai percorrer a string.
		int number=0; // Numero romano convertido. Por padr�o inicia com valor zero.
		
		while(aux.charAt(i) != 'F') {
			for(i=0;i<aux.length() - 1;i++) {
				//M
				if(aux.charAt(i) == 'M') {
					number += M;
				}
				//D
				if(aux.charAt(i) == 'D') {
					number += D;
				}
				//C
				if(aux.charAt(i) == 'C' && aux.charAt(i+1) != 'D' && aux.charAt(i+1) != 'M') {
					number += C;
				}
				if(aux.charAt(i) == 'C' && aux.charAt(i+1) == 'D') {
					number += D-C;
					i++; //Pula o pr�ximo caractere.
				}
				if(aux.charAt(i) == 'C' && aux.charAt(i+1) == 'M') {
					number += M-C;
					i++; //Pula o pr�ximo caractere.
				}
				//L
				if(aux.charAt(i) == 'L') {
					number += L;
				}
				//X
				if(aux.charAt(i) == 'X' && aux.charAt(i+1) != 'L' && aux.charAt(i+1) != 'C') {
					number += X;
				}
				if(aux.charAt(i) == 'X' && aux.charAt(i+1) == 'L') {
					number += L-X;
					i++; //Pula o pr�ximo caractere.
				}
				if(aux.charAt(i) == 'X' && aux.charAt(i+1) == 'C') {
					number += C-X;
					i++; //Pula o pr�ximo caractere.
				}
				//V
				if(aux.charAt(i) == 'V') {
					number += V;
				}
				//I
				if(aux.charAt(i) == 'I' && aux.charAt(i+1) != 'V' && aux.charAt(i+1) != 'X') {
					number += I;
				}
				if(aux.charAt(i) == 'I' && aux.charAt(i+1) == 'V') {
					number += V-I;
					i++; //Pula o pr�ximo caractere.
				}
				if(aux.charAt(i) == 'I' && aux.charAt(i+1) == 'X') {
					number += X-I;
					i++; //Pula o pr�ximo caractere.
				}
			}
		}	
		System.out.println("\nN�MERO ROMANO: " + romanNumber);
		System.out.println("N�MERO CONVERTIDO: " + number);
	}
}
