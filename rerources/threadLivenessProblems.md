- [Source](https://levelup.gitconnected.com/mastering-java-concurrent-programming-11-thread-liveness-problem-deadlock-livelock-and-11ae9b7259bf)
- Liveness issues refer to the fact that the program never gets the final result of the run.
- The Necessary Conditions for Deadlock:
  - **Mutual exclusion condition:** A resource can only be used by one process or thread at a time.
    - For example, if I have a lock here, once I obtain it, other threads cannot get it until I release it.
  - **Request and hold condition**:
    - The first thread requests the second lock while holding the first lock
  - **Non-interference condition**:
    - The lock is not deprived by external interference. That is, there is no external interference to end the deadlock.
  - **Circular wait condition**:
    - Two or more threads wait for each other or circularly wait for the release of locks
      - For example, two threads are waiting for conditions, that is, you wait for me to release, and I wait for you to release; multiple threads are waiting for conditions, that is, A waits for B, B waits for C, C waits for D, D waits for E, E waits for F, F waits for A, and there is no end to the release, endless waiting, forming a loop.
  - How to Prevent Deadlock:
    - **Obtain locks in a certain order**:
      - If multiple locks must be acquired, the order in which different threads acquire locks needs to be fully considered during design
      - EX:
        - Deadlock:
          - ```
            Thread1 -----> Trying to acquire lock1 -----> Trying to acquire lock2 -----> Deadlock;
            Thread2 -----> Trying to acquire lock2 -----> Trying to acquire lock1 -----> Deadlock;```
        - Prevent deadlock: 
          -  ensure that the order in which the two obtain locks is consistent to avoid a deadlock.
          - ```
            Thread1 -----> Trying to acquire lock1 -----> Trying to acquire lock2 -----> Enter execution;
            Thread2 -----> Trying to acquire lock1 -----> Trying to acquire lock2 -----> Enter execution;```
            
    - **Give up after timeout**:
      - When using the built-in lock provided by the synchronized keyword, a thread will wait forever as long as it doesn’t obtain the lock, which may not be the effect you want. What you want is to give up after waiting for a while if it still fails. In this case, you can use the method boolean tryLock(long time, TimeUnit unit) provided by the Lock interface, which allows you to set a specified time to wait for the lock.
      - Therefore, the thread can actively release all previously obtained locks after the lock acquisition times out. In this way, deadlocks can be avoided very effectively.
- Livelock is very similar to a deadlock, in that the program never receives the final result. However, compared to a deadlock, livelock is “alive”.
- **How to Prevent livelock**: we can wait for a random time when attempting to acquire a lock
-  Starvation:
  - to occur when a particular thread does not get access to the object or the resource which leads to an increase in waiting and execution time.
  - Starvation is said to occur when two or more threads are allocated to the C.P.U. (Central Processing Unit) and takes a lot of time in execution, due to which other waiting threads cannot get the C.P.U. for its execution to carry on.