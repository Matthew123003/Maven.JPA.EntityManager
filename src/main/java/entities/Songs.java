package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Songs")
public class Songs {

    private Integer id;
    private String title;
    private String genre;
    private Integer year;
    private String artist;
}
