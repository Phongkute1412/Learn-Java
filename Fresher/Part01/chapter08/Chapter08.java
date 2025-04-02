package chapter08;

public final class Chapter08 {

	public static final double sum(double... x) {
		double total = 0;
		for (double i : x) {
			total = total + i;
		}
		return total;
	}

	public static final double min(double... x) {
		double min = Double.MAX_VALUE;
		for (double i : x) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public static final double max(double... x) {
		double max = Double.MIN_VALUE;
		for (double i : x) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	public static final void toUpperFirstChar(String s) {
		String[] name = s.split(" ");

		StringBuilder nameUpperFirstChar = new StringBuilder();
		for (int i = 0; i < name.length; i++) {
			nameUpperFirstChar.append(name[i].substring(0, 1).toUpperCase() + name[i].substring(1));
			if (i < name.length - 1) {
				nameUpperFirstChar.append(" ");
			}
		}
		System.out.println("The string after using method is: " + nameUpperFirstChar.toString());
	}
}
