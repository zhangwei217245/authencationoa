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

    public JPQLGenerator() {
        init();
    }



    public String getSelect_clause() {
        return select_clause;
    }

    public JPQLGenerator setSelect_clause(String select_clause) {
        this.select_clause = this.select_clause+(this.select_clause.equals(SELECT)?" ":", ")+select_clause;
        return this;
    }


    public String getFrom_clause() {
        return from_clause;
    }

    public JPQLGenerator setFrom_clause(String from_clause) {
        this.from_clause = this.from_clause+(this.from_clause.equals(FROM)?" ":", ")+from_clause;
        return this;
    }

    public String getWhere_clause() {
        return where_clause;
    }

    public JPQLGenerator setWhere_clause(String logical_operator,String where_clause) {
        this.where_clause = this.where_clause+(this.where_clause.equals(WHERE)?" ":" "+(isEmptyString(logical_operator)?"AND":logical_operator)+" ")+where_clause;
        return this;
    }

    public String getGroupby_clause() {
        return groupby_clause;
    }

    public JPQLGenerator setGroupby_clause(String groupby_clause) {
        this.groupby_clause = this.groupby_clause+(this.groupby_clause.equals(GROUP_BY)?" ":", ")+groupby_clause;
        return this;
    }

    public String getHaving_clause() {
        return having_clause;
    }

    public JPQLGenerator setHaving_clause(String logical_operator,String having_clause) {
        this.having_clause = this.having_clause+(this.having_clause.equals(HAVING)?" ":" "+(isEmptyString(logical_operator)?"AND":logical_operator)+" ")+having_clause;
        return this;
    }

    public String getOrderby_clause() {
        return orderby_clause;
    }

    public JPQLGenerator setOrderby_clause(String orderby_clause,String ascOrDesc) {
        this.orderby_clause = this.orderby_clause+(this.orderby_clause.equals(ORDER_BY)?" ":", ")+orderby_clause+" "+(isEmptyString(ascOrDesc)?"":ascOrDesc);
        return this;
    }

    private boolean isEmptyString(String s){
        if(s!=null&&s.length()>0){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        if(!this.select_clause.equals(SELECT)){
            sb.append(this.select_clause).append(" ");
        }else{
            return null;
        }

        if(!this.from_clause.equals(FROM)){
            sb.append(this.from_clause).append(" ");
        }else{
            return null;
        }

        if(!this.where_clause.equals(WHERE)){
            sb.append(this.where_clause).append(" ");
        }

        if(!this.groupby_clause.equals(GROUP_BY)){
            sb.append(this.groupby_clause).append(" ");
        }

        if(!this.having_clause.equals(HAVING)){
            sb.append(this.having_clause).append(" ");
        }

        if(!this.orderby_clause.equals(ORDER_BY)){
            sb.append(this.orderby_clause).append(" ");
        }
        return sb.toString().trim();
    }

}
