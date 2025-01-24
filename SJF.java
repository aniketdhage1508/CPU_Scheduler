import java.util.Arrays;

public class SJF {
    private int numProcesses;
    private int[] burstTimes;

    public SJF(int numProcesses, int[] burstTimes) {
        this.numProcesses = numProcesses;
        this.burstTimes = burstTimes;
    }

    public String schedule() {
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];

        int[] sortedBurstTimes = Arrays.copyOf(burstTimes, burstTimes.length);
        Arrays.sort(sortedBurstTimes);

        waitingTime[0] = 0;
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = sortedBurstTimes[i - 1] + waitingTime[i - 1];
        }

        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = sortedBurstTimes[i] + waitingTime[i];
        }

        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        StringBuilder result = new StringBuilder("SJF Scheduling Result:\n");
        result.append("Process\tBurst Time\tWaiting Time\tTurnaround Time\n");

        for (int i = 0; i < numProcesses; i++) {
            result.append(i + 1).append("\t").append(sortedBurstTimes[i]).append("\t").append(waitingTime[i])
                    .append("\t").append(turnaroundTime[i]).append("\n");
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        result.append("\nAverage Waiting Time: ").append(totalWaitingTime / numProcesses);
        result.append("\nAverage Turnaround Time: ").append(totalTurnaroundTime / numProcesses);

        return result.toString();
    }
}
