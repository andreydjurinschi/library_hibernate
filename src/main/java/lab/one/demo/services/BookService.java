package lab.one.demo.services;

import lab.one.demo.dtos.BookDto;
import lab.one.demo.entities.Book;
import lab.one.demo.mappers.BooksMapper;
import lab.one.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksMapper booksMapper;

    public void addBook(BookDto bookDto){
        Book book = booksMapper.mapToEntity(bookDto);
        bookRepository.addBook(book);
    }

    public List<BookDto> getAllBooks(){
        List<Book> books = bookRepository.getAllBooks();
        List<BookDto> dtos = new ArrayList<>();

        for(var book : books){
            dtos.add(booksMapper.mapToDto(book));
        }
        return dtos;
    }
}
