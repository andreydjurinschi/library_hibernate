package lab.one.demo.mappers;

import lab.one.demo.dtos.PublisherDto;
import lab.one.demo.entities.Author;
import lab.one.demo.entities.Book;
import lab.one.demo.entities.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherMapper {

    public Publisher mapToEntity(PublisherDto publisherDto){
        return new Publisher(publisherDto.getName());
    }
    public PublisherDto mapToDro(Publisher publisher){
        return new PublisherDto(publisher.getId(), publisher.getName(), getBookIds(publisher));
    }

    private List<Long> getBookIds(Publisher publisher){
        List<Book> books = publisher.getBooks();
        List<Long> ids = new ArrayList<>();

        for(var book : books){
            ids.add(book.getId());
        }
        return ids;
    }
}
