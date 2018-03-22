package com.kcn.mybooksapp.service;

import java.util.List;

import com.kcn.mybooksapp.entity.Book;

public interface BookService {

	public List<Book> getBooks();
	
	public void saveBook(Book b);

	public Book getBook(String theIsbn);

	public void deleteBook(String theIsbn);
}
