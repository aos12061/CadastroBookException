package com.example.springajax.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.springajax.api.dto.Book;

public class BookDAO {

	private final Connection connection;
	private ResultSet rs;

	private static List<Book> lstBooks;
	private static Book book;
	
	public BookDAO() throws SQLException {
		
		this.connection = FabricaDeConexoes.getConnection();
		
	}

	public Book salvar(Book book) {
		
		String sql = "INSERT INTO tblBook (bookId, bookName, author) VALUES(?, ?, ?)";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// create the mysql insert preparedstatement
			stmt.setInt(1, book.getBookId());
			stmt.setString (2, book.getBookName());
			stmt.setString (3, book.getAuthor());
			
			stmt.execute();
			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return book;
		
	}

	public List<Book> listar() {
		
		String sql = "SELECT * FROM tblBook";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			lstBooks = new ArrayList<>();
			
			while ( rs.next() ) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAuthor(rs.getString("author"));
					
				lstBooks.add(book);
		    }

			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	
		return lstBooks;
		
	}
}
