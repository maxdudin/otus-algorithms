package otus.sort.benchmark;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

public class BenchmarkRunner {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 2, warmups = 2)
    @Warmup(iterations = 5)
    public void doInit() {

    }

    public static void main(String[] args) throws IOException, RunnerException {
        Main.main(args);
    }
}
