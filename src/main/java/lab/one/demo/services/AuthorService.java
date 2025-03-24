package lab.one.demo.services;

import lab.one.demo.dtos.AuthorDto;
import lab.one.demo.entities.Author;
import lab.one.demo.mappers.AuthorMapper;
import lab.one.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public void saveAuthor(AuthorDto authorDto){
        Author author = authorMapper.mapToEntity(authorDto);
        authorRepository.saveAuthor(author);
    }

    public void updateAuthor(Long id, AuthorDto authorDto){
        Author author = authorMapper.mapToEntity(authorDto);
        authorRepository.updateAuthor(id, author);

    }

    public AuthorDto getById(Long id) {
        Author author = authorRepository.getAuthorById(id);
        if(author == null){
            return null;
        }
        return authorMapper.mapToDto(author);
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.getAllAuthors();
        List<AuthorDto> dtos = new ArrayList<>();

        for(var author : authors){
            dtos.add(authorMapper.mapToDto(author));
        }
        return dtos;
    }
}
