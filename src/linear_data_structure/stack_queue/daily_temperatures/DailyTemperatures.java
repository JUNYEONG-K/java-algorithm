package linear_data_structure.stack_queue.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    static int[] dailyTemperaturesByBruteForce(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
                result[i] = 0;
            }
        }
        return result;
    }

    static int[] dailyTemperaturesByStack(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};
//        int[] result = dailyTemperaturesByBruteForce(temperatures);
        int[] result = dailyTemperaturesByStack(temperatures);
        System.out.println("result = " + Arrays.toString(result));
    }
}
