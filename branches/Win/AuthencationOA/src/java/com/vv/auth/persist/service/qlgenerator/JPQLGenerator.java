/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service.qlgenerator;

/**
 *
 * @author x-spirit
 */
public class JPQLGenerator {
    private String select_clause;
    private String from_clause;
    private String where_clause;
    private String groupby_clause;
    private String having_clause;
    private String orderby_clause;

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String WHERE = "WHERE";
    public static final String GROUP_BY = "GROUP BY";
    public static final String HAVING = "HAVING";
    public static final String ORDER_BY = "ORDER BY";
    
    public void init(){
        this.select_clause = SELECT;
        this.from_clause = FROM;
        this.where_clause = WHERE;
        this.groupby_clause = GROUP_BY;
        this.having_clause = HAVING;
        this.orderby_clause = ORDER_BY;
    }

}
