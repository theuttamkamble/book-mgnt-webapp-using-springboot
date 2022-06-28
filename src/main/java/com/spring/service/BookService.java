package com.spring.service;

import java.util.List;

import com.spring.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	Book saveBook(Book book);
	
	Book getBookById(Integer id);
	Book updateBook(Book book);
	
	void deleteBookById(Integer id);
}
