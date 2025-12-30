package condorcet.be.demo1.service;

import condorcet.be.demo1.model.Question;

import java.util.List;

public enum QuizService {
    INSTANCE;

        private final List<Question> questions;

        QuizService() {
            questions = List.of(
                    new Question(
                            1,
                            "Qui est le créateur de Naruto ?",
                            List.of(
                                    "Eiichiro Oda",
                                    "Masaki",
                                    "Akira",
                                    "Tite"
                            ),
                            1),
                    new Question(
                            2,
                            "Quel est le fruit de Luffy ?",
                            List.of(
                                    "Gomu Gomu",
                                    "Pomme",
                                    "Poire",
                                    "Fruit du dragon"
                            ),
                            3
                    )
            );

        }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
            questions.add(question);
    }

    public boolean checkAnswer(int questionId, int answerIndex) {
            return questions.stream()
                    .filter(question -> question.id() == questionId)
                    .findFirst()
                    .map(question -> question.correctIndex() == answerIndex)
                    .orElse(false);
    }

}


