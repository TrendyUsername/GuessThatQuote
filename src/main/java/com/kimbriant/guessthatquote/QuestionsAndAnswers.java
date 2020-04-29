package com.kimbriant.guessthatquote;

public class QuestionsAndAnswers {
    private String[] answers;
    private int solution;
    private boolean solved;
    private String quote;

    public QuestionsAndAnswers(String[] answers, int solution, boolean solved, String quote) {
        this.answers = answers;
        this.solution = solution;
        this.solved = solved;
        this.quote = quote;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
