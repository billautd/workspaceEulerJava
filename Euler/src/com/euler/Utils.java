package com.euler;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	/**
	 * @param list : List of values
	 * @return Sum of all values in list
	 */
	public static long listSum(final List<Long> list) {
		long sum = 0;
		for (final long i : list) {
			sum += i;
		}
		return sum;
	}

	/**
	 * @param list : List of values
	 * @return Sum of all <b>even</b> values in list
	 */
	public static long evenListSum(final List<Long> list) {
		long sum = 0;
		for (final long i : list) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * @param list : List of values
	 * @return Sum of all <b>odd</b> values in list
	 */
	public static long oddListSum(final List<Long> list) {
		long sum = 0;
		for (final long i : list) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * @param list : List of values
	 * @return max value in list, -1 if list is empty
	 */
	public static long listMax(final List<Long> list) {
		if (list.isEmpty()) {
			return -1;
		}
		long max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		return max;
	}

	/**
	 * Calculates the values of the fibonacci sequence
	 * 
	 * @param limit : Higher limit of possible value
	 * @return List of all values below given limit, starting with values 1 and 2
	 */
	public static List<Long> fibonacci(final long limit) {
		long i1 = 1;
		long i2 = 2;
		final List<Long> values = new ArrayList<>();
		values.add(i1);
		values.add(i2);
		while (i1 + i2 < limit) {
			final long alt = i2;
			i2 = i2 + i1;
			i1 = alt;
			values.add(i2);
		}
		return values;
	}

	/**
	 * @param value : Value to check
	 * @return List of prime factors
	 */
	public static List<Long> divisors(final long value) {
		final List<Long> divs = new ArrayList<>();
		for (long i = 1; i <= Math.sqrt(value); i++) {
			if (value % i == 0) {
				divs.add(i);
				divs.add(value / i);
			}
		}
		divs.sort(Long::compareTo);
		return divs;
	}

	/**
	 * @param value : value to check
	 * @return the smallest number that divides given value
	 */
	public static long smallestPrime(final long value) {
		if (value <= 0) {
			return 0;
		}
		if (value == 1) {
			return 1;
		}
		return divisors(value).get(1);
	}

	/**
	 * @param value : value to check
	 * @return <code>true</code> if value given is prime
	 */
	public static boolean isPrime(final long value) {
		if (value <= 1) {
			return false;
		}
		final List<Long> divs = divisors(value);
		return divs.size() == 2 && divs.contains(1l) && divs.contains(value);
	}

	/**
	 * @param value : longeger to check
	 * @return the list of prime factors of given longeger
	 */
	public static List<Long> primeFactors(final long value) {
		if (isPrime(value)) {
			return List.of(value);
		}
		final List<Long> factors = new ArrayList<>();
		long nbr = value;
		while (nbr != 1) {
			final long smallestPrime = smallestPrime(nbr);
			factors.add(smallestPrime);
			nbr /= smallestPrime;
		}
		return factors;
	}

	/**
	 * @param value : value to check
	 * 
	 * @return <code>true</code> if number is palindrome
	 */
	public static boolean isPalindrome(final long value) {
		final String str = String.valueOf(value);
		final int length = str.length();
		if (length == 1) {
			return true;
		}
		final char[] chars = str.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			if (chars[i] != chars[length - i - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param large
	 * @param small
	 * @return <code>true</code> if small divides large
	 */
	public static boolean divides(final long large, final long small) {
		return large % small == 0;
	}

	/**
	 * @param nbr : NUmber of primes
	 * @return : List of 'nbr' smallest primes
	 */
	public static List<Long> getPrimes(final long nbr) {
		final List<Long> primes = new ArrayList<>();
		long index = 0;
		long val = 1;
		while (index < nbr) {
			if (isPrime(val)) {
				primes.add(val);
				index++;
			}
			val++;
		}
		return primes;
	}

	/**
	 * @param nbr : Max value
	 * @return : List of primes smaller or equal to nbr
	 */
	public static List<Long> getPrimesSmallerThan(final long nbr) {
		final List<Long> primes = new ArrayList<>();
		long val = 1;
		while (val < nbr) {
			if (isPrime(val)) {
				primes.add(val);
			}
			val++;
		}
		return primes;
	}

	/**
	 * @param nbr : Number to compute
	 * @return nbr!
	 */
	public static long factorial(final long nbr) {
		long val = 1;
		for (long i = 2; i <= nbr; i++) {
			val *= i;
			System.out.println(val);
		}
		return val;
	}
}
