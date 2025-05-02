public class Turing {

    private static final char[] chars = {'a', 'b', 'c', 'd', 'e'};
    private int state = 0;
    private static final int[][] table = {
        {1,9,2,9,9,9}, //0
        {9,3,9,9,9,9}, //1
        {9,9,4,5,6,9}, //2 final
        {7,9,4,5,6,9}, //3 final 
        {2,9,9,9,9,9}, //4 
        {9,9,9,5,6,9}, //5 final
        {9,9,9,9,8,9}, //6
        {9,0,9,9,9,9}, //7
        {9,9,9,9,6,9}, //8 final
        {9,9,9,9,9,9}, //9 erro
    };
    private static final int[] finalStates = {0, 0, 1, 1, 0, 1, 0, 0, 1, 0};

    public Turing(){

    }   

    public String Validate(String word){
        state = 0;
        System.out.println("banaana");
        for(int i = 0; i < word.length(); i++){
            int j;
            for(j = 0; j < chars.length; j++){
                System.out.print(j);
                if(word.charAt(i) == chars[j]){break;}                
            }      
            System.out.print(j);     

            //state = table[state][0];
        }


        return "";
    }
}
