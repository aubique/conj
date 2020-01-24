package dev.aubique.demo.repositories;

import dev.aubique.demo.models.VerbDo;

import java.util.List;

public class VerbRepoFromMemoryImpl {

    public List<VerbDo> findAll() {
        return MemoryStorage.getInstance().getVerbList();
    }

    public boolean isExist(String verbToCompare) {
        for (VerbDo verb : findAll()) {
            if (verb.getInfinitive().equals(verbToCompare)) {
                return true;
            }
        }
        return false;
    }

    public VerbDo findVerb(String verbToFind) {
        for (VerbDo verb : findAll()) {
            if (verb.getInfinitive().equals(verbToFind)) {
                return verb;
            }
        }
        return null;
    }
}
