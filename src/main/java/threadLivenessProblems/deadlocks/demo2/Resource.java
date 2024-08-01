package threadLivenessProblems.deadlocks.demo2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Resource {
    @Getter
    private final String name;
}
