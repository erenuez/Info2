package Uebung.StadtDAO;

import java.util.HashMap;
import java.util.Map;

public class Stadt {
    private String name;
    private Map<Stadt, Double> ausgehendeStrassen;

    public Stadt(String name) {
        this.name = name;
        this.ausgehendeStrassen = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAusgehendeStrassen(Stadt zielstadt, double distanz) {
        ausgehendeStrassen.put(zielstadt, distanz);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stadt: ").append(name).append("\n");
        sb.append("Ausgehende Strassen: \n");
        for (Map.Entry<Stadt, Double> entry : ausgehendeStrassen.entrySet()){
            sb.append("    Zielstadt: ").append(entry.getKey().getName()).append(", Distanz: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

}
