package com.estagiojpa.estagio.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.estagiojpa.estagio.anotations.UsuarioUpdateValid;
import com.estagiojpa.estagio.dtos.UsuarioUpdateDTO;
import com.estagiojpa.estagio.entities.Usuario;
import com.estagiojpa.estagio.repositories.UsuarioRepository;
import com.estagiojpa.estagio.resources.exceptions.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdateValid, UsuarioUpdateDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioUpdateValid ann) {
	}

	@Override
	public boolean isValid(UsuarioUpdateDTO dto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long userId = Long.parseLong(uriVars.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario usuario = repository.findByEmail(dto.getEmail());
		if (usuario != null && userId != usuario.getId()) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
