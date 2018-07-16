package Advanced_multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableQueen implements Callable<Integer> {

	int y1 = 1, y2 = 2, y3 = 3, y4 = 4, y5 = 5, y6 = 6, y7 = 7, y8 = 8;
	int i1 = 0;
	ExecutorService executor = Executors.newFixedThreadPool(8);

	CallableQueen(int i) {
		this.i1 = i;

	}

	public boolean isCorrectNextStep(int nextStepx1, int nextStepy1,
			int prevStepx2, int prevStepy2) {

		double denominator = nextStepx1 - prevStepx2;
		double numerator = nextStepy1 - prevStepy2;

		if (denominator == 0)
			return false;
		else {
			double div = numerator / denominator;

			if (div == 0.0) {
				return false;
			} else if (div == 1.0 || div == -1.0) {
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public Integer call() throws Exception {
		int count = 0;

		for (int i2 = 1; i2 <= 8; i2++) {
			for (int i3 = 1; i3 <= 8; i3++) {
				for (int i4 = 1; i4 <= 8; i4++) {
					for (int i5 = 1; i5 <= 8; i5++) {
						for (int i6 = 1; i6 <= 8; i6++) {
							for (int i7 = 1; i7 <= 8; i7++) {
								for (int i8 = 1; i8 <= 8; i8++) {
									if (isCorrectNextStep(i1, y1, i2, y2)
											&& isCorrectNextStep(i1, y1, i3, y3)
											&& isCorrectNextStep(i1, y1, i4, y4)
											&& isCorrectNextStep(i1, y1, i5, y5)
											&& isCorrectNextStep(i1, y1, i6, y6)
											&& isCorrectNextStep(i1, y1, i7, y7)
											&& isCorrectNextStep(i1, y1, i8, y8)// i1
																				// complete
											&& isCorrectNextStep(i2, y2, i3, y3)
											&& isCorrectNextStep(i2, y2, i4, y4)
											&& isCorrectNextStep(i2, y2, i5, y5)
											&& isCorrectNextStep(i2, y2, i6, y6)
											&& isCorrectNextStep(i2, y2, i7, y7)
											&& isCorrectNextStep(i2, y2, i8, y8)// i2
																				// complete
											&& isCorrectNextStep(i3, y3, i4, y4)
											&& isCorrectNextStep(i3, y3, i5, y5)
											&& isCorrectNextStep(i3, y3, i6, y6)
											&& isCorrectNextStep(i3, y3, i7, y7)
											&& isCorrectNextStep(i3, y3, i8, y8)// i3
																				// complete
											&& isCorrectNextStep(i4, y4, i5, y5)
											&& isCorrectNextStep(i4, y4, i6, y6)
											&& isCorrectNextStep(i4, y4, i7, y7)
											&& isCorrectNextStep(i4, y4, i8, y8)// i4
																				// complete
											&& isCorrectNextStep(i5, y5, i6, y6)
											&& isCorrectNextStep(i5, y5, i7, y7)
											&& isCorrectNextStep(i5, y5, i8, y8)// i5
																				// complete
											&& isCorrectNextStep(i6, y6, i7, y7)
											&& isCorrectNextStep(i6, y6, i8, y8)// i6
																				// complete
											&& isCorrectNextStep(i7, y7, i8, y8)// i7
																				// complete
									) {
										count++;
									}
								}
							}
						}
					}
				}
			}
		}
		return count;
	}
}

public class EightQueensProblem {
	static int count = 0;

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(8);
		ArrayList<Future<Integer>> arylist = new ArrayList<Future<Integer>>();

		for (int j = 1; j < 9; j++) {
			arylist.add(executor.submit(new CallableQueen(j)));
		}
		for (int j = 0; j < 8; j++) {
			Future<Integer> f = arylist.get(j);
			count = count + f.get();

		}
		System.out.println("Total possible positions-"+count);

	}

}
