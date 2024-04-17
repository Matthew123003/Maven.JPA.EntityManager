package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String genre;
    private Integer year;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private String artist;
}
