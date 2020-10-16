package src.patternMatch;

class ProgramTest {

    public static void main(String[] args) {
        String[] expected = {"go", "powerranger"};
        String inputPattern = "xxyxxy";
        String inputString = "gogopowerrangergogopowerranger";
        String[] patternList= Program.patternMatcher(inputPattern,inputString);
        System.out.println(patternList[0] +"  "+patternList[1]);
    }
}
