package com.duobank.stepDefintions;

public enum Endpoints {


    REGISTER("/register.php"), LOGIN("/login.php");




    final String str;
    Endpoints(String str) {
       this.str = str;

    }

    @Override
    public String toString() {
        return this.str;
    }
}
