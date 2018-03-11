package net.dvt32.spring.basics.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm {

	public int[] sort(int[] numbers) {
		return numbers;
	}
	
}
