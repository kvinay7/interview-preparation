# Operating Systems
An operating system is a software which is an interface between user and hardware. It is responsible for the execution of all the processes, Resource Allocation, CPU management, File Management and many other tasks. The purpose of an operating system is to provide an environment in which a user can execute programs in a convenient and efficient manner. 

<div align="center">
  <img src="https://media.geeksforgeeks.org/wp-content/uploads/20230510120545/OS1.webp" alt="OS">
</div>

- **Kernel:** is the core part of the operating system. It directly interacts with the hardware and provides low-level services such as process management, memory management, device management, and system calls.
- **System calls:** provide an interface for user-level applications to interact with the kernel. When a program needs to access hardware or perform a privileged operation, it invokes a system call.
- **Shell:** is a command-line interface or program that allows users to interact with the OS by entering commands. The shell interprets user commands and passes them to the OS for execution.

  +-------------------------------+      System Call / Interrupt        +-------------------------------+
  |        **User Mode**           |  ----------------------------->    |        **Kernel Mode**         |
  |-------------------------------|   <-----------------------------    |-------------------------------|
  |  - Application running         |                                    |  - OS kernel takes over       |
  |  - Limited access to hardware  |                                    |  - OS performs privileged tasks|
  |  - Cannot access hardware      |                                    |  - Full access to resources   |
  |    or system-critical functions|                                    |  - System calls handled       |
  |  - Requests services via       |                                    |  - Privileged operations      |
  |    system calls (e.g., read    |                                    |    performed (e.g., I/O, memory)|
  |    file, open connection)      |                                    |                               |
  +-------------------------------+                                     +-------------------------------+
             
### What happens when we turn on computer?
1. Power is supplied → Motherboard and components wake up.
2. BIOS (Basic Input/Output System) runs POST (power-on-self-test) to ensure hardware is working.
3. Bootloader is loaded from the storage device.
4. Operating System `kernel` is loaded into memory.
5. Drivers and system services are initialized.
6. Login screen or desktop is displayed.

### Types of Operating Systems

| **Type of OS**           | **Description**                                                                                                    | **Advantages**                                                                                  | **Disadvantages**                                                                              | **Real-World Examples**                                      |
|---------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|-------------------------------------------------------------|
| **Multiprocessing OS**    | Supports multiple processors working together, allowing multiple tasks to execute simultaneously.                  | - High performance for complex tasks. <br>- Increased reliability (if one processor fails, others continue). | - Expensive hardware required. <br>- Complex implementation and management.                  | Windows Server, UNIX, Linux (with multi-core CPUs)          |
| **Real-Time OS**          | Executes tasks within strict time constraints, commonly used in critical systems like aviation and medical devices.| - Predictable response times. <br>- Ideal for time-sensitive tasks.                            | - Limited user interface. <br>- Difficult to develop and debug.                              | QNX, VxWorks, FreeRTOS                                      |
| **Distributed OS**        | Manages a network of interconnected computers, making them work as a single system.                                | - Efficient resource sharing. <br>- Fault tolerance and scalability.                           | - Complex to implement and manage. <br>- Network dependency.                                  | Google File System, Apache Hadoop, Spark                    |
| **Clustered OS**          | Links multiple computers to work together, often for high-performance tasks or load balancing.                     | - High availability and performance. <br>- Fault tolerance through redundancy.                 | - Requires specialized hardware and network setup. <br>- High maintenance costs.              | Beowulf Clusters, Kubernetes, Windows Server Clustering     |
| **Embedded OS**           | Designed for specific hardware with limited functionality, used in IoT and specialized devices.                    | - Lightweight and fast. <br>- Customizable for specific tasks.                                 | - Limited functionality. <br>- Difficult to upgrade or adapt.                                | FreeRTOS, Embedded Linux, Zephyr                            |
| **Batch OS**              | Processes jobs in batches without user interaction, widely used in early computing.                                | - Efficient for repetitive tasks. <br>- No user intervention required.                         | - Poor resource utilization. <br>- No real-time interaction.                                  | IBM OS/360, early payroll or billing systems                |
| **Multiprogramming OS**   | Allows multiple programs to reside in memory and execute concurrently, improving CPU utilization.                   | - Better CPU utilization. <br>- Handles multiple tasks simultaneously.                         | - Requires sophisticated memory management. <br>- Potential for system crashes or deadlocks. | IBM OS/390, UNIX                                            |
| **Multitasking OS**       | Allows multiple tasks or processes to run at the same time by efficiently managing CPU time-sharing.                | - Improves user experience. <br>- Allows concurrent execution of tasks.                        | - Can cause system slowdowns if overloaded. <br>- Requires higher memory and CPU power.       | Windows 10, macOS, Linux                                    |

## Process:
A process is an instance of a program in execution which has its privite memory space and resources. A process can have multiple threads.

- **Process Control Block (PCB):** is a data structure in the operating system used to store all the information needed to manage a process. The operating system maintains a PCB for every process in the system.

    | **Field**                     | **Description**                           |
    |-------------------------------|-------------------------------------------|
    | **Process ID (PID)**           | Unique identifier for the process.       |
    | **Parent Process ID (PPID)**   | PID of the parent process.               |
    | **Process State**              | Current state of the process (e.g., Running, Waiting, Ready, Terminated). |
    | **Program Counter (PC)**       | Address of the next instruction to execute. |
    | **CPU Registers**              | The values of CPU registers during execution (e.g., general-purpose registers). |
    | **Memory Management Info**     | Memory allocated to the process (e.g., base and limit registers, page tables). |
    | **Scheduling Information**     | Priority, scheduling algorithm details, time quantum, etc. |
    | **I/O Status Information**     | Files, devices, and other resources used by the process. |

- **Process State Transition Diagram:**
                                           
                      Resource                Preemption
      +------------+ Allocation +-----------+ <--------- +-----------+   exit    +------------+
      |   New      | ---------> |   Ready   | ---------> |  Running  |---------> | Terminated |
      +------------+ (Admitted) +-----------+ scheduler  +-----------+ resource  +------------+
                                    ^         dispatch          |     deallocation
                    I/O completion  |                           | 
                            +-----------------+                 |
                            | Waiting/Blocked | <---------------- waiting for I/O
                            +-----------------+              
  
 - **Process Control System Calls**:
   - **`fork()`**: Creates a new process by duplicating the calling process.
   - **`exec()`**: Replaces the current process with a new program.
   - **`wait()`**: Makes a process wait for its child process to terminate.
   - **`exit()`**: Terminates the current process.

- **Example:** `ProcessBuilder` class is used to create and manage operating system processes in Java.
```java
    import java.io.IOException;
    public class ProcessExample {
        public static void main(String[] args) {
            ProcessBuilder processBuilder = new ProcessBuilder("ls", "-l");
            try {
                Process process = processBuilder.start();  // This triggers a system call
                process.waitFor();  // This waits for the system call to finish
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
```

### CPU Scheduling:
The process by which the operating system decides which process (or thread) gets to use the CPU at any given time. Since most modern computers run multiple processes simultaneously, the operating system needs to allocate the CPU to each process in a way that optimizes performance, responsiveness, and fairness.
- **Concurrency:** The ability of a system to handle multiple tasks simultaneously, but not necessarily at the same time.
- **Parallelism:** The ability to execute multiple tasks at the same time, typically across multiple cores of a processor.
- **Scheduling Criteria**: Process Time = CPU BT + I/O BT
  - `CPU BT`: The time a process needs the CPU to perform its task.
  - `I/O BT`: The time a process spends performing I/O operations like reading from a disk or waiting for input.

- **Scheduling Metrics**:
  - `Arriaval Time`: The time at which the process arrives in the system.

  - `Burst Time`: The amount of time for which process runs on CPU/IO.

  - `Completion/Exit Time`: The time at which process completes.

  - `Waiting Time`: The total time a process spends waiting in the ready queue. Less WT for better CPU utilization. WT = TAT - BT

  - `Turnaround Time`: The total time from the arrival to completion. Less TAT for better CPU utilization. TAT = CT - AT and Normalized TAT = TAT/ BT

  - `Response Time`: The time from the submission of a request until the first response is produced.

  - `Throughput`: The number of processes completed per unit of time. Increase the number of processes completed in a given period for better CPU utilization.

  - `Scheduling Length`: MAX(CT) - MIN(AT)

#### Types of CPU Scheduling Algorithms:
- **Non-preemptive scheduling:** once a process is allocated the CPU, it runs until it either finishes its execution or voluntarily gives up the CPU (for example, by performing I/O operations). These algorithms tend to be simpler but may result in inefficient CPU utilization in certain situations.
  
- **Preemptive scheduling:** the CPU can be taken away from a running process at any time and allocated to another process, often based on specific time intervals or conditions.

| **Algorithm**                  | **Preemptive** | **Description**                                             | **Advantage**            | **Disadvantage**           |
|---------------------------------|----------------|-------------------------------------------------------------|-------------------------------|---------------------------------|
| **First-Come, First-Served (FCFS)** | No             | Processes execute in arrival order.                         | Simple to implement.          | Poor performance (convoy effect). |
| **Shortest Job First (SJF)**     | No             | Shortest burst time first.                                  | Minimizes average waiting time.| Starvation of long processes.   |
| **Priority Scheduling (Non-preemptive)** | No             | Processes with higher priority execute first.               | Flexible process management.   | Starvation of low-priority processes. |
| **Round Robin (RR)**             | Yes            | Fixed time quantum per process.                             | Fair allocation of CPU time.   | High context switching overhead.|
| **Shortest Remaining Time First (SRTF)** | Yes            | Preemptive version of SJF.                                  | Minimizes waiting time.        | Starvation of longer processes. |
| **Priority Scheduling (Preemptive)** | Yes            | Higher priority processes preempt lower priority ones.      | Can prioritize critical tasks. | Starvation and priority inversion. |
| **Multilevel Queue Scheduling** | Yes/No         | Different queues with different algorithms.                 | Organizes processes by behavior. | Complex to configure and manage.|
| **Multilevel Feedback Queue**   | Yes            | Processes can move between different priority queues.       | Highly adaptive.               | Complex to implement and tune.  |
---

## **Thread:** 
A thread is a part of the process which has its run-time stack and shares the process resources. Every thread in Java is created and controlled by a unique object of the java.lang.Thread class. When a standalone application is run, a user thread is automatically created to execute the main() method and this thread is called the main thread.
- A new thread, or a child process of a given process, can be introduced by using the fork() system call. A process with n fork() system call generates 2^n – 1 child processes.
- There are two types of threads:
  - Kernel threads (Kernel threads are implemented by OS)
  - User threads (User threads are implemented by users)
- Thread creation with `Runnable` Interface:

  ```java
      public class RunnableThread {
        public static int count = 0;
  
        public static void main(String[] args) {
  
            Thread thread = new Thread(() -> {
                System.out.println("RunnableThread starting.");
                try {
                    while (RunnableThread.count < 5) {
                        Thread.sleep(500);
                        RunnableThread.count++;
                    }
                } catch (InterruptedException exc) {
                    System.out.println("RunnableThread interrupted.");
                }
                System.out.println("RunnableThread terminating.");
            });

            System.out.println("Executing start()");
            thread.start();
        }
    }
  ```
---

## Multithreading:
Multithreading in Java is a programming technique that allows multiple threads to run concurrently, sharing the same process. This is particularly useful for performing tasks simultaneously, such as executing background tasks, responding to user input, or improving the performance of computationally intensive programs. 

- Multithreading offers performance benefits but also introduces several challenges:
    - ****Race Conditions:**** Occur when multiple threads access shared data(critical section) concurrently. Overcome using synchronization mechanisms like locks.
    - ****Deadlocks:**** Threads get stuck waiting for each other. Avoid by ordering resource acquisition or using timeouts.
    - ****Synchronization Overhead:**** Excessive synchronization can slow performance. Minimize critical sections and use thread pools (`ExecutorService`).
    - ****Context Switching:**** The cost of switching between threads can reduce performance. Limit the number of threads and keep them busy.
    - ****Starvation:**** is a situation in multithreading where a thread is perpetually denied access to the resources it needs to execute, often because other threads are continuously given priority.
    - ****Livelock:**** In a livelock, two threads are actively trying to avoid deadlock but continually fail to make progress because they keep changing their states without performing useful work.
      
- **Synchronization:** Synchronization in Java is a mechanism used to control access to shared resources by multiple threads. It ensures that only one thread can access a `synchronized` block or method at a time, preventing thread interference and memory consistency issues.
- **Locks:** Locks in Java provide a more flexible mechanism for thread synchronization than traditional synchronization blocks or methods. Unlike intrinsic locks (synchronized), explicit locks provide better control over thread behavior and offer advanced features like fairness policies and condition variables. The `ReentrantLock` is the most commonly used lock in Java. It behaves similarly to synchronized blocks but offers additional features. `ReadWriteLock` and `StampedLock` are other types of locks.

- **Example: Using ReentrantLock**

```java
    import java.util.concurrent.locks.ReentrantLock;

    class SharedResource {
        private ReentrantLock lock = new ReentrantLock();

        void print(String message) {
            lock.lock(); // Acquire the lock
            try {
                System.out.print("[");
                System.out.print(message);
                System.out.println("]");
            } finally {
                lock.unlock(); // Release the lock
            }
        }
    }

    class MyThread extends Thread {
        SharedResource resource;
        String message;

        MyThread(SharedResource resource, String message) {
            this.resource = resource;
            this.message = message;
        }

        public void run() {
            resource.print(message);
        }
    }

    public class ReentrantLockExample {
        public static void main(String[] args) {
            SharedResource resource = new SharedResource();
            MyThread t1 = new MyThread(resource, "Hello");
            MyThread t2 = new MyThread(resource, "World");

            t1.start();
            t2.start();
        }
    }
```
---

### Deadlocks and Deadlock Prevention:
A deadlock is a situation where a thread is waiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds (or an equivalent situation with several threads). Since each thread is waiting for the other thread to relinquish a lock, they both remain waiting forever. The threads are said to be deadlocked.
- In order for a deadlock to occur, you must have all four of the following conditions met:
    - **Mutual Exclusion:** Only one process can access a resource at a given time. (Or, more accurately, there is limited access to a resource. A deadlock could also occur if a resource has limited quantity.)
    - **Hold and Wait:** Processes already holding a resource can request additional resources, without relinquishing their current resources.
    - **No Preemption:** One process cannot forcibly remove another process' resource.
    - **Circular Wait:** Two or more processes form a circular chain where each process is waiting on another resource in the chain.
- Deadlock prevention entails removing any of the above conditions, but it gets tricky because many of these conditions are difficult to satisfy. For instance, removing #1 is difficult because many resources can only be used by one process at a time (e.g., printers). Most deadlock prevention algorithms focus on avoiding condition #4: circular wait.

### Dining Philosophers Problem:
The **Dining Philosophers Problem** is a classic synchronization problem in computer science, where several philosophers are sitting at a round table, thinking and occasionally eating. To eat, a philosopher needs two forks (one on the left and one on the right). However, if two adjacent philosophers pick up the same fork simultaneously, they could end up deadlocked, starving, or conflicting.

#### Approach
1. **Shared resources (forks)**: Each fork is a shared resource between two adjacent philosophers.
2. **Locks**: Use locks (Java's `ReentrantLock`) to ensure mutual exclusion while picking up and putting down the forks.
3. **Philosophers as threads**: Each philosopher is modeled as a thread that alternates between thinking and eating.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    // Number of philosophers
    private static final int NUM_PHILOSOPHERS = 5;

    // Array of forks represented by Locks
    private static final Lock[] forks = new Lock[NUM_PHILOSOPHERS];

    // Initialize the forks (locks)
    static {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public static void main(String[] args) {
        // Create and start philosopher threads
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherId = i;
            new Thread(new Philosopher(philosopherId)).start();
        }
    }

    static class Philosopher implements Runnable {
        private final int id;

        public Philosopher(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    think();
                    // Pick up forks in order: first left, then right
                    pickUpForks();
                    eat();
                    // Put down forks after eating
                    putDownForks();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking.");
            Thread.sleep((long) (Math.random() * 1000)); // Thinking for a while
        }

        private void eat() throws InterruptedException {
            System.out.println("Philosopher " + id + " is eating.");
            Thread.sleep((long) (Math.random() * 1000)); // Eating for a while
        }

        private void pickUpForks() {
            // Pick up the left fork (id) and right fork ((id + 1) % NUM_PHILOSOPHERS)
            Lock leftFork = forks[id];
            Lock rightFork = forks[(id + 1) % NUM_PHILOSOPHERS];

            // Try to lock the forks, avoid deadlock by always locking the lower-index fork first
            if (id % 2 == 0) {
                leftFork.lock();
                rightFork.lock();
            } else {
                rightFork.lock();
                leftFork.lock();
            }
        }

        private void putDownForks() {
            // Put down the forks after eating
            Lock leftFork = forks[id];
            Lock rightFork = forks[(id + 1) % NUM_PHILOSOPHERS];

            leftFork.unlock();
            rightFork.unlock();
        }
    }
}
```
---
