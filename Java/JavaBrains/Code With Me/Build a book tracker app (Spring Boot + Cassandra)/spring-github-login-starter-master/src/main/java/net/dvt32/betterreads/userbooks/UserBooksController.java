package net.dvt32.betterreads.userbooks;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import net.dvt32.betterreads.book.Book;
import net.dvt32.betterreads.book.BookRepository;
import net.dvt32.betterreads.user.BooksByUser;
import net.dvt32.betterreads.user.BooksByUserRepository;

@Controller
public class UserBooksController {
    
    @Autowired
    UserBooksRepository userBooksRepository;
    
    @Autowired 
    BooksByUserRepository booksByUserRepository;
    
    @Autowired 
    BookRepository bookRepository;
    
    @PostMapping("/addUserBook")
    public ModelAndView addBookForUser(
        @RequestBody MultiValueMap<String, String> formData, 
        @AuthenticationPrincipal OAuth2User principal
    ) {
        if (principal == null || principal.getAttribute("login") == null) {
            return null;
        }
        
        UserBooks userBooks = new UserBooks();
        UserBooksPrimaryKey key = new UserBooksPrimaryKey();
        String userId = principal.getAttribute("login");
        key.setUserId(userId);
        String bookId = formData.getFirst("bookId");
        key.setBookId(bookId);
        userBooks.setKey(key);
        userBooks.setStartedDate( LocalDate.parse(formData.getFirst("startDate")) );
        userBooks.setCompletedDate( LocalDate.parse(formData.getFirst("completedDate")) );
        Integer rating = Integer.parseInt(formData.getFirst("rating"));
        userBooks.setRating(rating);
        userBooks.setReadingStatus( formData.getFirst("readingStatus") );
        userBooksRepository.save(userBooks);
        
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) {
            return new ModelAndView("redirect:/");
        }
        Book book = optionalBook.get();
        BooksByUser booksByUser = new BooksByUser();
        booksByUser.setId(userId);
        booksByUser.setBookId(bookId);
        booksByUser.setBookName(book.getName());
        booksByUser.setCoverIds(book.getCoverIds());
        booksByUser.setAuthorNames(book.getAuthorNames());
        booksByUser.setReadingStatus(formData.getFirst("readingStatus"));
        booksByUser.setRating(rating);
        booksByUserRepository.save(booksByUser);
        
        return new ModelAndView("redirect:/books/" + bookId);
    }

}
