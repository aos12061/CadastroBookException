package com.example.springajax.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springajax.api.dao.BookDAO;
import com.example.springajax.api.dto.Book;

@RestController
public class BookController {
	
	/*
	List<Book> bookStore = new ArrayList<>();
	
	@PostMapping("/saveBook")
	public ResponseEntity<Object> addBook(@RequestBody Book book) {
		bookStore.add(book);
		ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	*/
	/*@GetMapping("/getBooks")
	public ResponseEntity<Object> getAllBooks() {
		ServiceResponse<List<Book>> response = new ServiceResponse<>("success", bookStore);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/saveBook", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> salvar(@RequestBody Book book) throws Exception {
		
		if (book.getBookName().trim().isEmpty()) {
			throw new Exception("Favor preencher o campo Book Name");
		}
		BookDAO bookDAO = new BookDAO();		
		return new ResponseEntity<Object>(bookDAO.salvar(book), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/getBooks", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> listar() throws SQLException {
		BookDAO bookDAO = new BookDAO();
		return new ResponseEntity<List<Book>>(bookDAO.listar(), HttpStatus.OK);
	}
	
}
