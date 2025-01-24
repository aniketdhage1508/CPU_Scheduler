# CPU Scheduling Algorithms 

## Overview
This project simulates and visualizes **three popular CPU scheduling algorithms** using a graphical user interface (GUI). It allows users to input burst times, the number of processes, and select the desired algorithm to view the scheduling results. Built with **Java Swing**, this project provides an interactive and user-friendly experience for understanding CPU scheduling.

## Features
- **FCFS (First-Come, First-Served)** scheduling algorithm
- **SJF (Shortest Job First)** scheduling algorithm
- **Round Robin** scheduling algorithm with customizable quantum time
- Displays **waiting time** and **turnaround time** for each process
- Calculates and displays the **average waiting time** and **average turnaround time**

## Technologies Used
- **Java Swing** for GUI development
- **Java** for core logic implementation
- **Basic data structures (arrays)** to handle the processes and burst times

## How to Run

1. **Clone the repository**  
   -Run the following command to clone the project:
   -git clone https://github.com/your-username/CPU-Scheduling-Algorithms.git
2. **Navigate to the project folder**
    -Change the directory to the project folder:
    -cd CPU-Scheduling-Algorithms
3. **Compile and run the Java program**
    -Open a terminal or command prompt and navigate to the folder containing the .java files. Then compile and run the program with the following commands:
    -javac CPUSchedulingGUI.java FCFS.java SJF.java RoundRobin.java
    -java CPUSchedulingGUI
