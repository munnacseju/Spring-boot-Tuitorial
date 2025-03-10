package munna.test.ExceptionHandlerExample;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Error {
    private String message;
    private int code;
    private String exceptionName;
}
