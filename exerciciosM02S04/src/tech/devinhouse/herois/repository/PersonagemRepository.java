package tech.devinhouse.herois.repository;

import tech.devinhouse.herois.model.Personagem;

import java.util.*;

public class PersonagemRepository {

    private List<Personagem> personagens = new ArrayList<>();

    public void inserir(Personagem personagem) {
        personagens.add(personagem);
    }

    public List<Personagem> listar() {
        return personagens;
    }

}
