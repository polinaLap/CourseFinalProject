package ua.univ.entities;

import java.util.List;

public class Question {
    private String question;
    private List<String> answerVariants;
    private int id;

    public boolean isOkAnswer() {
        return okAnswer;
    }

    public void setOkAnswer(boolean okAnswer) {
        this.okAnswer = okAnswer;
    }

    private boolean okAnswer = false;
    private int indexOfTrueAnswer;
    public Question( String question, List<String> answerVariants, int indexOfTrueAnswer) {

        this.question = question;
        this.answerVariants = answerVariants;
        this.indexOfTrueAnswer = indexOfTrueAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswerVariants() {
        return answerVariants;
    }

    public int getIndexOfTrueAnswer() {
        return indexOfTrueAnswer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
