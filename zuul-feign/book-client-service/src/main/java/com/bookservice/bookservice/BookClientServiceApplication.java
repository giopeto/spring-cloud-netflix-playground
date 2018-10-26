package com.bookservice.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@RequestMapping("/books-client")
public class BookClientServiceApplication {

	@Autowired BookServiceClient bookServiceClient;
	@Value("${server.port}") private int port;

	public static void main(String[] args) {
		SpringApplication.run(BookClientServiceApplication.class, args);
	}

	@GetMapping("")
	public List<Book> findAllBooks() {
		return bookServiceClient.findAllBooks();
	}

	@GetMapping("/books/port")
	public int getPort() {
		return bookServiceClient.getPort();
	}

		@GetMapping("/books/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		System.out.println("Book id: " + bookId);
		return bookServiceClient.findBook(bookId);
	}
}
