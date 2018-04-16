package net.kzn.ShoppingBackend.daoimpl;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.ShoppingBackend.dao.CategoryDAO;
import net.kzn.ShoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories=new ArrayList<>();

	static{
		Category category=new Category();

		//Adding first Category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is description for Television");
		category.setImage_URL("CAT_1.png");
		categories.add(category);

		//Adding Second  Category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description for Mobile");
		category.setImage_URL("CAT_2.png");
		categories.add(category);

		//Adding Third Category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description for Laptop");
		category.setImage_URL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category>  list() {

		String selectActiveCategory="FROM Category WHERE is_active=:is_active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("is_active",true);
		return query.getResultList();
	}	

	@Override
	public boolean add(Category category) {
		try{

			sessionFactory.getCurrentSession().persist(category);
			return true;			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}

	//Getting the single category based on Id

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	/*
	 * 	 * (non-Javadoc)
	 * @see net.kzn.ShoppingBackend.dao.CategoryDAO#update(net.kzn.ShoppingBackend.dto.Category)
	 * Updating single Category
	 */
	@Override
	public boolean update(Category category) {
		try{

			sessionFactory.getCurrentSession().update(category);
			return true;			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setIs_active(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
