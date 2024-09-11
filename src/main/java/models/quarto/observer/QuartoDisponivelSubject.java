package models.quarto.observer;

import java.util.ArrayList;
import java.util.List;

public class QuartoDisponivelSubject {

    private List<IObserver> observers = new ArrayList<>();
    private boolean disponivel;

    public void adicionarObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notificarObservers() {
        for (IObserver observer : observers) {
            observer.update("O quarto que você está interessado agora está disponível!");
        }
    }

    public void quartoDisponivel() {
        this.disponivel = true;
        notificarObservers();
    }
}

