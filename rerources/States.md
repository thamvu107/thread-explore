- New: When a thread object is just created. The thread is not alive
- Runnable: When the  start() function is called on the thread object. Its state is changed to runnable
- Running: This is when the thread starts executing. The CPU starts the execution of this thread
- Blocked: The thread is waiting for a monitor lock. For a shared resource such as a mutable memory data structure,
  only the thread can access/read/mutable it. While a thread has the lock, other threads will be blocked. (expensive and wasteful)
- Waiting: Wait for another thread to perform an action. Thread commonly block while doing I/O.
- Timed wait: The thread waits for an event for a finite amount of time.
- Terminated: The thread is dead and cannot go back to any other state.
- ![Screenshot 2024-07-29 at 16.39.51.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fsm%2Fs5gvn7v16wz308hl2n7qntx00000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_DJ1jn7%2FScreenshot%202024-07-29%20at%2016.39.51.png)

- A blocking thread is expensive and wasteful. (a thread is a **resource** itself) - that take a long time to complete

- synchronized keyword: 
  - The synchronized keyword prevents the execution of critical sections by more than one thread. The synchronized keyword also makes sure the thread's local memory syncs up correctly with the shared memory
  - Synchronous execution allows tasks to execute in a sequence, waiting for the current operation to complete before starting with the next
- volatile keyword: guarantees correct memory visibility
- Synchronous:
- Asynchronous:
  - ![Screenshot 2024-07-29 at 18.31.45.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fsm%2Fs5gvn7v16wz308hl2n7qntx00000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_gOwnVc%2FScreenshot%202024-07-29%20at%2018.31.45.png)