package ua.univ.entities;

import java.util.List;
import java.util.Objects;

public class Test {
    public String getName() {
        return name;
    }

    private String name;

    public String getDescription() {
        return description;
    }

    private String description;

    public List<Question> getQuestions() {
        return questions;
    }

    private List<Question> questions;
    public Test(String name,String description, List<Question> questions) {
        this.name = name;
        this.description=description;
        this.questions = questions;
    }
    public Question getQuestion(int number){
        return questions.get(number);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        String res = name+'\n';
        for (int i = 0; i <questions.size() ; i++) {
            res+=(i+1)+". "+questions.get(i).toString();
        }
        return res;
    }
}
