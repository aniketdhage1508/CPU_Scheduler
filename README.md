#CPU Scheduling Algorithms GUI
This project implements a graphical user interface (GUI) for simulating three popular CPU scheduling algorithms: FCFS, SJF, and Round Robin. It is built using Java Swing and allows users to input burst times, the number of processes, and select an algorithm to view the scheduling results.

Features
FCFS (First-Come, First-Served) scheduling algorithm.
SJF (Shortest Job First) scheduling algorithm.
Round Robin scheduling algorithm with customizable quantum time.
Displays waiting time and turnaround time for each process.
Calculates and displays the average waiting time and average turnaround time.
Technologies Used
Java Swing for the GUI.
Java for core logic implementation.
Basic data structures (arrays) to handle the processes and burst times.

How to Run
Clone the repository:

git clone https://github.com/your-username/CPU-Scheduling-Algorithms.git

Navigate to the project folder:

cd CPU-Scheduling-Algorithms
Compile and run the Java program:

Open a terminal or command prompt.

Navigate to the folder containing the project files (where the .java files are located).

Use the following commands to compile and run the program:

javac CPUSchedulingGUI.java FCFS.java SJF.java RoundRobin.java
java CPUSchedulingGUI
Input values in the GUI:

Enter the number of processes.
Enter the burst times as space-separated values.
Select a scheduling algorithm from the dropdown.
Click Run Scheduling to see the results.

