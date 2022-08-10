package swapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vehicles {

    private List<String> films = new ArrayList<>();
    private List<String> pilots = new ArrayList<>();
    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String length;
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String vehicle_class;
    private String created;
    private String edited;
    private String url;
}