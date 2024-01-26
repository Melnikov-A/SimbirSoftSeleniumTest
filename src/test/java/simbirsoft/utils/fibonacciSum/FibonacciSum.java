package simbirsoft.utils.fibonacciSum;

import java.time.LocalDate;

public class FibonacciSum {

    public int calculateFibonacciSum() {
        LocalDate currentDate = LocalDate.now();

        int n = currentDate.getDayOfMonth() + 1;

        int fib = 1;
        int prevFib = 0;

        for (int i = 1; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }
}


