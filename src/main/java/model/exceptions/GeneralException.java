package model.exceptions;
import model.enums.ExceptionEnum;

public class GeneralException extends RuntimeException{

    public GeneralException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.toString());
    }
}
