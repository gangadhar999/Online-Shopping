package net.kzn.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.ShoppingBackend.dao.CategoryDAO;
import net.kzn.ShoppingBackend.dto.Category;

public class CategoryTestCase {
	
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzn.ShoppingBackend");
		context.refresh();		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");	
		
	}
	
	/*@Test
	public void testAddCategory(){
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is description for Laptop");
		category.setImage_URL("CAT_105.png");	
		assertEquals("Successfully Added a category inside the Table ",true,categoryDAO.add(category));
		
	}
	
	@Test
	public void testAddCategory(){
		category=categoryDAO.get(3);
		assertEquals("Successfully Fetched a category from  the Table ","Mobile",category.getName());
		
	}
	
	
	@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(3);
		category.setName("Mob");
		assertEquals("Successfully Updated a category from  the Table ","Mobile",categoryDAO.update(category));
		
	}
	
	
	@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(3);
		category.setName("Mob");
		assertEquals("Successfully Deleted a category from  the Table ","Mobile",categoryDAO.delete(category));
		
	}
	
	@Test
	public void testListCategory(){
		
			assertEquals("Successfully Fetched list of  category from  the Table ",5,categoryDAO.list().size());
		
	}
	*/
	
	@Test
	public void testCRUDCategory(){
		//Adding a Category 
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is description for Laptop");
		category.setImage_URL("CAT_101.png");	
		assertEquals("Successfully Added a category inside the Table ",true,categoryDAO.add(category));
		
		
		category=new Category();
		category.setName("Television");
		category.setDescription("This is description for Television");
		category.setImage_URL("CAT_102.png");	
		assertEquals("Successfully Added a category inside the Table ",true,categoryDAO.add(category));
		
		//Updating the Category
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully Updated a category from  the Table ","Mobile",categoryDAO.update(category));
		
		//Deleting the Category
		assertEquals("Successfully Deleted a category from  the Table ","Mobile",categoryDAO.delete(category));
		
		//Fetching the List of Category
		assertEquals("Successfully Fetched list of  category from  the Table ",1,categoryDAO.list().size());
		
	}
}
