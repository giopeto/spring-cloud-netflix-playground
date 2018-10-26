package com.bookservice.bookservice;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("book-service")
public interface BookServiceClient {

    @GetMapping(value = "/books")
    List<Book> findAllBooks();

    @GetMapping("/books/port")
    int getPort();

    @RequestMapping(method = GET, value="/books/{bookId}/")
    Book findBook(@PathVariable("bookId") Long bookId);
}
