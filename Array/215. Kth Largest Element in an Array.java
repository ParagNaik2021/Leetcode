public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (Integer n : nums) {
			pq.add(n);
			if (pq.size() > k) {
				pq.remove();
			}

		}
		return pq.peek();
	}
