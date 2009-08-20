package com.vv.auth.struts.platform.base;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author joss
 */
public class BaseException extends Exception {

    private String errorMessage;
    private String inputurl;
    private Throwable error;
    private List errors = new ArrayList();

    public BaseException() {
        super();
    }

    public BaseException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BaseException(Throwable error) {
        this.error = error;
    }

    public BaseException(String errorMessage, Throwable error) {
        this.errorMessage = errorMessage;
        this.error = error;
    }

    public BaseException(String errorMessage, String inputUrl) {
        this.errorMessage = errorMessage;
        this.inputurl = inputUrl;
    }

    public BaseException(String errorMessage, String inputUrl, Throwable error) {
        this.errorMessage = errorMessage;
        this.inputurl = inputUrl;
        this.error = error;
    }

    /**
     * @return ���� error��
     */
    public Throwable getError() {
        return error;
    }

    /**
     * @param error Ҫ���õ� error��
     */
    public void setError(Throwable error) {
        this.error = error;
    }

    /**
     * @return ���� errorMessage��
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage Ҫ���õ� errorMessage��
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return ���� errors��
     */
    public List getErrors() {
        return errors;
    }

    /**
     * @param errors Ҫ���õ� errors��
     */
    public void setErrors(List errors) {
        this.errors = errors;
    }

    public List getExcepionsList() {
        return this.errors;
    }

    public void addException(BaseException ex) {
        this.errors.add(ex);
    }

    public String getMessage() {
        if (error == null) {
            return super.getMessage();
        } else {
            return this.error.getMessage();
        }
    }

    public void printStackTrace() {
        if (error == null) {
            super.printStackTrace();
        } else {
            this.error.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream outStream) {
        if (error == null) {
            super.printStackTrace(outStream);
        } else {
            this.error.printStackTrace(outStream);
        }
    }

    public void printStackTrace(PrintWriter writer) {
        if (error == null) {
            super.printStackTrace(writer);
        } else {
            this.error.printStackTrace(writer);
        }
    }

    public String getInputurl() {
        return inputurl;
    }

    public void setInputurl(String inputurl) {
        this.inputurl = inputurl;
    }
}
