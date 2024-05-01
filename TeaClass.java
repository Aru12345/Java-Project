import java.util.ArrayList;
import java.util.List;

abstract class TeaClass {
    protected String history;
    protected String overview;

    public TeaClass(String history, String overview) {
        this.history = history;
        this.overview = overview;
    }

    public String getOverview() {
        return this.overview;
    }

    public String getHistory() {
        return this.history;
    }

    public abstract List<String> getQuestions(int difficultyLevel);

    public abstract List<List<String>> getOptions(int difficultyLevel);

}

class Matcha extends TeaClass {

    private List<String> easyQuestions;
    private List<List<String>> easyOptions;
    private List<String> mediumQuestions;
    private List<List<String>> mediumOptions;
    private List<String> difficultQuestions;
    private List<List<String>> difficultOptions;

    public Matcha(String history, String overview) {
        super(history, overview);

        this.history = "Matcha's history is deeply intertwined with Japanese culture and tradition, and its journey from ancient China to modern-day global popularity reflects its enduring appeal and significance.\nToday, matcha continues to be an integral part of Japanese culture and cuisine. It is used in various traditional tea ceremonies, as well as in modern culinary creations such as matcha lattes, desserts, and savory dishes.";
        this.overview = "Japanese Matcha Tea is often made by sifting Matcha with a traditional Japanese Spoon.3000 milligrams.Matcha is whisked in a zig-zag manner in 176 fahrenheint.You can add your favourite sweetner to your tea.! ";

        initializeEasyQuestions();
        initializeEasyOptions();
        initializeMediumQuestions();
        initializeMediumOptions();
        initializeDifficultQuestions();
        initializeDifficultOptions();
    }

    private void initializeEasyQuestions() {
        easyQuestions = new ArrayList<>();
        easyQuestions.add("What is the first step in preparing Matcha Tea?");
        easyQuestions.add("How is the whisking process carried out?");
        easyQuestions.add("What are the options to top off your tea with?");
    }

    private void initializeEasyOptions() {
        easyOptions = new ArrayList<>();
        List<String> q1Options = new ArrayList<>();
        q1Options.add("Sifting Matcha"); // Correct answer
        q1Options.add("Pouring Water");
        q1Options.add("Adding Cinnamon");
        easyOptions.add(q1Options);

        List<String> q2Options = new ArrayList<>();
        q2Options.add("Side to side "); // Correct answer
        q2Options.add("Shake the container upside down");
        q2Options.add("Add some milk then whisk");
        easyOptions.add(q2Options);

        List<String> q3Options = new ArrayList<>();
        q2Options.add("Grape Juice");
        q2Options.add("Soda and Ice");
        q2Options.add("Water and Milk");// Correct answer
        easyOptions.add(q3Options);
    }

    private void initializeMediumQuestions() {
        // Initialize medium questions
        mediumQuestions = new ArrayList<>();
        mediumQuestions.add("What is the first step in preparing Matcha Tea?");
        mediumQuestions.add("What instrument is used to whisk matcha?");
        mediumQuestions.add("How is the whisking process carried out?");
        mediumQuestions.add("What should be the result of whisking?");
        mediumQuestions.add("What are the options to top off your tea with?");
    }

    private void initializeMediumOptions() {
        // Initialize options for medium questions
        mediumOptions = new ArrayList<>();
        List<String> q1Options = new ArrayList<>();
        q1Options.add("Sifting Matcha"); // Correct answer
        q1Options.add("Pouring Water");
        q1Options.add("Adding Cinamon");
        mediumOptions.add(q1Options);

        List<String> q2Options = new ArrayList<>();
        q2Options.add("Spoon");
        q2Options.add("Fork");
        q2Options.add("Chasen");// Correc
        mediumOptions.add(q2Options);

        List<String> q3Options = new ArrayList<>();
        q3Options.add("Side to side s"); // Correct answer
        q3Options.add("Shake the container upside down");
        q3Options.add("Add some milk then whisk");
        mediumOptions.add(q3Options);

        List<String> q4Options = new ArrayList<>();
        q4Options.add("Taste turns sweeter");
        q4Options.add("Foam Layer at top");// Correct
        q4Options.add("Thick Mixture");
        mediumOptions.add(q4Options);

        List<String> q5Options = new ArrayList<>();
        q5Options.add("Grape Juice");
        q5Options.add("Soda and Ice");
        q5Options.add("Water and Milk");// Correct answer
        mediumOptions.add(q5Options);

    }

    private void initializeDifficultQuestions() {
        // Initialize difficult questions
        difficultQuestions = new ArrayList<>();
        difficultQuestions.add("What is the first step in preparing Matcha Tea?");
        difficultQuestions.add("What instrument is used to whisk matcha?");
        difficultQuestions.add("What amount of Matcha you need?");
        difficultQuestions.add("How is the whisking process carried out?");
        difficultQuestions.add("What should be the result of whisking?");
        difficultQuestions.add("Tempreture required?");
        difficultQuestions.add("What are the options to top off your tea with?");

    }

    private void initializeDifficultOptions() {
        // Initialize options for difficult questions
        difficultOptions = new ArrayList<>();
        List<String> q1Options = new ArrayList<>();
        q1Options.add("Sifting Mactha"); // Correct answer
        q1Options.add("Pouring Water");
        q1Options.add("Adding Cinnamon");
        difficultOptions.add(q1Options);

        List<String> q2Options = new ArrayList<>();
        q2Options.add("Spoon");
        q2Options.add("Fork");
        q2Options.add("Chasen"); // Correct answer
        difficultOptions.add(q2Options);

        List<String> q3Options = new ArrayList<>();
        q3Options.add("10gms");
        q3Options.add("5gms");
        q3Options.add("2gms"); // Correct answer
        difficultOptions.add(q3Options);

        List<String> q4Options = new ArrayList<>();
        q4Options.add("Side to side s"); // Correct answer
        q4Options.add("Shake the container upside down");
        q4Options.add("Add some milk then whisk");
        difficultOptions.add(q4Options);

        List<String> q5Options = new ArrayList<>();
        q4Options.add("Taste turns sweeter");
        q4Options.add("Foam Layer at top");// Correct
        q4Options.add("Thick Mixture");
        difficultOptions.add(q5Options);

        List<String> q6Options = new ArrayList<>();
        q6Options.add("90C");
        q6Options.add("80C");// Correct
        q6Options.add("40C");
        difficultOptions.add(q6Options);

        List<String> q7Options = new ArrayList<>();
        q7Options.add("Grape Juice");
        q7Options.add("Soda and Ice");
        q7Options.add("Water and Milk");// Correct answer
        difficultOptions.add(q7Options);
    }

    @Override
    public List<String> getQuestions(int difficultyLevel) {
        switch (difficultyLevel) {
            case 1:
                return easyQuestions;
            case 2:
                return mediumQuestions;
            case 3:
                return difficultQuestions;
            default:
                return null;
        }
    }

    @Override
    public List<List<String>> getOptions(int difficultyLevel) {
        switch (difficultyLevel) {
            case 1:
                return easyOptions;
            case 2:
                return mediumOptions;
            case 3:
                return difficultOptions;
            default:
                return null;
        }
    }
}
