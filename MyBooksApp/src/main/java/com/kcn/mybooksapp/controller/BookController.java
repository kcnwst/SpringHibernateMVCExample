package com.kcn.mybooksapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kcn.mybooksapp.entity.Book;
import com.kcn.mybooksapp.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	//Inject the bookDAO
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public String listBooks(Model m) {
	
		//Get Book from DAO
		List<Book> b = bookService.getBooks();
		
		//Add book to the model
		m.addAttribute("books", b);
		
		return "list-books";
	}
	
	@GetMapping("/showBookFormForAdd")
	public String showFormForAdd(Model m) {
		
		//Create Book object to bind form data
		Book b = new Book();
		
		m.addAttribute("book", b);
		
		return "add-book-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book b) {
		
		//Save the book using the bookService
		bookService.saveBook(b);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/showBookFormForUpdate")
	public String showBookFormForUpdate(@RequestParam("bookIsbn") String theIsbn, Model m) {
		
		//Get the book from book service
		Book b = bookService.getBook(theIsbn);
		
		//Set book as a model attribute to pre-populate the form
		m.addAttribute("book", b);
		
		//Send over to the form
		return "add-book-form";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookIsbn") String theIsbn, Model m) {
		
		//Delete the book
		bookService.deleteBook(theIsbn);
		
		return "redirect:/book/list";
	}

}
