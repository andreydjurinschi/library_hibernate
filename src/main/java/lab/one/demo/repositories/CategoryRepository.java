package lab.one.demo.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import lab.one.demo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Category getById(Long id){
        Session session = (Session) sessionFactory.openSession();
        Category category = session.createQuery("FROM Category WHERE id = :id", Category.class).setParameter("id", id).uniqueResult();
        return category;
    }


    public List<Category> getAllByIds(List<Long> ids){
        List<Category> categories = new ArrayList<>();
        for(var id : ids){
            categories.add(getById(id));
        }
        return categories;
    }
}
