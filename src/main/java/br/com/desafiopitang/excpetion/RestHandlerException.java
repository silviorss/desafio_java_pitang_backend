package br.com.desafiopitang.excpetion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestHandlerException {

	
	@ExceptionHandler(Exception.class) 
    public ResponseEntity<?> handleException(Exception ex) {
        if (ex instanceof MethodArgumentNotValidException) {
            return handleValidationExceptions((MethodArgumentNotValidException) ex);
        } else if (ex instanceof LicensePlateAlreadyExistsException) { 
        	return handleLicensePlateAlreadyExistsException((LicensePlateAlreadyExistsException) ex);
        } else if (ex instanceof CarNotFoundException) { 
        	return handleCarNotFoundException((CarNotFoundException) ex);
		}else {
        	return handleInternalServerError();
        }
    }

	public ResponseEntity<List<MessageErrorField>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<MessageErrorField> errors = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			StatusCodeException statusCode = new StatusCodeException(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value());
			errors.add(new MessageErrorField(fieldName, errorMessage, statusCode));
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
    private ResponseEntity<MessageError> handleLicensePlateAlreadyExistsException(LicensePlateAlreadyExistsException ex) {
    	StatusCodeException statusCode = new StatusCodeException(ex.getStatus(), ex.getCode());
    	MessageError error = new MessageError(ex.getMessage(), statusCode);
    	return ResponseEntity.status(ex.getCode()).body(error);
	}
    
    private ResponseEntity<MessageError> handleCarNotFoundException(CarNotFoundException ex) {
    	StatusCodeException statusCode = new StatusCodeException(ex.getStatus(), ex.getCode());
    	MessageError error = new MessageError(ex.getMessage(), statusCode);
    	return ResponseEntity.status(ex.getCode()).body(error);

    }
    
    private ResponseEntity<MessageError> handleInternalServerError() {
    	StatusCodeException statusCode = new StatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    	MessageError error = new MessageError("Internal Server Error", statusCode);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
