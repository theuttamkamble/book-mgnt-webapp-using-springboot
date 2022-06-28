package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_lib_app")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", length = 4)
	private Integer id;

	@Column(name = "book_name", length = 60, nullable = false)
	private String bookname;
	
	@Column(name = "author_name", length = 60)
	private String authorname;
	
	private Double price;
	private Integer quantity;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String bookname, String authorname, Double price, Integer quantity) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", authorname=" + authorname + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
