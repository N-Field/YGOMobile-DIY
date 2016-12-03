package cn.garymb.ygomobile.deck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.garymb.ygomobile.bean.CardInfo;

public class DeckInfo {
    private final List<CardInfo> mainCards;
    private final List<CardInfo> extraCards;
    private final List<CardInfo> sideCards;

    public DeckInfo() {
        mainCards = new ArrayList<>();
        extraCards = new ArrayList<>();
        sideCards = new ArrayList<>();
    }
    public void addMainCards(CardInfo card) {
        if (card != null) {
            this.mainCards.add(card);
        }
    }
    public void addExtraCards(CardInfo card) {
        if (card != null) {
            this.extraCards.add(card);
        }
    }
    public void addSideCards(CardInfo card) {
        if (card != null) {
            this.sideCards.add(card);
        }
    }
    public void setMainCards(Collection<CardInfo> mainCards) {
        if (mainCards != null) {
            this.mainCards.addAll(mainCards);
        }
    }

    public void setExtraCards(Collection<CardInfo> extraCards) {
        if (extraCards != null) {
            this.extraCards.addAll(extraCards);
        }
    }

    public void setSideCards(Collection<CardInfo> sideCards) {
        if (sideCards != null) {
            this.sideCards.addAll(sideCards);
        }
    }

    @Override
    public String toString() {
        return "DeckInfo{" +
                "mainCards=" + mainCards.size() +
                ", extraCards=" + extraCards.size() +
                ", sideCards=" + sideCards.size() +
                '}';
    }

    public List<CardInfo> getMainCards() {
        return mainCards;
    }

    public List<CardInfo> getExtraCards() {
        return extraCards;
    }

    public List<CardInfo> getSideCards() {
        return sideCards;
    }
}
