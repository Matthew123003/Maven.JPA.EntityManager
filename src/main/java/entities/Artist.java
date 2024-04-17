package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artist")
public class Artist {
    private Integer id;
    private String artist;
    private Integer numOfMembers;
}
