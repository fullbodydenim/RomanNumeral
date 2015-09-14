/*
 * User: Darin Dubie, darindubie@gmail.com
 * Date: 8/31/2015
 * Time: 6:24 PM 
 */
using System;
using System.Text;

namespace Romanize
{
	class Program
	{
		public static void Main(string[] args)
		{
			int number = 0;
			
			if (args.Length == 0) {
				Console.WriteLine("Please provide an integer to be converted to Roman Numerals.");
				return;
			}
			
			try {
				number = Int32.Parse(args[0]);
			}
			catch (Exception)
			{
				number = 0;
			}
			
			if (number == 0) {
				Console.WriteLine("Zero is undefined in Roman Numerals.");
				return;
			}
			
			// TODO: Implement Functionality Here
			
			Console.WriteLine(args[0] + " written in Roman Numbers is " + romanization(number));
		}
		
		public static String romanization(int numeral)
		{
			char I = 'I', V = 'V', X = 'X', L = 'L', C = 'C', D = 'D', M = 'M';
			StringBuilder romanize = new StringBuilder();
		
			while (numeral >= 1000)
			{
				romanize.Append(M);
				numeral -= 1000;
			}	
		
			if (numeral >= 900)
			{
				romanize.Append(C);
				romanize.Append(M);
				numeral -= 900;
			}
			else
			{
				while (numeral >= 500)
				{
					romanize.Append(D);
					numeral -= 500;
				}
			}
		
			if (numeral >= 400)
			{
				romanize.Append(C);
				romanize.Append(D);
				numeral -= 400;
			}
			else {
				while (numeral >= 100)
				{
					romanize.Append(C);
					numeral -= 100;
				}
			}
		
			if (numeral >= 90)
			{
				romanize.Append(X);
				romanize.Append(C);
				numeral -= 90;
			}
			else {
				while (numeral >= 50)
				{
					romanize.Append(L);
					numeral -= 50;
				}
			}	
		
			if (numeral >= 40)
			{
				romanize.Append(X);
				romanize.Append(L);
				numeral -= 40;
			}
			else {
				while (numeral >= 10)
				{
					romanize.Append(X);
					numeral -= 10;
				}
			}
		
			if (numeral == 9)
			{
				romanize.Append(I);
				romanize.Append(X);
				numeral -= 9;
			}
			else {
				while (numeral >= 5)
				{
					romanize.Append(V);
					numeral -= 5;
				}
			}
		
			if (numeral == 4)
			{
				romanize.Append(I);
				romanize.Append(V);
				numeral -= 4;
			}
			else {
				while (numeral >= 1)
				{
					romanize.Append(I);
					numeral -= 1;
				}
			}
		
			return romanize.ToString();
		}
	}
}
