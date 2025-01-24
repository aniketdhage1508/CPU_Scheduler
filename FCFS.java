public class FCFS {
    private int numProcesses;
    private int[] burstTimes;

    public FCFS(int numProcesses, int[] burstTimes) {
        this.numProcesses = numProcesses;
        this.burstTimes = burstTimes;
    }

    public String schedule() {
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];

        waitingTime[0] = 0;
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = burstTimes[i - 1] + waitingTime[i - 1];
        }

        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = burstTimes[i] + waitingTime[i];
        }

        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        StringBuilder result = new StringBuilder("FCFS Scheduling Result:\n");
        result.append("Process\tBurst Time\tWaiting Time\tTurnaround Time\n");

        for (int i = 0; i < numProcesses; i++) {
            result.append(i + 1).append("\t").append(burstTimes[i]).append("\t").append(waitingTime[i])
                    .append("\t").append(turnaroundTime[i]).append("\n");
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        result.append("\nAverage Waiting Time: ").append(totalWaitingTime / numProcesses);
        result.append("\nAverage Turnaround Time: ").append(totalTurnaroundTime / numProcesses);

        return result.toString();
    }
}
