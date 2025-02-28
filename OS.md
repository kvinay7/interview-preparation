# Operating Systems
An operating system is a software which is an interface between user and hardware. It is responsible for the execution of all the processes, Resource Allocation, CPU management, File Management and many other tasks. The purpose of an operating system is to provide an environment in which a user can execute programs in a convenient and efficient manner. 

<div align="center">
  <img src="https://media.geeksforgeeks.org/wp-content/uploads/20230510120545/OS1.webp" alt="OS">
</div>

- **Kernel:** is the core part of the operating system. It directly interacts with the hardware and provides low-level services such as process management, memory management, device management, and other tasks.

- **System calls:** provide an interface for user-level applications to interact with the kernel. When a program needs to access hardware or perform a privileged operation, it invokes a system call.

- **Shell:** is a command-line interface or program that allows users to interact with the OS by entering commands. The shell interprets user commands and passes them to the OS for execution.

- **User Mode:** Programs in user mode are limited. They can only use safe, predefined operations and cannot directly access hardware (like CPU, memory, or disk). If they need something that requires special permissions (e.g., reading a file, printing something), they ask the Operating System (OS) for help with system calls.

- **Kernal Mode:** In kernel mode, the OS can do anything—it can access hardware, manage memory, and handle sensitive operations like saving files or controlling devices like your printer.

- **Booting:** is the process of loading an operating system. It’s the process that starts when we turn on the computer (using the power button or by a software command) and ends when the operating system is loaded into the memory.
    
### What happens when we turn on computer? (computer boot process)
1. Power is supplied → Motherboard and components wake up.
2. CPU locates BIOS/UEFI firmware in ROM and starts execute it.
3. BIOS/UEFI runs POST (power-on-self-test) to ensure hardware is working.
4. BIOS/UEFI loads bootloader from storage and hands over control to it.
5. Operating System `kernel` is loaded into main memory from storage device by Bootloader.
6. Drivers and system services are initialized. Login screen or desktop is displayed.

### How Interrupts Work:
1. Interrupt Occurs: A hardware device or software process triggers an interrupt.
2. Interrupt Request (IRQ): The interrupt request is sent to the interrupt controller, which informs the OS.
3. Interrupt Acknowledgment: The CPU acknowledges the interrupt, saves the current execution context (e.g., registers, program counter), and begins executing the ISR.
4. Interrupt Handling: The Interrupt Service Routine (ISR) performs necessary tasks, such as reading data from I/O devices, handling system calls, or responding to errors.
5. Context Restoration: After the ISR finishes, the CPU restores the previous execution context (using a context switch) and continues where it left off.

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
  Scheduler chooses processes that must be run, the dispatcher is in charge of passing these processes to the CPU.
                                           
                      Resource                Preemption
      +------------+ Allocation +-----------+ <--------- +-----------+   exit    +------------+
      |   New      | ---------> |   Ready   | ---------> |  Running  |---------> | Terminated |
      +------------+ (Admitted) +-----------+ scheduler  +-----------+ resource  +------------+
                                    ^         dispatch          |     deallocation
                    I/O completion  |                           | 
                            +-----------------+                 |
                            | Waiting/Blocked | <---------------- waiting for I/O
                            +-----------------+              

 - **Process Execution Flow**:
   - Program loaded → Process created (PCB initialized).
   - Process enters "Ready" state → Scheduled → Dispatched to "Running."
   - Executes until completion, interruption, or waiting for I/O.
   - Terminates → Resources freed. 
 
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
    - ****Priority inversion:**** occurs when a lower-priority thread holds a resource that a higher-priority thread is waiting for, effectively inverting the intended priority order.
      
## **Synchronization:** 
Synchronization in Java is a mechanism used to control access to shared resources by multiple threads from the `java.util.concurrent` package. It ensures that only one thread can access a `synchronized` block or method at a time, preventing thread interference and memory consistency issues.

### The Critical Section Problem:
- **Critical Section:** The portion of the code in the program where shared variables are accessed and/or updated.
- **Remainder Section:** The remaining portion of the program excluding the Critical Section.
- **Race around Condition:** The final output of the code depends on the order in which the variables are accessed. This is termed as the race around condition.

### A solution for the critical section problem must satisfy the following three conditions:
- **Mutual Exclusion:** If a process Pi is executing in its critical section, then no other process is allowed to enter into the critical section.
- **Progress:** If no process is executing in the critical section, then the decision of a process to enter a critical section cannot be made by any other process that is executing in its remainder section. The selection of the process cannot be postponed indefinitely.
- **Bounded Waiting:** There exists a bound on the number of times other processes can enter into the critical section after a process has made a request to access the critical section and before the request is granted.
- **Architectural Neutrality:** Platform independent

### 1. **Mutex with `synchronized` Block**
A simple way to ensure mutual exclusion in Java is by using the `synchronized` keyword, which locks a method or block of code so that only one thread can execute it at a time. If one thread is using `critical section` (shared resources) than other threads can't use that c.s.

#### Example: Thread-Safe Counter
```java
class Counter {
    private int count = 0;

    // Synchronized method to ensure mutual exclusion
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Final count: " + counter.getCount()); // Should be 2000
    }
}
```

### 2. **Semaphore**
Semaphore is a protected variable or abstract data type that is used to lock the resource being used. The value of the semaphore indicates the status of a common resource.

#### There are two types of semaphores:
- **Binary semaphores:** take only 0 and 1 as value and are used to implement mutual exclusion and synchronize concurrent processes.)
- **Counting semaphores:** is an integer variable whose value can range over an unrestricted domain.)

#### Example: Bounded Buffer (Producer-Consumer Problem)
```java
import java.util.concurrent.Semaphore;

class BoundedBuffer {
    private int[] buffer;
    private int count = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty;
    private Semaphore full;

    public BoundedBuffer(int size) {
        buffer = new int[size];
        empty = new Semaphore(size);
        full = new Semaphore(0);
    }

    public void produce(int value) throws InterruptedException {
        empty.acquire();  // Wait for space
        mutex.acquire();  // Enter critical section
        
        buffer[count] = value;
        count++;
        
        mutex.release();  // Exit critical section
        full.release();   // Signal that there's an item to consume
    }

    public int consume() throws InterruptedException {
        full.acquire();  // Wait for an item to consume
        mutex.acquire(); // Enter critical section
        
        count--;
        int value = buffer[count];
        
        mutex.release(); // Exit critical section
        empty.release();  // Signal that there's space
        
        return value;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer(10);
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    buffer.produce(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    int value = buffer.consume();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
    }
}
```

### 3. **Condition Variable**
Java provides `wait()`, `notify()`, and `notifyAll()` methods to facilitate inter-thread communication. These methods are often used in conjunction with `synchronized` blocks.

#### Example: Producer-Consumer
```java
class SharedResource {
    private int item;
    private boolean available = false;

    // Consumer thread waits until the item is available
    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();  // Wait for item to become available
        }
        available = false;  // Consume the item
        notify();  // Notify producer that space is available
        return item;
    }

    // Producer thread waits until space is available
    public synchronized void produce(int item) throws InterruptedException {
        while (available) {
            wait();  // Wait for space to become available
        }
        this.item = item;  // Produce the item
        available = true;
        notify();  // Notify consumer that item is available
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.produce(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int value = resource.consume();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
    }
}
```

### 4. **Read-Write Locks**
Locks in Java provide a more flexible mechanism for thread synchronization than traditional synchronization blocks or methods. Unlike intrinsic locks (synchronized), explicit locks provide better control over thread behavior and offer advanced features like fairness policies and condition variables. The `ReentrantLock` is the most commonly used lock in Java. It behaves similarly to synchronized blocks but offers additional features. `ReadWriteLock` and `StampedLock` are other types of locks.

#### Example: Read-Write Lock
```java
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockExample {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int sharedData = 0;

    // Read operation: Multiple threads can read simultaneously
    public int read() {
        lock.readLock().lock();
        try {
            return sharedData;
        } finally {
            lock.readLock().unlock();
        }
    }

    // Write operation: Only one thread can write at a time
    public void write(int value) {
        lock.writeLock().lock();
        try {
            sharedData = value;
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample example = new ReadWriteLockExample();
        
        // Reader threads
        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reader 1: " + example.read());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        
        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reader 2: " + example.read());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        
        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.write(i);
                System.out.println("Writer: " + i);
                try { Thread.sleep(300); } catch (InterruptedException e) {}
            }
        });

        reader1.start();
        reader2.start();
        writer.start();

        reader1.join();
        reader2.join();
        writer.join();
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

## Memory Management
Memory management is a critical function of an operating system (OS) that ensures efficient allocation, tracking, and deallocation of a computer’s memory resources for executing processes. It’s all about managing the main memory (RAM) so that each process has enough space to run while maximizing system performance and stability.

### 1. Key Concepts in Memory Management
#### i. Physical vs. Virtual Memory
- **Physical Memory:** The actual RAM hardware where data and instructions reside.
- **Virtual Memory:** An abstraction that gives each process its own address space, making it seem like it has exclusive access to memory. Virtual memory is mapped to physical memory by the OS, often using paging or segmentation. Virtual memory allows systems to use disk space (swap space) as an extension of RAM when physical memory runs out.

#### ii. Memory Allocation  
- When a process is created, the OS allocates memory for its components:
  - Code (Text): The executable instructions.
  - Data: Variables and constants.
  - Stack: Temporary storage for function calls and local variables.
  - Heap: Dynamic memory allocation during runtime.
- Allocation can be contiguous (one continuous block) or non-contiguous (scattered blocks).

### 2. Memory Management Techniques
#### i. Contiguous Memory Allocation  
- **Fixed Partitioning:** Memory is divided into fixed-size partitions; each partition holds one process.
  - Pros: Simple to implement.
  - Cons: Leads to internal fragmentation (unused space within a partition).
- **Dynamic Partitioning:** Partitions are created dynamically based on process size.
  - Pros: Flexible.
  - Cons: Causes external fragmentation (small, unusable gaps between allocated blocks).

#### ii. Non-Contiguous Memory Allocation
- **Paging:** Memory is divided into fixed-size units called pages (virtual memory) and frames (physical memory), typically 4KB each. A process’s virtual address space is split into pages, mapped to physical frames via a page table.
  - Page Table: Maintained by the OS, it translates virtual page numbers to physical frame numbers.
  - Pros: No external fragmentation; easy to swap pages to disk.
  - Cons: Small internal fragmentation within pages; page table overhead.

- **Segmentation:** Memory is divided into variable-sized segments based on logical divisions (e.g., code, data, stack). Each segment has a base address and limit, tracked in a segment table.
  - Pros: Matches the program’s logical structure; no internal fragmentation.
  - Cons: Can lead to external fragmentation.

- **Demand Paging (Part of Virtual Memory):** Pages are loaded into memory only when needed (on demand), rather than all at once. If a process accesses a page not in memory, a page fault occurs, and the OS retrieves it from disk (swap space).
  - Pros: Saves memory by loading only whats necessary.
  - Cons: Page faults can slow execution if frequent (thrashing).

- **Page Replacement:** When memory is full and a new page needs to be loaded, the OS decides which existing page to swap out using algorithms like:
  - FIFO (First-In-First-Out): Replace the oldest page.
  - LRU (Least Recently Used): Replace the page not used for the longest time.
  - Optimal: Replace the page that won’t be needed for the longest time (theoretical ideal).

### 3. Memory Management in Action
- Process Loading: The OS allocates memory (e.g., via paging), maps virtual addresses, and loads the process.
- Execution: The process accesses virtual addresses, translated by the MMU to physical locations.
- Swapping: If memory is scarce, inactive processes or pages are moved to disk (swap space).
- Deallocation: When a process terminates, its memory is freed and marked available.
