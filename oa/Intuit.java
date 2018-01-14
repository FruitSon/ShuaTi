package oa;

import java.util.*;

public class Intuit {
	public static void main(String[] args) {
		List<Record> record = new LinkedList<>();
		record.add(new Record("Mary", 1));
		record.add(new Record("Tom", 1));
		record.add(new Record("Mary", 0));
		record.add(new Record("Jack", 1));
		record.add(new Record("Jack", 0));
		record.add(new Record("Tom", 1));
		Set<String> res = findInvaild(record);
		for (String str : res) {
			System.out.println(str);
		}

	}

	public static Set<String> findInvaild(List<Record> rec) {
		Set<String> res = new HashSet<>();
		Map<String, Integer> cnt = new HashMap<>();
		int delta = 0;
		for (Record r : rec) {
			if (r.action == "exit")
				delta = -1;
			else if (r.action == "enter")
				delta = 1;
			int times = cnt.getOrDefault(r.name, 0) + delta;
			if (times < 0)
				res.add(r.name);
			cnt.put(r.name, times);
		}
		for (String key : cnt.keySet()) {
			System.out.println(key + ":" + cnt.get(key));
			if (cnt.get(key) != 0)
				res.add(key);
		}
		return res;
	}

	static class Record {
		String name, action;

		Record() {
		}

		Record(String n, int a) {
			name = n;
			action = a == 1 ? "enter" : "exit";
		}
	}

}
