/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.struts.illegalaccess.chart;

import java.util.List;
import org.jfree.data.general.AbstractDataset;

/**
 *
 * @author X-Spirit
 */
public interface DataSetAdaptor {

    AbstractDataset getDataset(List list, String criteria);

}
