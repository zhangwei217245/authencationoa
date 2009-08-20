/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.entity;

/**
 *
 * @author X-Spirit
 */
public interface IEntity {

    @Override
    boolean equals(Object object);

    @Override
    int hashCode();

    @Override
    String toString();
}
