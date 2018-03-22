package com.kcn.mybooksapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kcn.mybooksapp.dao.BookDAO;
import com.kcn.mybooksapp.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookDAO.getBooks();
	}

	@Override
	@Transactional
	public void saveBook(Book b) {
		
		bookDAO.saveBook(b);
	}

	@Override
	@Transactional
	public Book getBook(String theIsbn) {
		
		return bookDAO.getBook(theIsbn);
	}

	@Override
	@Transactional
	public void deleteBook(String theIsbn) {
		
		bookDAO.deleteBook(theIsbn);
	}
}
