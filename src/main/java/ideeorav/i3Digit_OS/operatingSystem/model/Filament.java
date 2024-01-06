package ideeorav.i3Digit_OS.operatingSystem.model;

import ideeorav.i3Digit_OS.operatingSystem.enumeration.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filament {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String type;
    private String color;
    private int weight;
    private String producer;
    private double price;
    private String imageUrl;
    private Status status;

    @Override
    public String toString() {
        return "Filament{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
