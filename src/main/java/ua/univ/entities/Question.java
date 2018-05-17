package ua.univ.entities;

import java.util.List;

public class Question {
    private int id;
    private String question;
    private List<String> answerVariants;

    public boolean isOkAnswer() {
        return okAnswer;
    }

    public void setOkAnswer(boolean okAnswer) {
        this.okAnswer = okAnswer;
    }

    private boolean okAnswer = false;
    private int indexOfTrueAnswer;
    public Question(int id, String question, List<String> answerVariants, int indexOfTrueAnswer) {
        this.id=id;
        this.question = question;
        this.answerVariants = answerVariants;
        this.indexOfTrueAnswer = indexOfTrueAnswer;
    }
    public int getId() {
        return id;
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

    @Override
    public String toString() {
        String res = question + '\n';
        for (int i = 0; i < answerVariants.size(); i++) {
            res+='\t'+(i+1)+") "+answerVariants.get(i)+'\n';
        }
        return res;
    }
}
