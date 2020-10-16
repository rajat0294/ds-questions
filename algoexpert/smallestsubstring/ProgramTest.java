package smallestsubstring;

public class ProgramTest {
    public static void main(String[] args) {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";
        String expected = "f$axb$";
        System.out.println(Program.smallestSubstringContaining(bigString, smallString));
    }
}
