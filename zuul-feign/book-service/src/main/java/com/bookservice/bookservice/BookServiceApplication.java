package com.bookservice.bookservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@RequestMapping("/books")
public class BookServiceApplication {

	@Value("${server.port}") private int port;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	private List<Book> bookList = Arrays.asList(
			new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
			new Book(2L, "Baeldung goes to the park", "Slavisa")
	);

	@GetMapping("")
	public List<Book> findAllBooks(HttpServletRequest req) {
		//printCookies(req);
		return bookList;
	}

	@GetMapping("/port")
	public int getPort() {
		return port;
	}

	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
	}

	private void printCookies(HttpServletRequest req) {
		System.out.println("###########################################");
		for (Cookie cookie : req.getCookies()) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getSecure());
			System.out.println("###########################################");
		}
	}
}
