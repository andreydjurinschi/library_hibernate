package lab.one.demo.repositories;

import lab.one.demo.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Publisher getPublisherById(Long id){
        Session session = sessionFactory.openSession();
        Publisher publisher = session.createQuery("FROM Publisher WHERE id = :id ", Publisher.class)
                .setParameter("id", id).uniqueResult();
        return publisher;
    }
}
