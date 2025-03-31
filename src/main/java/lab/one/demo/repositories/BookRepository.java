package lab.one.demo.repositories;

import lab.one.demo.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getAllBooks(){
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("FROM Book ", Book.class).list();
        return books;
    }

    public void addBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
}
