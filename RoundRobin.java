public class RoundRobin {
    private int numProcesses;
    private int[] burstTimes;

    public RoundRobin(int numProcesses, int[] burstTimes) {
        this.numProcesses = numProcesses;
        this.burstTimes = burstTimes;
    }

    public String schedule(int quantum) {
        int[] remainingBurstTimes = new int[numProcesses];
        System.arraycopy(burstTimes, 0, remainingBurstTimes, 0, numProcesses);

        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];

        int currentTime = 0;
        boolean[] isProcessCompleted = new boolean[numProcesses];
        while (true) {
            boolean done = true;
            for (int i = 0; i < numProcesses; i++) {
                if (!isProcessCompleted[i]) {
                    done = false;
                    if (remainingBurstTimes[i] > quantum) {
                        currentTime += quantum;
                        remainingBurstTimes[i] -= quantum;
                    } else {
                        currentTime += remainingBurstTimes[i];
                        waitingTime[i] = currentTime - burstTimes[i];
                        turnaroundTime[i] = currentTime;
                        remainingBurstTimes[i] = 0;
                        isProcessCompleted[i] = true;
                    }
                }
            }
            if (done) break;
        }

        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        StringBuilder result = new StringBuilder("Round Robin Scheduling Result:\n");
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
