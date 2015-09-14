/* @author Darin Dubie, darindubie@gmail.com, 08/30/2015
 * 
 * This program takes a single integer as a parameter and converts it to the Roman Numeral system.
 * It uses M for 1000, D for 500, C for 100, L for 50, X for 10, V for 5 and I for 1.
 * It also correctly accounts for the following rules present in the Roman Numeral notation
 * 
 * I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
 * X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
 * C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) 
 * and nine hundred is CM (a hundred less than a thousand)[5]
 */

public class Romanize {

	public static void main(String[] args) 
	{
		int number = 0;
		
		if (args.length == 0) {
			System.err.println("Please provide an integer to be converted to Roman Numerals.");
			System.exit(0);
		}
		
		try {
			number = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe)
		{
			number = 0;
		}
		
		if (number == 0) {
			System.err.println("Zero is undefined in Roman Numerals.");
			System.exit(0);
		}
		
		System.out.println(args[0] + " written in Roman Numerals is " + romanize(number));
	}
	
	public static String romanize(int numeral)
	{
		char I = 'I', V = 'V', X = 'X', L = 'L', C = 'C', D = 'D', M = 'M';
		StringBuffer romanize = new StringBuffer();
		
		while (numeral >= 1000)
		{
			romanize.append(M);
			numeral -= 1000;
		}
		
		if (numeral >= 900)
		{
			romanize.append(C);
			romanize.append(M);
			numeral -= 900;
		}
		else
		{
			while (numeral >= 500)
			{
				romanize.append(D);
				numeral -= 500;
			}
		}
		
		if (numeral >= 400)
		{
			romanize.append(C);
			romanize.append(D);
			numeral -= 400;
		}
		else {
			while (numeral >= 100)
			{
				romanize.append(C);
				numeral -= 100;
			}
		}
		
		if (numeral >= 90)
		{
			romanize.append(X);
			romanize.append(C);
			numeral -= 90;
		}
		else {
			while (numeral >= 50)
			{
				romanize.append(L);
				numeral -= 50;
			}
		}
		
		if (numeral >= 40)
		{
			romanize.append(X);
			romanize.append(L);
			numeral -= 40;
		}
		else {
			while (numeral >= 10)
			{
				romanize.append(X);
				numeral -= 10;
			}
		}
		
		if (numeral == 9)
		{
			romanize.append(I);
			romanize.append(X);
			numeral -= 9;
		}
		else {
			while (numeral >= 5)
			{
				romanize.append(V);
				numeral -= 5;
			}
		}
		
		if (numeral == 4)
		{
			romanize.append(I);
			romanize.append(V);
			numeral -= 4;
		}
		else {
			while (numeral >= 1)
			{
				romanize.append(I);
				numeral -= 1;
			}
		}
		
		return romanize.toString();
	}

}
