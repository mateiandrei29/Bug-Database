package validator;


import exception.ValidationException;
import model.Product;

public class ProductValidator {
    private String errors;

    public void validate(Product p) throws ValidationException {
        errors = "";
        if (p.getFinished() < 0)
            errors += "Finished cannot be negative(only 0 or 1)\n";
        if (p.getName().equals(""))
            errors += "Name is empty\n";
        if (p.getDescription().equals(""))
            errors += "Description is empty\n";

        if (errors.length() > 0) {
            throw new ValidationException(errors);
        }

    }
}
