package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.BaseField;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Man;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Map<String, Field> fields;


    public Map<String, Field> getFields() {
        return fields;
    }

    public ControllerImpl() {
        supplement = new SupplementRepositoryImpl();
        fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);

        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.put(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement1;
        if (type.equals("Powdered")) {
            supplement1 = new Powdered();
        } else if (type.equals("Liquid")) {
            supplement1 = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplement1);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Field field = fields.get(fieldName);

        if (supplementType.equals("Powdered")) {

            Powdered powdered = new Powdered();
            field.addSupplement(powdered);


        } else if (supplementType.equals("Liquid")) {
            Liquid liquid = new Liquid();
            field.addSupplement(liquid);
        } else {
            throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.", supplementType));
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, field.getName());


    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        Field field = fields.get(fieldName);


        if (playerType.equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass")) {
            Player player = new Men(playerName, nationality, strength);
            field.addPlayer(player);
        } else if (playerType.equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf")) {
            Player player = new Women(playerName, nationality, strength);
            field.addPlayer(player);
        } else if (playerType.equals("Men") || playerType.equals("Women")) {
            return String.format(FIELD_NOT_SUITABLE);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        fields.replace(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,playerName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();
        int playersCount = field.getPlayers().size();
        return String.valueOf(playersCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        int totalStrength = field.getPlayers().stream().mapToInt(p -> p.getStrength()).sum();
        return String.format(STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb=new StringBuilder();

        fields.forEach((k,v)->sb.append(v.getInfo()+System.lineSeparator()));
        return sb.toString();
    }
}
