package com.example.qlm.erp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClassModelValidator implements ConstraintValidator<ValidClassModel, ClassModel> {

    @Override
    public boolean isValid(ClassModel classModel, ConstraintValidatorContext context) {
        if (classModel.numberOfTables() > 24) {
            context.buildConstraintViolationWithTemplate("Az asztalok száma nem lehet több mint 24")
                    .addPropertyNode("numberOfTables").addConstraintViolation();
            return false;
        }

        for (Integer table : classModel.reservedTables()) {
            if (table < 1 || table > classModel.numberOfTables()) {
                context.buildConstraintViolationWithTemplate("Nem létező asztal van megadva foglaltnak: " + table)
                        .addPropertyNode("reservedTables").addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}