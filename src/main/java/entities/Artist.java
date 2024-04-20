package entities;


import javax.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Num_Of_Members")
    private Integer num_Of_Members;

    public Artist(){}

    public Artist(String name, Integer numOfMembers){
        this.name = name;
        this.num_Of_Members = numOfMembers;
    }

    public Artist(Integer id, String name, Integer numOfMembers){
        this.id = id;
        this.name = name;
        this.num_Of_Members = numOfMembers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum_Of_Members() {
        return num_Of_Members;
    }

    public void setNum_Of_Members(Integer num_Of_Members) {
        this.num_Of_Members = num_Of_Members;
    }

    @Override
    public String toString() {
        return "Artist [ID =" + id + ", Name =" + name + ", Number Of Members =" + num_Of_Members + "]";
    }
}
