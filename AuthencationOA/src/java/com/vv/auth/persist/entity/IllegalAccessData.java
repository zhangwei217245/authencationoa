/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.entity;

/**
 *
 * @author x-spirit
 */
public class IllegalAccessData {
    private Long scount;
    private Vcustomer user;
    private TRight right;

    public IllegalAccessData(Long scount, Vcustomer user, TRight right) {
        this.scount = scount;
        this.user = user;
        this.right = right;
    }

    

    public TRight getRight() {
        return right;
    }

    public void setRight(TRight right) {
        this.right = right;
    }

    public Long getScount() {
        return scount;
    }

    public void setScount(Long scount) {
        this.scount = scount;
    }

    public Vcustomer getUser() {
        return user;
    }

    public void setUser(Vcustomer user) {
        this.user = user;
    }

    
}
