import org.hyperskill.hstest.dynamic.DynamicTest;


import org.hyperskill.hstest.exception.outcomes.WrongAnswer;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("deprecation")
public class LastPencilTest extends StageTest<String> {
    public LastPencilTest() {

        test_data = new Object[][]{
                {5, 1},
                {20, 1},
                {300, 1},
                {5, 2},
                {20, 2},
                {300, 2}
        };
    }

    @DynamicTest
    CheckResult checkOutput() {
        TestedProgram main = new TestedProgram();
        String output = main.start().toLowerCase();
        String[] lines = output.strip().split("\\n");
//Checking the correct solution task "How many pencils?"
//        if (lines.length != 1 || !Pattern.matches("^(how many pencils)\\??:?$|^(how many pencils)[a-zA-Z\\s]*:?\\??$", lines[0])){  - more freedom, but maybe no correct
        if (lines.length != 1 || !Pattern.matches("^(how many pencils would you like to use)\\??:?$", lines[0])) {
            return CheckResult.wrong("When the game starts, it should output only one line asking the user about the " +
                    "amount of pencils they would like to use with the \"How many pencils would you like to use\" string.");
        }
        String output2 = main.execute("1").replaceAll(" ", "");

        //regex
        String whoWillBeRegex = "^(whowillbethefirst).*";
        String playerChecking = ".*\\([a-zA-Z_0-9]+,[a-zA-Z_0-9]+\\):?";

        if (output2.split("\\n").length != 1) {//Checking \n lines
            return CheckResult.wrong("When the user replies with the amount of pencils, the game should print 1 non-empty "
                    + "line asking who will be the first player.\n"
                    + output2.split("\\n").length + " lines were found in the output.");
        }
        output2 = output2.toLowerCase().strip();

        if (!Pattern.matches(whoWillBeRegex, output2)) {//Checking a task "Who will be the first"
            return CheckResult.wrong("Discrepancy with the task, pay attention to the line " +
                    "\"Who will be the first\"");
        }
        if (!Pattern.matches(playerChecking, output2)) {//Checking a task "(Name1, Name2)"
            return CheckResult.wrong("Discrepancy with the task, output example" +
                    " \"Who will be the first (Name1, Name2):\"");
        }
        return CheckResult.correct();
    }

    Object[][] test_data;

    @DynamicTest(data = "test_data")
    CheckResult testGame(int amount, int first) {
        TestedProgram main = new TestedProgram();
        main.start();
        String output2 = main.execute(String.valueOf(amount)).replace(" ", "");

        String leftName = output2.substring(output2.lastIndexOf('(') + 1, output2.lastIndexOf(','));
        String rightName = output2.substring(output2.lastIndexOf(',') + 1, output2.lastIndexOf(')'));

        String firstName;
        if (first == 1) {
            firstName = leftName;
        } else {
            firstName = rightName;
        }
        String output3 = main.execute(firstName).toLowerCase();
//Creates an array for checking "\n"
        String[] lines = output3.strip().split("\n");
//Creates a list for checking empty lines
        List<String> linesNonEmpty = Arrays.stream(lines).filter(s -> s.length() != 0).toList();
//Checking player name
        if (leftName.equals(rightName)) {
            return CheckResult.wrong("The names of the players must be different," +
                    " lines were found in the output: Name1 - \""
                    + leftName + "\" Name2 - \"" + rightName + "\".");
        }
//Checking the number of output lines
        if (linesNonEmpty.size() != 2) { //24.04 Added more informativeness
            return CheckResult.wrong("When the player provides the initial game conditions" +
                    ", your program should print 2 non-empty lines:\n"
                    + "one with with vertical bar symbols representing the number of pencils, " +
                    "the other with the \"" + leftName + "\"(if " + rightName + ") " +
                    "\"is going first\" string.\n"
                    + linesNonEmpty.size() + " lines were found in the output.");
        }
//Create list lines containing | for testing
        List<String> checkPencils = Arrays.stream(lines).filter(s -> s.contains("|")).toList();
        if (checkPencils.size() == 0) {
            return CheckResult.wrong("When the player provides the initial game conditions" +
                    ", your program should print one line with several vertical bar " +
                    "symbols ('|') representing pencils.");
        }
// Checking a string for more than 1 string with |
        if (checkPencils.size() > 1) {
            return CheckResult.wrong("When the player provides the initial game conditions" +
                    ", your program should print only one line with several vertical bar " +
                    "symbols ('|') representing pencils.");
        }
// distinct() makes it possible to get the number of non-unique elements, thus getting 2, the test fails
        if (checkPencils.get(0).chars().distinct().count() != 1) {
            return CheckResult.wrong("The line with pencils should not contain any symbols other than the '|' symbol.");
        }
//Checking for compliance with the amount transferred by the player | Characters
        if (checkPencils.get(0).length() != amount) {
            return CheckResult.wrong("The line with pencils should contain as many '|' symbols as the player provided.");
        }
        //Validation variable for compliance with the selected player
        boolean checkTurn = false;
        for (String s : lines) {
            if (s.toLowerCase().contains(firstName.toLowerCase()) && s.contains("first")) {
                checkTurn = true;
                break;
            }
        }
//Checking for compliance with the selected player
        if (!checkTurn) {
            return CheckResult.wrong("There should be a line in the output that contains the \""
                    + firstName + " is going first!\"" +
                    " string if " + firstName + " is the first player.");
        }
//Checking, if conditions print, but the program then sends a request
        if (!main.isFinished()) {
            return CheckResult.wrong("Your program should not request anything after initial conditions have been printed.");
        }
        return CheckResult.correct();
    }
}