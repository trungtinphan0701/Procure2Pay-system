package hosi.procure2pay.model.response;

import java.util.ArrayList;
import java.util.List;

public class PagedResult<T> {
    private int page;
    private int size;
    private long totalElements;
    private long totalPages;
    private List<T> elements;

    public PagedResult(List<T> elements, long totalPages, long totalElements, int page, int size) {
        this.elements = new ArrayList(elements);
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.page = page;
        this.size = size;
    }

    public boolean isHasMore() {
        return this.totalElements > (long)((this.page + 1) * this.size);
    }

    public boolean isHasPrevious() {
        return this.page > 0 && this.totalElements > 0L;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public int getPage() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }

    public List<T> getElements() {
        return new ArrayList(this.elements);
    }

    public long getTotalPages() {
        return this.totalPages;
    }
}
