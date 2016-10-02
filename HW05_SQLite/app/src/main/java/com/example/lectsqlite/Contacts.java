package com.example.lectsqlite;

public class Contacts {

    private int _id;
    private String _name;
    private String _email;

    public Contacts() {
        this._id = 0;
        this._name = "Gosho";
        this._email = "gosho@abv.bg";
    }

    public Contacts(int id, String name, String email) {
        this._id = id;
        this._name = name;
        this._email = email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}
