package com.kcn.mybooksapp.dao;

import java.util.List;

import com.kcn.mybooksapp.entity.*;

public interface BookDAO {
	
	public List<Book> getBooks();

	public void saveBook(Book b);

	public Book getBook(String isbn);

	public void deleteBook(String theIsbn);
	
}
