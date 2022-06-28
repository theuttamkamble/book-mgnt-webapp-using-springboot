package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entity.Book;
import com.spring.service.BookService;

@Controller
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/books")
	public String books(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "/views/all_books";
	}
	
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "/views/create_book";
	}
	
	/*@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Book book, Model model) {
		Book b1 = bookService.saveBook(book);
		if(b1 != null) {
			model.addAttribute("result", "Book added successfully!");
		} else {
			model.addAttribute("result", "Book can not be added.");
		}
		model.addAttribute("uttam", "uttam");
		return "redirect:/views/create_book";
	}*/
	
	
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Book book, Model model) {
		Book b1 = bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/book/edit/{id}")
	public String editBookForm(@PathVariable Integer id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "/views/update_book";
	}
	
	@PostMapping("/book/{id}")
	public String updateBook(@PathVariable Integer id, @ModelAttribute Book book, Model model) {
		// get book from database by id
		Book existingBook = bookService.getBookById(id);
		
		existingBook.setId(id);
		existingBook.setBookname(book.getBookname());
		existingBook.setAuthorname(book.getAuthorname());
		existingBook.setPrice(book.getPrice());
		existingBook.setQuantity(book.getQuantity());
		
		// save book
		bookService.updateBook(existingBook);
		return "redirect:/books";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return "redirect:/books";
	}
}
