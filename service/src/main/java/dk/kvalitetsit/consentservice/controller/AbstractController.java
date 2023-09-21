package dk.kvalitetsit.consentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dk.kvalitetsit.consentservice.dto.ServiceErrors;
import dk.kvalitetsit.consentservice.dto.ValidationErrors;
import dk.kvalitetsit.consentservice.service.ConsentServiceException;

public class AbstractController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrors handleControllerParseExceptionException(HttpMessageNotReadableException httpMessageNotReadableException) {
		String errorMessage = httpMessageNotReadableException.getRootCause().getLocalizedMessage();
		LOGGER.error("Parse error for input - error:["+httpMessageNotReadableException.getMessage()+"]");
		ValidationErrors validationErrors = new ValidationErrors();
		validationErrors.setMessage("HttpMessageNotReadableException occured");
		validationErrors.addError(errorMessage);
		return validationErrors;
	}
	
	@ExceptionHandler(ConsentServiceException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ServiceErrors handleXdsException(ConsentServiceException serviceException) {
		ServiceErrors se = new ServiceErrors();
		se.setErrors(serviceException.getErrors());
		return se;
	}
	

}