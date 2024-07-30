package futureTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

@Getter
@AllArgsConstructor
class MyCallable implements Callable<Integer> {

    private int start;
    private int end;

    /**
     * Calculate the sum from 1 to 5
     *
     * @return
     */
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = this.start; i <= this.end; i++) {
            sum += i;
        }
        return sum;
    }
}
