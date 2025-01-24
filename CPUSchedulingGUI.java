import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPUSchedulingGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CPU Scheduling");
        frame.setSize(450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 240)); // Set background color

        // Title label
        JLabel titleLabel = new JLabel("CPU Scheduling Algorithms");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        // Input for number of processes
        JLabel label1 = new JLabel("Enter number of processes:");
        label1.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField numProcessesField = new JTextField(5);
        numProcessesField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Input for burst times
        JLabel label2 = new JLabel("Enter burst times (space-separated):");
        label2.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField burstTimesField = new JTextField(20);
        burstTimesField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Dropdown for algorithm selection
        String[] algorithms = { "FCFS", "SJF", "Round Robin" };
        JComboBox<String> algorithmComboBox = new JComboBox<>(algorithms);
        algorithmComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        algorithmComboBox.setBackground(new Color(255, 255, 255));

        // Button to run scheduling
        JButton runButton = new JButton("Run Scheduling");
        runButton.setFont(new Font("Arial", Font.BOLD, 14));
        runButton.setBackground(new Color(30, 144, 255));
        runButton.setForeground(Color.WHITE);
        runButton.setPreferredSize(new Dimension(200, 40));

        // Text area to display results
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setBackground(new Color(240, 240, 240));
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to the panel
        panel.add(titleLabel);
        panel.add(label1);
        panel.add(numProcessesField);
        panel.add(label2);
        panel.add(burstTimesField);
        panel.add(algorithmComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        panel.add(runButton);
        panel.add(scrollPane);

        // Set up the frame
        frame.add(panel);
        frame.setVisible(true);

        // Action listener for the button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numProcesses = Integer.parseInt(numProcessesField.getText());
                    String[] burstTimesStr = burstTimesField.getText().split(" ");
                    int[] burstTimes = new int[burstTimesStr.length];
                    for (int i = 0; i < burstTimesStr.length; i++) {
                        burstTimes[i] = Integer.parseInt(burstTimesStr[i]);
                    }

                    String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
                    String result = "";

                    switch (selectedAlgorithm) {
                        case "FCFS":
                            FCFS fcfs = new FCFS(numProcesses, burstTimes);
                            result = fcfs.schedule();
                            break;
                        case "SJF":
                            SJF sjf = new SJF(numProcesses, burstTimes);
                            result = sjf.schedule();
                            break;
                        case "Round Robin":
                            RoundRobin rr = new RoundRobin(numProcesses, burstTimes);
                            result = rr.schedule(4); // Assuming quantum time as 4
                            break;
                    }

                    resultArea.setText(result);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter valid numbers.");
                }
            }
        });
    }
}
