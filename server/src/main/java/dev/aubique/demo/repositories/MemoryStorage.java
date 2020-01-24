package dev.aubique.demo.repositories;

import dev.aubique.demo.models.VerbDo;

import java.util.ArrayList;
import java.util.List;

public class MemoryStorage {

    private static final MemoryStorage instance;

    static {
        instance = new MemoryStorage();
    }

    private List<VerbDo> verbList;


    public MemoryStorage() {
        verbList = new ArrayList<>();
        verbList.add(new VerbDo(
                "faire", new String[]{"je fais", "tu fais"}, new String[]{"j\'ai fait", "tu fait"}));
        verbList.add(new VerbDo(
                "aller", new String[]{"je vais", "tu vas"}, new String[]{"je suis allé", "tu es allé"}));
    }

    public static MemoryStorage getInstance() {
        return instance;
    }

    public List<VerbDo> getVerbList() {
        return verbList;
    }
}
