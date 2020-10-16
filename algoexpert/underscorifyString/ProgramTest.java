package underscorifyString;

class ProgramTest {
    //@Test
    public static void main(String[] args) {
       // String expected = "_test_this is a _testtest_ to see if _testestest_ it works";
        String output =
                Program.underscorifySubstring(
                        "ttttttttttttttbtttttctatawtatttttastvb","ttt");
        System.out.println(output);

    }
}