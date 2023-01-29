	static pair getMinMax(long a[], long n) {
		long min = 0;
		long max = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				min = a[0];
				max = a[0];
			}

			if (a[i] > max) {
				max = a[i];
			} else if (a[i] < min) {
				min = a[i];
			}
		}
		return (new pair(min, max));
	}
