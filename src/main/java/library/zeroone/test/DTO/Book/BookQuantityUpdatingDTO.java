package library.zeroone.test.DTO.Book;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookQuantityUpdatingDTO {
    @NotNull
    @Min(1)
    @Max(100)
    private Integer quantity;
}
