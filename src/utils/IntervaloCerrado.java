package utils;

public class IntervaloCerrado {
	private int min;
	private int max;

	public IntervaloCerrado(int min, int max) {
		assert (min < max);
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public boolean isComprendidoEnIntervalo(int value) {
		return (value >= min) && (value <= max);
	}

	public String toString() {
		return "[" + min + "-" + max + "]";
	}
}