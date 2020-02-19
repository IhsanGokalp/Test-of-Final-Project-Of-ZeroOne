package library.zeroone.test.FilterRequest.Book;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
public class PageRequest {
    @Min(0)
    @Max(100)
    private Integer limit;
    @Min(0)
    private Integer offset;
}
