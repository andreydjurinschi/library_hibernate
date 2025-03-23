package lab.one.demo.repositories;

import lab.one.demo.dtos.AuthorDto;
import lab.one.demo.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveAuthor(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
    public List<Author> getAllAuthors() {
        Session session = sessionFactory.openSession();
        List<Author> authors = session.createQuery("FROM Author", Author.class).list();
        return authors;
    }

    public Author getAuthorById(Long id) {
        Session session = sessionFactory.openSession();
        Author author = session.createQuery("FROM Author WHERE id = :id ", Author.class).setParameter("id", id).uniqueResult();
        return author;
    }
}
