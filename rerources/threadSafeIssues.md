- Thread Safety Issues
  - Incorrect running results
  - Thread Liveness Problems ( deadblock, liveblock, starvation)
  - Security Issues During Object Publication and Initialization
  - pay extra attention to thread safety issues:
    - Accessing shared variables or resources
    - There is a binding relationship between different data
    - The class that is depended on does not declare itself to be thread-safe.
