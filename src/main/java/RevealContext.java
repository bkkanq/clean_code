public class RevealContext {
    //Bad Example
    public static void printGuessStatistics(char candidate, int count) {
        String number;
        String verb;
        String pluralModifier;

        if(count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if(count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }
        String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        System.out.println(guessMessage);
    }

    //Recommend
    public static class GuessStatisticMessage {
        public GuessStatisticMessage() {}
        private String number;
        private String verb;
        private String pluralModifier;

        public String make(char candidate, int count) {
            if(count == 0) {
                thereAreNoLetter();
            } else if (count == 1) {
                thereAreOneLetter();
            } else {
                thereAreManyLetter(count);
            }
            return String.format(
                    "There %s %s %s%s", verb, number, candidate, pluralModifier
            );
        }

        private void thereAreNoLetter() {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }

        private void thereAreOneLetter() {
            number = "1";
            verb = "is";
            pluralModifier = "";
        }

        private void thereAreManyLetter(int count) {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }
    }

    public static void main (String args[]) {
        printGuessStatistics('k', 1);

        GuessStatisticMessage guessStatisticMessage = new GuessStatisticMessage();
        System.out.println(guessStatisticMessage.make('w', 1));
    }
}
