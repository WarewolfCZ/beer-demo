package cz.denisfiser.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Beer {
    @Id
    private int id;
    private String uid;
    private String brand;
    private String name;
    private String style;
    private String hop;
    private String yeast;
    private String malts;
    private String ibu;
    private String alcohol;
    private String blg;


    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", hop='" + hop + '\'' +
                ", yeast='" + yeast + '\'' +
                ", malts='" + malts + '\'' +
                ", ibu='" + ibu + '\'' +
                ", alcohol='" + alcohol + '\'' +
                ", blg='" + blg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return id == beer.id && Objects.equals(uid, beer.uid) && Objects.equals(brand, beer.brand) &&
                Objects.equals(name, beer.name) && Objects.equals(style, beer.style) &&
                Objects.equals(hop, beer.hop) && Objects.equals(yeast, beer.yeast) &&
                Objects.equals(malts, beer.malts) && Objects.equals(ibu, beer.ibu) &&
                Objects.equals(alcohol, beer.alcohol) && Objects.equals(blg, beer.blg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, brand, name, style, hop, yeast, malts, ibu, alcohol, blg);
    }
}
