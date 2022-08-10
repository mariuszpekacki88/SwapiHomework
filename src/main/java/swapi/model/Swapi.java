package swapi.model;

import lombok.Data;

@Data
public class Swapi {

    private String count;
    private String next;
    private String previous;
    private Vehicles vehicles;
}