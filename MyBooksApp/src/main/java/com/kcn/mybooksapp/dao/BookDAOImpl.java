package com.kcn.mybooksapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kcn.mybooksapp.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	//Inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {

		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create query and sort by title
		Query<Book> q = currentSession.createQuery("from Book order by title", 
														Book.class);
		
		//Execute query and get result list
		List<Book> books = q.getResultList();
		
		//Return the results
		return books;
	}

	@Override
	public void saveBook(Book b) {
		
		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Execute query to save the data/update when its existing
		currentSession.saveOrUpdate(b);
	}

	@Override
	public Book getBook(String isbn) {
		
		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//Read from database by isbn of the book
		Book b = currentSession.get(Book.class, isbn);
				
		//Return the results
		return b;
	}

	@Override
	public void deleteBook(String theIsbn) {

		//Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create query and delete by isbn
		Query q = currentSession.createQuery("delete from Book where isbn=:bookIsbn");
		
		q.setParameter("bookIsbn", theIsbn);
		
		q.executeUpdate();
	}
	
}
