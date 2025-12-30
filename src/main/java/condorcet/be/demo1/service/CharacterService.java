package condorcet.be.demo1.service;
import condorcet.be.demo1.model.Character;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public enum CharacterService {
    // On utilise un singleton pour que la liste soit partagée
    INSTANCE;

    // Liste Thread-Safe -> pour éviter les bugs si 2 personnes ajoutent au même moment
    private final List<Character> characters = new CopyOnWriteArrayList<>();

    // Initialiser avec quelques champions
    CharacterService() {
        characters.add(new Character("Garen", "Fighter", List.of("Coup de tonnerre", "Charge décisive")));
        characters.add(new Character("Ahri", "Mage", List.of("Orbe", "Charme")));
        characters.add(new Character("Jinx", "Marksam", List.of("Flip flap", "Super roquette")));
    }

    public List<Character> getAll() {
        return characters;
    }

    public void add(Character character) {
        characters.add(character);
    }

    public List<Character> search(String searchQuery) {
        return characters.stream()
                .filter(champion -> champion.name().toLowerCase().contains(searchQuery.toLowerCase()))
                .toList();
    }
}
