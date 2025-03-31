package lab.one.demo.mappers;

import lab.one.demo.dtos.BookDto;
import lab.one.demo.entities.Author;
import lab.one.demo.entities.Book;
import lab.one.demo.entities.Category;
import lab.one.demo.entities.Publisher;
import lab.one.demo.repositories.AuthorRepository;
import lab.one.demo.repositories.CategoryRepository;
import lab.one.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksMapper {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BookDto mapToDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getId(),
                book.getPublisher().getId(), getIds(book));
    }

    public Book mapToEntity(BookDto bookDto){
        Author author = authorRepository.getAuthorById(bookDto.getId());
        Publisher publisher = publisherRepository.getPublisherById(bookDto.getPublisherId());
        List<Category> categories = categoryRepository.getAllByIds(bookDto.getCategoryIds());
        return new Book(bookDto.getTitle(), author, publisher, categories);
    }

    private List<Long> getIds(Book book){
        List<Category> categories = book.getCategories();
        List<Long> ids = new ArrayList<>();

        for (var category : categories){
            ids.add(category.getId());
        }
        return ids;
    }
}
