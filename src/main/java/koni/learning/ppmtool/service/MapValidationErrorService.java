package koni.learning.ppmtool.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapValidationErrorService {

	public ResponseEntity<?> validate(BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errorMap = result.getFieldErrors().stream().collect(Collectors.toMap(fe -> fe.getField(),
					fe -> fe.getDefaultMessage()));
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
