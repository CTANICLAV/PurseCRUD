package ru.stasdev.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.stasdev.controller.forms.CurrencyForm;

@Component
public class CurrencyFromValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return CurrencyForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"shortName", "valid.currencyName.empty");
        CurrencyForm message = (CurrencyForm) target;
        if (message.getShortName().length()<2 || message.getShortName().length()>10){
            errors.rejectValue("shortName","valid.currencyName.length");
        }
    }
}
