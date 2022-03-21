package dmitr2ish.com.github.annotations.support;

import java.util.List;

public class SBookService {

    private final SBookRepository sBookRepository;

    public SBookService(SBookRepository sBookRepository) {
        this.sBookRepository = sBookRepository;
    }

    public List<SBook> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<SBook> newBooks = sBookRepository.findNewBooks(days);
        //500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
        for (SBook book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);

        }
        return newBooks;
    }
}
