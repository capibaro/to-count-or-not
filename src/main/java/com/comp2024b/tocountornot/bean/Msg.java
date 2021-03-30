package com.comp2024b.tocountornot.bean;

public class Msg {

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess() {
        status = 100;
        message = "Success ";
    }

    public void setFail() {
        status = 200;
        message = "Fail ";
    }

    public void setFail(String msg) {
        status = 200;
        message = msg;
    }

    public Msg success() {
        setSuccess();
        return this;
    }

    public Msg fail() {
        setFail();
        return this;
    }

    public Msg fail(String msg) {
        setFail(msg);
        return this;
    }
}