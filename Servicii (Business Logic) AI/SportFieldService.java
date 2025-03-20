package services;

import models.SportField;
import enums.SportType;
import java.util.List;
import java.util.ArrayList;

public class SportFieldService {
    private List<SportField> terenuri = new ArrayList<>();

    public boolean addSportField(SportField field) {
        terenuri.add(field);
        return true;
    }

    public void updateSportField(SportField field) {
        System.out.println("✏ Actualizare teren: " + field.getNume());
    }

    public boolean deleteSportField(int fieldId) {
        return terenuri.removeIf(field -> field.getId() == fieldId);
    }

    public List<SportField> searchFields(String location, SportType type) {
        List<SportField> rezultate = new ArrayList<>();
        for (SportField field : terenuri) {
            if (field.getLocatie().equalsIgnoreCase(location) && field.getTip() == type) {
                rezultate.add(field);
            }
        }
        return rezultate;
    }
}
