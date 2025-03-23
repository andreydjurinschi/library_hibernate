package lab.one.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class AuthorDto {
    private Long id;

    private String name;

    private String surname;

    private List<Long> booksIds = new ArrayList<>();

    public AuthorDto() {
    }

    public AuthorDto(Long id, String name, String surname, List<Long> ids) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.booksIds = ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Long> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(List<Long> booksIds) {
        this.booksIds = booksIds;
    }
}
