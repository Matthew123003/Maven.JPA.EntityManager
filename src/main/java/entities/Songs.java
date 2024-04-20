package entities;


import javax.persistence.*;

@Entity
@Table(name = "Songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "Year")
    private Integer year;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    @Column(name = "Artist")
    private String artist;

    public Songs(){

    }

    public Songs(String title, String genre, Integer year, String artist){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.artist = artist;
    }

    public Songs(Integer id, String title, String genre, Integer year, String artist){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", Title =" + title + ", Genre =" + genre
                + ", Year =" + year + ", Artist =" + artist + "]";
    }
}
