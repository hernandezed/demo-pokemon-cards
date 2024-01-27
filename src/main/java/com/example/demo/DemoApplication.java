package com.example.demo;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        Handlebars handlebars = new Handlebars();

        Template mustache = handlebars.compile("templates/pokemon_card");
        ImageEncoder imageEncoder = new ImageEncoder();

        HashMap<Object, Object> bulbasaur = new HashMap<>();
        bulbasaur.put("weatherImage", imageEncoder.encode("classpath:assets/weather/sunny.svg"));
        bulbasaur.put("biomeImage", imageEncoder.encode("classpath:assets/biomes/forest.svg"));
        bulbasaur.put("image", imageEncoder.encode("classpath:assets/pokemons/001.png"));
        bulbasaur.put("frame", imageEncoder.encode("classpath:assets/frames/pokemon_frame.svg"));
        bulbasaur.put("type2Image", imageEncoder.encode("classpath:assets/types/poison.png"));
        bulbasaur.put("type1Image", imageEncoder.encode("classpath:assets/types/grass.png"));
        bulbasaur.put("evolutionImage", imageEncoder.encode("classpath:assets/evolution/standard.png"));
        bulbasaur.put("encounterImage", imageEncoder.encode("classpath:assets/encounters/starter.png"));
        bulbasaur.put("moveTypeImage", imageEncoder.encode("classpath:assets/types/grass.png"));
        bulbasaur.put("learnableTypes", List.of(
                imageEncoder.encode("classpath:assets/types/grass.png"),
                imageEncoder.encode("classpath:assets/types/poison.png"),
                imageEncoder.encode("classpath:assets/types/normal.png"),
                imageEncoder.encode("classpath:assets/types/ground.png")));

        bulbasaur.put("name", "Bulbasaur");
        bulbasaur.put("health", "5");
        bulbasaur.put("initiative", "5");
        bulbasaur.put("evolution_cost", "4");
        bulbasaur.put("ability_name", "Espesura");
        bulbasaur.put("ability_description", "Si la vida se reduce por debajo de la mitad, agrega 1 dado a las tiradas de tipo planta");
        bulbasaur.put("move_name", "Espora");
        bulbasaur.put("move_dice", "2");
        bulbasaur.put("move_description", "Inflinge el estado Dormido al objetivo");

        File file1 = ResourceUtils.getFile("001.html");
        if (!file1.exists()) {
            file1.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(file1)) {
            out.println(mustache.apply(bulbasaur));
        }

        HashMap<Object, Object> venusaur = new HashMap<>();

        venusaur.put("weatherImage", imageEncoder.encode("classpath:assets/weather/sunny.svg"));
        venusaur.put("biomeImage", imageEncoder.encode("classpath:assets/biomes/forest.svg"));
        venusaur.put("image", imageEncoder.encode("classpath:assets/pokemons/003.png"));
        venusaur.put("frame", imageEncoder.encode("classpath:assets/frames/pokemon_frame.svg"));
        venusaur.put("type2Image", imageEncoder.encode("classpath:assets/types/poison.png"));
        venusaur.put("type1Image", imageEncoder.encode("classpath:assets/types/grass.png"));
        venusaur.put("evolutionImage", imageEncoder.encode("classpath:assets/evolution/final.png"));
        venusaur.put("encounterImage", imageEncoder.encode("classpath:assets/encounters/strong.png"));
        venusaur.put("moveTypeImage", imageEncoder.encode("classpath:assets/types/grass.png"));
        venusaur.put("learnableTypes", List.of(
                imageEncoder.encode("classpath:assets/types/grass.png"),
                imageEncoder.encode("classpath:assets/types/poison.png"),
                imageEncoder.encode("classpath:assets/types/normal.png"),
                imageEncoder.encode("classpath:assets/types/ground.png")));

        venusaur.put("name", "Venusaur");
        venusaur.put("health", "9");
        venusaur.put("initiative", "9");
        venusaur.put("ability_name", "Espesura");
        venusaur.put("ability_description", "Si la vida se reduce por debajo de la mitad, agrega 1 dado a las tiradas de tipo planta");
        venusaur.put("move_name", "Rayo Solar");
        venusaur.put("move_dice", "6");
        venusaur.put("move_description", "Si se uso el ataque en el anterior turno, lanza 4 dados");

        File file2 = ResourceUtils.getFile("003.html");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(file2)) {
            out.println(mustache.apply(venusaur));
        }

    }

}
