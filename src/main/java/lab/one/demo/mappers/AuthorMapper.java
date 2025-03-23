package lab.one.demo.mappers;

import lab.one.demo.dtos.AuthorDto;
import lab.one.demo.entities.Author;
import lab.one.demo.entities.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorMapper {
    public AuthorDto mapToDto(Author author){
        return new AuthorDto(author.getId(), author.getName(), author.getSurname(), getBookIds(author));
    }

    public Author mapToEntity(AuthorDto authorDto){
        return new Author(authorDto.getName(), authorDto.getSurname());
    }

    private List<Long> getBookIds(Author author){
        List<Book> books = author.getBooks();
        List<Long> ids = new ArrayList<>();

        for(var book : books){
            ids.add(book.getId());
        }
        return ids;
    }
}
