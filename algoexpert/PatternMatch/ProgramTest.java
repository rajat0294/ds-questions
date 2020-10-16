package PatternMatch;

class ProgramTest {

    public static void main(String[] args) {
        String[] expected = {"go", "powerranger"};
        String inputPattern = "yxyx";
        String inputString = "abab";
        Program.patternMatcher(inputPattern, inputString);
    }
}