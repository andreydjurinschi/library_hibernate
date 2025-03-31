package lab.one.demo.dtos;

import jakarta.persistence.ManyToMany;
import lab.one.demo.entities.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private List<Long> books = new ArrayList<>();

    public CategoryDto(Long id, String name, List<Long> ids) {
        this.id = id;
        this.name = name;
        this.books = ids;
    }

    public CategoryDto() {
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

    public List<Long> getBooks() {
        return books;
    }

    public void setBooks(List<Long> books) {
        this.books = books;
    }
}
