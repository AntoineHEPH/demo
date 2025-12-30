package condorcet.be.demo1.model;

import java.util.List;

public record Question(int id, String texte, List<String> options, int correctIndex) {}
