package com.bookapp.design.controller;

import com.bookapp.design.model.BookList;
import com.bookapp.design.repository.BookRepo;
import com.bookapp.design.services.RegService;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
//@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepo bookrepo;
    @GetMapping("/getfavlist")
    public ResponseEntity<List<BookList>> getAllBooks(@RequestParam(required = false) String title) {
        try {
            List<BookList> booklist = new ArrayList<BookList>();
            if(title == null)
                bookrepo.findAll().forEach(booklist::add);
            else
                bookrepo.findByTitleContaining(title).forEach(booklist::add);
            if(booklist.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(booklist,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postfavlist")
    public ResponseEntity<BookList> createBookList(@RequestBody BookList booklist) {
        try {
            BookList _booklist = bookrepo.save(new BookList(booklist.getId(),booklist.getTitle(), booklist.getText()));
            return new ResponseEntity<>(_booklist,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addBook")
    public String saveBook(@RequestBody BookList book) {
        bookrepo.save(book);
        return "Added Book with id: "+book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<BookList> getBooks() {
        return bookrepo.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<BookList> getBook(@PathVariable int id) {
        return bookrepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookrepo.deleteById(id);
        return "book deleted with id: "+id;
    }

}