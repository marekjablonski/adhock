TO DO:
 AWS Redshift, Elastic Search

Collection
LIST
rrayList, CopyOnWriteArrayList, LinkedList, Stack and Vector.

Vector
As a quick start, let's present the key differences of ArrayList and Vector. Then, we'll discuss some of the points in more detail:
synchronization – The first major difference between these two. Vector is synchronized and ArrayList isn't.
size growth – Another difference between the two is the way they resize while reaching their capacity. The Vector doubles its size. In contrast, ArrayList increases only by half of its length
iteration – And Vector can use Iterator and Enumeration to traverse over the elements. On the other hand, ArrayList can only use Iterator.
performance – Largely due to synchronization, Vector operations are slower when compared to ArrayList
framework – Also, ArrayList is a part of the Collections framework and was introduced in JDK 1.2. Meanwhile, Vector is present in the earlier versions of Java as a legacy class.

Simply put, a Vector is a resizable array. It can grow and shrink as we add or remove the elements.
We can create a vector in typical fashion:

Vector<String> vector = new Vector<>();

ArrayList vs LinkedList
Summary ArrayList with ArrayDeque are preferable in many more use-cases than LinkedList. If you're not sure — just start with ArrayList.

LinkedList and ArrayList are two different implementations of the List interface. LinkedList implements it with a doubly-linked list. ArrayList implements it with a dynamically re-sizing array.
As with standard linked list and array operations, the various methods will have different algorithmic runtimes.
For LinkedList<E>
get(int index) is O(n) (with n/4 steps on average)
add(E element) is O(1)
add(int index, E element) is O(n) (with n/4 steps on average), but O(1) when index = 0 <--- main benefit of LinkedList<E>
remove(int index) is O(n) (with n/4 steps on average)
Iterator.remove() is O(1). <--- main benefit of LinkedList<E>
ListIterator.add(E element) is O(1) This is one of the main benefits of LinkedList<E>
Note: Many of the operations need n/4 steps on average, constant number of steps in the best case (e.g. index = 0), and n/2 steps in worst case (middle of list)
For ArrayList<E>
get(int index) is O(1) <--- main benefit of ArrayList<E>
add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
add(int index, E element) is O(n) (with n/2 steps on average)
remove(int index) is O(n) (with n/2 steps on average)
Iterator.remove() is O(n) (with n/2 steps on average)
ListIterator.add(E element) is O(n) (with n/2 steps on average)
Note: Many of the operations need n/2 steps on average, constant number of steps in the best case (end of list), n steps in the worst case (start of list)
LinkedList<E> allows for constant-time insertions or removals using iterators, but only sequential access of elements. In other words, you can walk the list forwards or backwards, but finding a position in the list takes time proportional to the size of the list. Javadoc says "operations that index into the list will traverse the list from the beginning or the end, whichever is closer", so those methods are O(n) (n/4 steps) on average, though O(1) for index = 0.
ArrayList<E>, on the other hand, allow fast random read access, so you can grab any element in constant time. But adding or removing from anywhere but the end requires shifting all the latter elements over, either to make an opening or fill the gap. Also, if you add more elements than the capacity of the underlying array, a new array (1.5 times the size) is allocated, and the old array is copied to the new one, so adding to an ArrayList is O(n) in the worst case but constant on average.
So depending on the operations you intend to do, you should choose the implementations accordingly. Iterating over either kind of List is practically equally cheap. (Iterating over an ArrayList is technically faster, but unless you're doing something really performance-sensitive, you shouldn't worry about this -- they're both constants.)
The main benefits of using a LinkedList arise when you re-use existing iterators to insert and remove elements. These operations can then be done in O(1) by changing the list locally only. In an array list, the remainder of the array needs to be moved (i.e. copied). On the other side, seeking in a LinkedList means following the links in O(n) (n/2 steps) for worst case, whereas in an ArrayList the desired position can be computed mathematically and accessed in O(1).
Another benefit of using a LinkedList arise when you add or remove from the head of the list, since those operations are O(1), while they are O(n) for ArrayList. Note that ArrayDeque may be a good alternative to LinkedList for adding and removing from the head, but it is not a List.
Also, if you have large lists, keep in mind that memory usage is also different. Each element of a LinkedList has more overhead since pointers to the next and previous elements are also stored. ArrayLists don't have this overhead. However, ArrayLists take up as much memory as is allocated for the capacity, regardless of whether elements have actually been added.
The default initial capacity of an ArrayList is pretty small (10 from Java 1.4 - 1.8). But since the underlying implementation is an array, the array must be resized if you add a lot of elements. To avoid the high cost of resizing when you know you're going to add a lot of elements, construct the ArrayList with a higher initial capacity.
Make arrayList synchronized.
//Use Collecions.synzhonizedList method
List list = Collections.synchronizedList(new ArrayList());
...

//If you wanna use iterator on the synchronized list, use it
//like this. It should be in synchronized block.
synchronized (list) {
  Iterator iterator = list.iterator();
  while (iterator.hasNext())
      ...
      iterator.next();
      ...
}





SET
ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, LinkedHashSet and TreeSet.

1 EnumSet
EnumSet should always be preferred over any other Set implementation when we are storing enum values.
  Each bit of the long element represents a value of the enum. The i-th value of the enum will be stored in the i-th bit, so it's quite easy to know whether a value is present or not. Since long is a 64-bit data type, this implementation can store up to 64 elements.

2 CopyOnWriteArraySet
It is thread-safe version of HashSet. Each thread accessing the set sees its own version of snapshot of backing array created while initializing the iterator for this set.
Use CopyOnWriteArraySet in applications in which set sizes generally stay small, read-only operations vastly outnumber mutative operations, and you need to prevent interference among threads during traversal.


Concurrency
Processes
A process has a self-contained execution environment. A process generally has a complete, private set of basic run-time resources; in particular, each process has its own memory space.
Processes are often seen as synonymous with programs or applications. However, what the user sees as a single application may in fact be a set of cooperating processes. To facilitate communication between processes, most operating systems support Inter Process Communication (IPC) resources, such as pipes and sockets. IPC is used not just for communication between processes on the same system, but processes on different systems.
Most implementations of the Java virtual machine run as a single process. A Java application can create additional processes using a ProcessBuilder object. Multiprocess applications are beyond the scope of this lesson.
Threads
Threads are sometimes called lightweight processes. Both processes and threads provide an execution environment, but creating a new thread requires fewer resources than creating a new process.
Threads exist within a process — every process has at least one. Threads share the process's resources, including memory and open files. This makes for efficient, but potentially problematic, communication.
Multithreaded execution is an essential feature of the Java platform. Every application has at least one thread — or several, if you count "system" threads that do things like memory management and signal handling. But from the application programmer's point of view, you start with just one thread, called the main thread. This thread has the ability to create additional threads, as we'll demonstrate in the next section.
Each thread is associated with an instance of the class Thread. There are two basic strategies for using Thread objects to create a concurrent application.
To directly control thread creation and management, simply instantiate Thread each time the application needs to initiate an asynchronous task.
To abstract thread management from the rest of your application, pass the application's tasks to an executor.
This section documents the use of Thread objects. Executors are discussed with other high-level concurrency




NON JAVA

OLAP: Online analytical processing
OLAP tools enable users to analyze multidimensional data interactively from multiple perspectives. OLAP consists of three basic analytical operations: consolidation (roll-up), drill-down, and slicing and dicing(Pivot tables are a popular self-service BI tool for slicing and dicing data.).[6]:402-403 Consolidation involves the aggregation of data that can be accumulated and computed in one or more dimensions. For example, all sales offices are rolled up to the sales department or sales division to anticipate sales trends. By contrast, the drill-down is a technique that allows users to navigate through the details. For instance, users can view the sales by individual products that make up a region's sales. Slicing and dicing is a feature whereby users can take out (slicing) a specific set of data of the OLAP cube and view (dicing) the slices from different viewpoints. These viewpoints are sometimes called dimensions (such as looking at the same sales by salesperson, or by date, or by customer, or by product, or by region, etc.)
ETL
In computing, extract, transform, load (ETL) is the general procedure of copying data from one or more sources into a destination system which represents the data differently from the source(s) or in a different context than the source(s). The ETL process became a popular concept in the 1970s and is often used in data warehousing.[1]
