package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String artist;
    private Integer num_Of_Members;

    public Artist(){}

    public Artist(String artist, Integer numOfMembers){
        this.artist = artist;
        this.num_Of_Members = numOfMembers;
    }

    public Artist(Integer id, String artist, Integer numOfMembers){
        this.id = id;
        this.artist = artist;
        this.num_Of_Members = numOfMembers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getNum_Of_Members() {
        return num_Of_Members;
    }

    public void setNum_Of_Members(Integer num_Of_Members) {
        this.num_Of_Members = num_Of_Members;
    }
}
