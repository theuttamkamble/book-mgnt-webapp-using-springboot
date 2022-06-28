package com.spring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.Book;
import com.spring.repository.BookRepository;
import com.spring.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Integer id) {
		
		return bookRepository.findById(id).get();
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);		
	}
	
	
}
