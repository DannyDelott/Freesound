public class Timer {

	private long startTime;
	private long endTime;
	private long executionTime;

	public Timer() {

	}

	// /////////////////
	// PUBLIC METHODS //
	// /////////////////

	public void begin() {
		startTime = System.currentTimeMillis();
	}

	public void end() {
		endTime = System.currentTimeMillis();
	}

	public void printFormattedExecutionTime() {
		executionTime = endTime - startTime;
		String convert = String.format(
				"Execution time: %d hour(s), %d minute(s), and %d second(s)",
				executionTime / (1000 * 60 * 60),
				(executionTime % (1000 * 60 * 60)) / (1000 * 60),
				((executionTime % (1000 * 60 * 60)) % (1000 * 60)) / 1000);
		System.out.println("\n" + convert);
	}

	/**
	 * Do nothing for a length of time in milliseconds.
	 * 
	 * @param timeInMillis
	 *            milliseconds to timeout for
	 */
	public static void timeout(long timeInMillis) {
		long start = System.currentTimeMillis();
		long end = start + timeInMillis;
		long now;
		long prev = 0;

		while ((now = System.currentTimeMillis()) < end) {

			// print every second
			if (((now - start) % 1000 == 0) && (now != prev)) {
				System.out.print(".");
				prev = now;
			}

			// timeout
		}

		System.out.println();
	}

	// //////////////////
	// GLOBAL GETTERS //
	// //////////////////

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public long getExecutionTime() {
		return executionTime;
	}
}
