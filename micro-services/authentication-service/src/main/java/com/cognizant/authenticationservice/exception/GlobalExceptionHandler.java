package com.cognizant.authenticationservice.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.debug("Start");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("error", "Bad Request");
		List<String> errors = new ArrayList<String>();

		if (ex.getCause() instanceof InvalidFormatException) {

			final Throwable cause = ex.getCause() == null ? ex : ex.getCause();
			for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
				LOGGER.debug(" fieldName......." + reference.getFieldName());

				body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");

			}

			LOGGER.debug("**************Message:" + ex.getMessage());

		}

		return new ResponseEntity<>(body, headers, status);
	}

	*/

}
