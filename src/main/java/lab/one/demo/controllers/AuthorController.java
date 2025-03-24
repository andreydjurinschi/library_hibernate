package lab.one.demo.controllers;

import lab.one.demo.dtos.AuthorDto;
import lab.one.demo.entities.Author;
import lab.one.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAll(){
        List<AuthorDto> authors = authorService.getAllAuthors();
        return authors;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        try{
            authorService.updateAuthor(id, authorDto);
            return ResponseEntity.status(HttpStatus.OK).body("Author updated");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public void saveAuthor(@RequestBody AuthorDto authorDto){
        authorService.saveAuthor(authorDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        AuthorDto authorDto = authorService.getById(id);
        if(authorDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(authorDto);
    }


}
