import java.util.ArrayList;
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

        JButton analyzeButton = new JButton("Analisar");
        analyzeButton.setBounds(sizeX-260, 150, 100, 30);
        analyzeButton.addActionListener(e -> {            
            ArrayList<String> tokens = splitString(inputBox.getText());           
            ArrayList<String> tokenClassification = new ArrayList<>();

            Turing validator = new Turing();

            for (String token : tokens) {
                if(token.equals("")){break;}
                if(token.charAt(0) == '*' || token.charAt(0) == '+' || token.charAt(0) == '/' || token.charAt(0) == '-' ){
                    tokenClassification.add("operador aritmético: ");
                }else{
                    if(token.charAt(0) != 'a' & token.charAt(0) != 'b' & token.charAt(0) != 'c' & token.charAt(0) != 'd' & token.charAt(0) != 'e'){
                        tokenClassification.add("ERRO: símbolo(s) inválido(s): ");
                    }
                    else{
                        tokenClassification.add(validator.Validate(token));
                    }
                }
            }
            String outputString = "";

            for(int i = 0; i < tokens.size(); i++){
                outputString += tokenClassification.get(i) + tokens.get(i) + "\n";
            }    
            outputBox.setText(outputString);
        }           
                 
        );
        frame.add(analyzeButton);

        frame.setVisible(true);
    }

    public static ArrayList<String> splitString(String input){  
        ArrayList<String> tokens = new ArrayList<>();  
        String token = "";
        for (char tokenChar : input.toCharArray()){            
            if (tokenChar == '*' || tokenChar == '+' || tokenChar == '/' || tokenChar == '-' ){
                if(!token.isEmpty()){
                    tokens.add(token);
                    token = "";
                }
                tokens.add(Character.toString(tokenChar));
            }
            else if (tokenChar == ' ' || tokenChar == '\n' || tokenChar == '\t'){
                if(!token.isEmpty()){
                    tokens.add(token);
                    token = "";
                }
            }
            else {
                token += tokenChar;
            }
        }
        if(!token.isEmpty())tokens.add(token);
        return tokens;
    }
}
