package lab.one.demo.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lab.one.demo.entities.Author;
import lab.one.demo.entities.Publisher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class BookDto {
    private  Long id;
    private String title;
    private Long authorId;
    private Long publisherId;
    private List<Long> categoryIds;

    public BookDto(Long id, String title, Long authorId, Long publisherId, List<Long> categoryIds) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.categoryIds = categoryIds;
    }

    public BookDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
