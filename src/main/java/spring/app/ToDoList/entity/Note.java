package spring.app.ToDoList.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content_note")
    private String content;


}
