package com.tsedi.MVCExample.Controller;

import javax.validation.Valid;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tsedi.MVCExample.dao.BookRepository;
import com.tsedi.MVCExample.models.Book;

@Controller
public class HomeController {
	
	private BookRepository bookRepository;
	 @GetMapping("/signup")
	    public String showSignUpForm(Book book) {
	        return "AddBook";
	    }
	    
	    @PostMapping("/addbook")
	    public String addbook(@Valid Book book, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "AddBook";
	        }
	        
	        bookRepository.save(book);
	        model.addAttribute("books",bookRepository.findAll());
	        return "index";
	    }

	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Book book = bookRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
	        
	        model.addAttribute("book", book);
	        return "UpdateBook";
	    }
	    
	    @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") long id, @Valid Book book, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            book.setId(id);
	            return "UpdateBook";
	        }
	            
	         bookRepository.save(book);
	        model.addAttribute("users", bookRepository.findAll());
	        return "index";
	    }
	        
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") long id, Model model) {
	        Book book = bookRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
	       bookRepository.delete(book);
	        model.addAttribute("books", bookRepository.findAll());
	        return "index";
	    }
	}


