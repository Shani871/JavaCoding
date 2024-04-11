import java.util.*;

public class Scheduler {
    static char[][] timeline;
    static ArrayList<Triplet<String, Integer, Integer>> processes;
    static int processCount;
    static int lastInstant;
    static int[] finishTime;
    static int[] turnAroundTime;
    static double[] normTurn;
    static HashMap<String, Integer> processToIndex;
    static ArrayList<Pair<Character, Integer>> algorithms;

    static class Triplet<X, Y, Z> {
        X x;
        Y y;
        Z z;

        Triplet(X x, Y y, Z z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Pair<X, Y> {
        X x;
        Y y;

        Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    static String TRACE = "trace";
    static String SHOW_STATISTICS = "stats";
    static String[] ALGORITHMS = {"", "FCFS", "RR-", "SPN", "SRT", "HRRN", "FB-1", "FB-2i", "AGING"};

    static Comparator<Triplet<String, Integer, Integer>> sortByServiceTime = (a, b) -> a.z - b.z;
    static Comparator<Triplet<String, Integer, Integer>> sortByArrivalTime = Comparator.comparingInt(a -> a.y);

    static Comparator<Triplet<String, Double, Integer>> descendinglyByResponseRatio = (a, b) -> {
        return b.y.compareTo(a.y);
    };

    static Comparator<Triplet<Integer, Integer, Integer>> byPriorityLevel = (a, b) -> {
        if (a.x.equals(b.x)) return b.z - a.z;
        return b.x - a.x;
    };

    static void clearTimeline() {
        for (int i = 0; i < lastInstant; i++)
            for (int j = 0; j < processCount; j++)
                timeline[i][j] = ' ';
    }

    static String getProcessName(Triplet<String, Integer, Integer> a) {
        return a.x;
    }

    static int getArrivalTime(Triplet<String, Integer, Integer> a) {
        return a.y;
    }

    static int getServiceTime(Triplet<String, Integer, Integer> a) {
        return a.z;
    }

    static int getPriorityLevel(Triplet<String, Integer, Integer> a) {
        return a.z;
    }

    static double calculateResponseRatio(int waitTime, int serviceTime) {
        return (waitTime + serviceTime) * 1.0 / serviceTime;
    }

    static void fillInWaitTime() {
        for (int i = 0; i < processCount; i++) {
            int arrivalTime = getArrivalTime(processes.get(i));
            for (int k = arrivalTime; k < finishTime[i]; k++) {
                if (timeline[k][i] != '*')
                    timeline[k][i] = '.';
            }
        }
    }

    static void firstComeFirstServe() {
        int time = getArrivalTime(processes.getFirst());
        for (int i = 0; i < processCount; i++) {
            int arrivalTime = getArrivalTime(processes.get(i));
            int serviceTime = getServiceTime(processes.get(i));

            finishTime[i] = (time + serviceTime);
            turnAroundTime[i] = (finishTime[i] - arrivalTime);
            normTurn[i] = (turnAroundTime[i] * 1.0 / serviceTime);

            for (int j = time; j < finishTime[i]; j++)
                timeline[j][i] = '*';
            for (int j = arrivalTime; j < time; j++)
                timeline[j][i] = '.';
            time += serviceTime;
        }
    }

    static void roundRobin(int originalQuantum) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int j = 0;
        if (getArrivalTime(processes.get(j)) == 0) {
            q.add(new Pair<>(j, getServiceTime(processes.get(j))));
            j++;
        }
        int currentQuantum = originalQuantum;
        for (int time = 0; time < lastInstant; time++) {
            if (!q.isEmpty()) {
                int processIndex = q.peek().x;
                q.peek().y = q.peek().y - 1;
                int remainingServiceTime = q.peek().y;
                int arrivalTime = getArrivalTime(processes.get(processIndex));
                int serviceTime = getServiceTime(processes.get(processIndex));
                currentQuantum--;
                timeline[time][processIndex] = '*';
                while (j < processCount && getArrivalTime(processes.get(j)) == time + 1) {
                    q.add(new Pair<>(j, getServiceTime(processes.get(j))));
                    j++;
                }

                if (currentQuantum == 0 && remainingServiceTime == 0) {
                    finishTime[processIndex] = time + 1;
                    turnAroundTime[processIndex] = (finishTime[processIndex] - arrivalTime);
                    normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                    currentQuantum = originalQuantum;
                    q.poll();
                } else if (currentQuantum == 0 && remainingServiceTime != 0) {
                    q.poll();
                    q.add(new Pair<>(processIndex, remainingServiceTime));
                    currentQuantum = originalQuantum;
                } else if (currentQuantum != 0 && remainingServiceTime == 0) {
                    finishTime[processIndex] = time + 1;
                    turnAroundTime[processIndex] = (finishTime[processIndex] - arrivalTime);
                    normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                    q.poll();
                    currentQuantum = originalQuantum;
                }
            }
            while (j < processCount && getArrivalTime(processes.get(j)) == time + 1) {
                q.add(new Pair<>(j, getServiceTime(processes.get(j))));
                j++;
            }
        }
        fillInWaitTime();
    }

    static void shortestProcessNext() {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.y));
        int j = 0;
        for (int i = 0; i < lastInstant; i++) {
            while (j < processCount && getArrivalTime(processes.get(j)) <= i) {
                pq.add(new Pair<>(getServiceTime(processes.get(j)), j));
                j++;
            }
            if (!pq.isEmpty()) {
                int processIndex = pq.peek().y;
                int arrivalTime = getArrivalTime(processes.get(processIndex));
                int serviceTime = getServiceTime(processes.get(processIndex));
                pq.poll();

                int temp = arrivalTime;
                for (; temp < i; temp++)
                    timeline[temp][processIndex] = '.';

                temp = i;
                for (; temp < i + serviceTime; temp++)
                    timeline[temp][processIndex] = '*';

                finishTime[processIndex] = (i + serviceTime);
                turnAroundTime[processIndex] = (finishTime[processIndex] - arrivalTime);
                normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                i = temp - 1;
            }
        }
    }

    static void shortestRemainingTime() {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.x));
        int j = 0;
        for (int i = 0; i < lastInstant; i++) {
            while (j < processCount && getArrivalTime(processes.get(j)) == i) {
                pq.add(new Pair<>(getServiceTime(processes.get(j)), j));
                j++;
            }
            if (!pq.isEmpty()) {
                int processIndex = pq.peek().y;
                int remainingTime = pq.peek().x;
                pq.poll();
                int serviceTime = getServiceTime(processes.get(processIndex));
                int arrivalTime = getArrivalTime(processes.get(processIndex));
                timeline[i][processIndex] = '*';

                if (remainingTime == 1) {
                    finishTime[processIndex] = i + 1;
                    turnAroundTime[processIndex] = (finishTime[processIndex] - arrivalTime);
                    normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                } else {
                    pq.add(new Pair<>(remainingTime - 1, processIndex));
                }
            }
        }
        fillInWaitTime();
    }

    static void highestResponseRatioNext() {
        ArrayList<Triplet<String, Double, Integer>> presentProcesses = new ArrayList<>();
        int j = 0;
        for (int currentInstant = 0; currentInstant < lastInstant; currentInstant++) {
            while (j < processCount && getArrivalTime(processes.get(j)) <= currentInstant) {
                presentProcesses.add(new Triplet<>(getProcessName(processes.get(j)), 1.0, 0));
                j++;
            }

            for (Triplet<String, Double, Integer> proc : presentProcesses) {
                String processName = proc.x;
                int processIndex = processToIndex.get(processName);
                int waitTime = currentInstant - getArrivalTime(processes.get(processIndex));
                int serviceTime = getServiceTime(processes.get(processIndex));
                proc.y = calculateResponseRatio(waitTime, serviceTime);
            }

            presentProcesses.sort(descendinglyByResponseRatio);

            if (!presentProcesses.isEmpty()) {
                int processIndex = processToIndex.get(presentProcesses.get(0).x);
                while (currentInstant < lastInstant && presentProcesses.get(0).z != getServiceTime(processes.get(processIndex))) {
                    timeline[currentInstant][processIndex] = '*';
                    currentInstant++;
                    presentProcesses.getFirst().z++;
                }
                currentInstant--;
                presentProcesses.removeFirst();
                finishTime[processIndex] = currentInstant + 1;
                turnAroundTime[processIndex] = finishTime[processIndex] - getArrivalTime(processes.get(processIndex));
                normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / getServiceTime(processes.get(processIndex)));
            }
        }
        fillInWaitTime();
    }

    static void feedbackQ1() {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.x));
        HashMap<Integer, Integer> remainingServiceTime = new HashMap<>();
        int j = 0;
        if (getArrivalTime(processes.get(0)) == 0) {
            pq.add(new Pair<>(0, j));
            remainingServiceTime.put(j, getServiceTime(processes.get(j)));
            j++;
        }
        for (int time = 0; time < lastInstant; time++) {
            if (!pq.isEmpty()) {
                int priorityLevel = pq.peek().x;
                int processIndex = pq.peek().y;
                int arrivalTime = getArrivalTime(processes.get(processIndex));
                int serviceTime = getServiceTime(processes.get(processIndex));
                pq.poll();
                while (j < processCount && getArrivalTime(processes.get(j)) == time + 1) {
                    pq.add(new Pair<>(0, j));
                    remainingServiceTime.put(j, getServiceTime(processes.get(j)));
                    j++;
                }
                remainingServiceTime.put(processIndex, remainingServiceTime.get(processIndex) - 1);
                timeline[time][processIndex] = '*';
                if (remainingServiceTime.get(processIndex) == 0) {
                    finishTime[processIndex] = time + 1;
                    turnAroundTime[processIndex] = finishTime[processIndex] - arrivalTime;
                    normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                } else {
                    if (pq.size() >= 1)
                        pq.add(new Pair<>(priorityLevel + 1, processIndex));
                    else
                        pq.add(new Pair<>(priorityLevel, processIndex));
                }
            }
            while (j < processCount && getArrivalTime(processes.get(j)) == time + 1) {
                pq.add(new Pair<>(0, j));
                remainingServiceTime.put(j, getServiceTime(processes.get(j)));
                j++;
            }
        }
        fillInWaitTime();
    }

    static void feedbackQ2i() {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.x));
        HashMap<Integer, Integer> remainingServiceTime = new HashMap<>();
        int j = 0;
        if (getArrivalTime(processes.get(0)) == 0) {
            pq.add(new Pair<>(0, j));
            remainingServiceTime.put(j, getServiceTime(processes.get(j)));
            j++;
        }
        for (int time = 0; time < lastInstant; time++) {
            if (!pq.isEmpty()) {
                int priorityLevel = pq.peek().x;
                int processIndex = pq.peek().y;
                int arrivalTime = getArrivalTime(processes.get(processIndex));
                int serviceTime = getServiceTime(processes.get(processIndex));
                pq.poll();
                while (j < processCount && getArrivalTime(processes.get(j)) <= time + 1) {
                    pq.add(new Pair<>(0, j));
                    remainingServiceTime.put(j, getServiceTime(processes.get(j)));
                    j++;
                }

                int currentQuantum = (int) Math.pow(2, priorityLevel);
                int temp = time;
                while (currentQuantum > 0 && remainingServiceTime.get(processIndex) > 0) {
                    currentQuantum--;
                    remainingServiceTime.put(processIndex, remainingServiceTime.get(processIndex) - 1);
                    timeline[temp++][processIndex] = '*';
                }

                if (remainingServiceTime.get(processIndex) == 0) {
                    finishTime[processIndex] = temp;
                    turnAroundTime[processIndex] = finishTime[processIndex] - arrivalTime;
                    normTurn[processIndex] = (turnAroundTime[processIndex] * 1.0 / serviceTime);
                } else {
                    if (pq.size() >= 1)
                        pq.add(new Pair<>(priorityLevel + 1, processIndex));
                    else
                        pq.add(new Pair<>(priorityLevel, processIndex));
                }
                time = temp - 1;
            }
            while (j < processCount && getArrivalTime(processes.get(j)) <= time + 1) {
                pq.add(new Pair<>(0, j));
                remainingServiceTime.put(j, getServiceTime(processes.get(j)));
                j++;
            }
        }
        fillInWaitTime();
    }

    static void aging(int originalQuantum) {
        ArrayList<Triplet<Integer, Integer, Integer>> v = new ArrayList<>();
        int j = 0, currentProcess = -1;
        for (int time = 0; time < lastInstant; time++) {
            while (j < processCount && getArrivalTime(processes.get(j)) <= time) {
                v.add(new Triplet<>(getPriorityLevel(processes.get(j)), j, 0));
                j++;
            }

            for (int i = 0; i < v.size(); i++) {
                if (v.get(i).y == currentProcess) {
                    v.get(i).z = 0;
                    v.get(i).x = getPriorityLevel(processes.get(currentProcess));
                } else {
                    v.get(i).x++;
                    v.get(i).z++;
                }
            }
            v.sort((a, b) -> {
                if (a.x.equals(b.x))
                    return b.z.compareTo(a.z);
                return b.x.compareTo(a.x);
            });
            currentProcess = v.get(0).y;
            int currentQuantum = originalQuantum;
            int temp = time;
            while (currentQuantum-- > 0 && time < lastInstant) {
                timeline[time][currentProcess] = '*';
                time++;
            }
            time--;
        }
        fillInWaitTime();
    }

    static void printAlgorithm(int algorithmIndex) {
        int algorithmId = algorithms.get(algorithmIndex).x - '0';
        if (algorithmId == 2)
            System.out.println(ALGORITHMS[algorithmId] + algorithms.get(algorithmIndex).y);
        else
            System.out.println(ALGORITHMS[algorithmId]);
    }

    static void printProcesses() {
        System.out.print("Process    ");
        for (int i = 0; i < processCount; i++)
            System.out.print("|  " + getProcessName(processes.get(i)) + "  ");
        System.out.println("|");
    }

    static void printArrivalTime() {
        System.out.print("Arrival    ");
        for (int i = 0; i < processCount; i++)
            System.out.printf("|%3d  ", getArrivalTime(processes.get(i)));
        System.out.println("|");
    }

    static void printServiceTime() {
        System.out.print("Service    |");
        for (int i = 0; i < processCount; i++)
            System.out.printf("%3d  |", getServiceTime(processes.get(i)));
        System.out.println(" Mean|");
    }

    static void printFinishTime() {
        System.out.print("Finish     ");
        for (int i = 0; i < processCount; i++)
            System.out.printf("|%3d  ", finishTime[i]);
        System.out.println("|-----|");
    }

    static void printTurnAroundTime() {
        System.out.print("Turnaround |");
        int sum = 0;
        for (int i = 0; i < processCount; i++) {
            System.out.printf("%3d  |", turnAroundTime[i]);
            sum += turnAroundTime[i];
        }
        if ((1.0 * sum / turnAroundTime.length) >= 10)
            System.out.printf("%2.2f|\n", (1.0 * sum / turnAroundTime.length));
        else
            System.out.printf(" %2.2f|\n", (1.0 * sum / turnAroundTime.length));
    }

    static void printNormTurn() {
        System.out.print("NormTurn   |");
        float sum = 0;
        for (int i = 0; i < processCount; i++) {
            if (normTurn[i] >= 10)
                System.out.printf("%2.2f|", normTurn[i]);
            else
                System.out.printf(" %2.2f|", normTurn[i]);
            sum += normTurn[i];
        }

        if ((1.0 * sum / normTurn.length) >= 10)
            System.out.printf("%2.2f|\n", (1.0 * sum / normTurn.length));
        else
            System.out.printf(" %2.2f|\n", (1.0 * sum / normTurn.length));
    }

    static void printStats(int algorithmIndex) {
        printAlgorithm(algorithmIndex);
        printProcesses();
        printArrivalTime();
        printServiceTime();
        printFinishTime();
        printTurnAroundTime();
        printNormTurn();
    }

    static void printTimeline(int algorithmIndex) {
        for (int i = 0; i <= lastInstant; i++)
            System.out.print(i % 10 + " ");
        System.out.println();
        System.out.println("------------------------------------------------");
        for (int i = 0; i < processCount; i++) {
            System.out.print(getProcessName(processes.get(i)) + "     |");
            for (int j = 0; j < lastInstant; j++) {
                System.out.print(timeline[j][i] + "|");
            }
            System.out.println(" ");
        }
        System.out.println("------------------------------------------------");
    }

    static void executeAlgorithm(char algorithmId, int quantum, String operation) {
        switch (algorithmId) {
            case '1':
                if (operation.equals(TRACE)) System.out.print("FCFS  ");
                firstComeFirstServe();
                break;
            case '2':
                if (operation.equals(TRACE)) System.out.print("RR-" + quantum + "  ");
                roundRobin(quantum);
                break;
            case '3':
                if (operation.equals(TRACE)) System.out.print("SPN   ");
                shortestProcessNext();
                break;
            case '4':
                if (operation.equals(TRACE)) System.out.print("SRT   ");
                shortestRemainingTime();
                break;
            case '5':
                if (operation.equals(TRACE)) System.out.print("HRRN  ");
                highestResponseRatioNext();
                break;
            case '6':
                if (operation.equals(TRACE)) System.out.print("FB-1  ");
                feedbackQ1();
                break;
            case '7':
                if (operation.equals(TRACE)) System.out.print("FB-2i ");
                feedbackQ2i();
                break;
            case '8':
                if (operation.equals(TRACE)) System.out.print("Aging ");
                aging(quantum);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        parse();
        for (int i = 0; i < algorithms.size(); i++) {
            executeAlgorithm(algorithms.get(i).x, algorithms.get(i).y, SHOW_STATISTICS);
            printStats(i);
            if (i != algorithms.size() - 1) System.out.println();
        }
        for (int i = 0; i < algorithms.size(); i++) {
            executeAlgorithm(algorithms.get(i).x, algorithms.get(i).y, TRACE);
            printTimeline(i);
            if (i != algorithms.size() - 1) System.out.println();
        }
    }

    static void parse() {
        Scanner scanner = new Scanner(System.in);
        int tempProcessCount = scanner.nextInt();
        processCount = tempProcessCount;
        timeline = new char[100][100];
        processes = new ArrayList<>(processCount);
        finishTime = new int[processCount];
        turnAroundTime = new int[processCount];
        normTurn = new double[processCount];
        processToIndex = new HashMap<>();
        algorithms = new ArrayList<>();
        lastInstant = 0;
        for (int i = 0; i < processCount; i++) {
            String name = scanner.next();
            int arrivalTime = scanner.nextInt();
            int serviceTime = scanner.nextInt();
            processes.add(new Triplet<>(name, arrivalTime, serviceTime));
            lastInstant = Math.max(lastInstant, arrivalTime + serviceTime);
            processToIndex.put(name, i);
        }
        int algorithmCount = scanner.nextInt();
        for (int i = 0; i < algorithmCount; i++) {
            String algoString = scanner.next();
            if (algoString.equals("RR")) {
                algorithms.add(new Pair<>(algoString.charAt(0), scanner.nextInt()));
            } else {
                algorithms.add(new Pair<>(algoString.charAt(0), 0));
            }
        }
        scanner.close();
        Collections.sort(processes, sortByArrivalTime);
    }
}
