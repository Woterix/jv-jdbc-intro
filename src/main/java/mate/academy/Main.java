package mate.academy;

import java.math.BigDecimal;
import mate.academy.dao.BookDao;
import mate.academy.lib.lidimpl.Injector;
import mate.academy.models.Book;
import mate.academy.service.serviceimpl.BookServiceImpl;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.academy");
        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);
        Book book = new Book();
        book.setTitle("Dream");
        book.setPrice(BigDecimal.valueOf(10.99));
        BookServiceImpl bookService = new BookServiceImpl(bookDao);
        bookService.create(book);
        Book book2 = new Book();
        book2.setTitle("Night");
        book2.setPrice(BigDecimal.valueOf(15.99));
        bookService.create(book2);
        System.out.println(bookService.findAll());
        System.out.println(bookService.findById(2L));
        book.setPrice(BigDecimal.valueOf(30));
        bookService.update(book);
        bookService.delete(2L);
        System.out.println(bookService.findAll());
    }
}
