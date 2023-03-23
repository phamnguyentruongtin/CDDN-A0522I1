package com.example.book_borrow.controller;

import com.example.book_borrow.model.Book;
import com.example.book_borrow.model.Client;
import com.example.book_borrow.service.IBookService;
import com.example.book_borrow.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BorrowsController {


    @Autowired
    private IBookService iBookService;

    @Autowired
    private IClientService iClientService;

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("clientlist")
    public String clientList(Model model, @RequestParam(defaultValue = "1") int page) {
        model.addAttribute("pageOfClient", iClientService.clinentWithPage(PageRequest.of(page, 1)));
        return "clientlist";
    }

    @GetMapping("booklist")
    public String bookList(Model model, @RequestParam(defaultValue = "1") int page) {
        model.addAttribute("pageOfBook", iBookService.listAllBook(PageRequest.of(page, 1)));
        return "booklist";
    }

    @GetMapping("booklistborrow")
    public String bookListReadyForBorrows(Model model, @RequestParam(defaultValue = "1") int page) {
        model.addAttribute("pageOfBookBorrows", iBookService.listAllReadyForBorrows(PageRequest.of(page, 1)));
        return "booklistforborrows";
    }

    @GetMapping("bookisborrows")
    public String bookListIsBorrows(Model model, @RequestParam(defaultValue = "1") int page) {
        model.addAttribute("pageOfBookIsBorrows", iBookService.listAllBookIsBorrows(PageRequest.of(page, 1)));
        return "booklistIsborrows";
    }

    @GetMapping("createbook")
    public String showcreateBook(Model model) {
        model.addAttribute("book", new Book());
        return "createbook";
    }

    @PostMapping("docreatebook")
    public String doCreateBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "createbook";
        }
        redirectAttributes.addAttribute("sms", "Success");
        iBookService.save(book);
        return "redirect:booklist";
    }

    @GetMapping("createclient")
    public String showCreateClient(Model model) {
        model.addAttribute("client", new Client());
        return "createclient";
    }

    @PostMapping("docreateclient")
    public String doCreateClient(@Valid Client client, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "createclient";
        }
        redirectAttributes.addAttribute("sms", "success");
        iClientService.saveClient(client);
        return "redirect:clientlist";
    }

    @GetMapping("bookofclient")
    public String bookOfClient(@RequestParam(value = "idclient") Integer idClient, Model model) {
        Page<Client> clientPage = iClientService.getAllBookOfclient(idClient, PageRequest.of(1, 10));
        model.addAttribute("clientBookPage", clientPage);
        return "listbookofclient";
    }

    @GetMapping("borrowsbook")
    public String borrowBook(@RequestParam(value = "idbook") Integer idBook, Model model) {
        Book book = iBookService.findByIdBook(idBook);
        int code = (int) Math.round(Math.random() * 100);
        book.setCode(code);
        model.addAttribute("book", book);
        model.addAttribute("listclient", iClientService.getAllClient());
        return "bookborrows";
    }

    @PostMapping("doborrowsbook")
    public String doBorrowsBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "bookborrows";
        }
        redirectAttributes.addAttribute("sms", "success");
        iBookService.borrowsBook(book);
        return "redirect:bookisborrows";
    }

    @GetMapping("showreturnbook")
    public String showReturnBook(){
        return "searchbooktoreturn";
    }

    @GetMapping("returnbook")
    public String getBookReturn(Model model, String nameOfBook) {
        Book book = iBookService.findBookByName(nameOfBook);
        if (book == null) {
            return "404";
        }
        model.addAttribute("book", book);
        return "returnbook";
    }


    @PostMapping("doreturnbook")
    public String doReturnBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes,@RequestParam(value = "codeCheck") Integer codeCheck, Model model) {
        if (bindingResult.hasErrors()) {
            return "returnbook";
        } else {
            if (codeCheck == book.getCode()) {
                iBookService.returnBook(book);
                redirectAttributes.addFlashAttribute("sms", "success");
                return "redirect:booklistborrow";
            } else {
                model.addAttribute("failesms", "Code not true!!!");
                return "returnbook";
            }
        }

    }
    @ExceptionHandler(value = Exception.class)
    public String catchALlException() {
        return "404";
    }


}


