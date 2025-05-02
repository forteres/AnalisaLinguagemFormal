import javax.swing.*;

public class main {
    public static void main(String[] args) {
        // Create the main window

        int sizeX = 700;
        int sizeY = 400;
        int width = 600;

        JFrame frame = new JFrame("reconhecedor de linguagem regular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX, sizeY);
        frame.setLayout(null);

        JTextArea inputBox = new JTextArea();
        JScrollPane inputBoxScrollPane = new JScrollPane(inputBox);
        inputBoxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputBoxScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        inputBoxScrollPane.setBounds(sizeX/2-width/2, 20, width, 120);      
        frame.add(inputBoxScrollPane);

        JTextArea outputBox = new JTextArea("Read-only text");
        JScrollPane outputBoxScrollPane = new JScrollPane(outputBox);
        outputBoxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputBoxScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        outputBoxScrollPane.setBounds(sizeX/2-width/2, 190, width, 120);
        outputBox.setEditable(false);
        frame.add(outputBoxScrollPane);

        JButton cleanButton = new JButton("Limpar");
        cleanButton.setBounds(sizeX-150, 150, 100, 30);
        cleanButton.addActionListener(e -> {
            inputBox.setText("");
            outputBox.setText("");
        });
        frame.add(cleanButton);

        JButton analyzeButton = new JButton("Click Me2");
        analyzeButton.setBounds(sizeX-260, 150, 100, 30);
        analyzeButton.addActionListener(e -> {
            String tempWords = inputBox.getText();

            //separa strings em strings menores
            Turing porra = new Turing();
            porra.Validate("abcdz");

            

            //String input = inputBox.getText();
            //outputBox.setText("You typed: " + input);
        });
        frame.add(analyzeButton);

        frame.setVisible(true);
    }
}
