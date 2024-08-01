package threadLivenessProblems.deadlocks.demo1;

import lombok.Getter;

public class Resource {
    @Getter
    private final String name;

    public Resource(String name) {
        this.name = name;
    }
    public synchronized void method1(Resource other){
        // Do something
        other.method2(this);
        // Do something
    }

    public synchronized void method2(Resource other){
        // Do something
        other.method1(this);
        // Do something
    }
}
