package dmitr2ish.com.github.annotations.support;

import java.util.List;

public interface SBookRepository {

    List<SBook> findNewBooks(int days);
}
