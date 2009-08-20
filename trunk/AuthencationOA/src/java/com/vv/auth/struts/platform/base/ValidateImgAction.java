/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.struts.platform.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;

/**
 *
 * @author X-Spirit
 */
public class ValidateImgAction extends Action {

    private int codeDigit = 4;

    public int getCodeDigit() {
        return codeDigit;
    }

    public void setCodeDigit(int codeDigit) {
        this.codeDigit = codeDigit;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);


        int width = codeDigit * 15, height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        Graphics g = image.getGraphics();


        Random random = new Random();


        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);


        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));


        //g.setColor(new Color());
        //g.drawRect(0,0,width-1,height-1);


        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }


        String sRand = "";

        for (int i = 0; i < codeDigit; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;

            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));

            g.drawString(rand, 13 * i + 6, 16);
        }
        request.getSession(false).setAttribute("sRand", sRand);

        g.dispose();


        ImageIO.write(image, "JPEG", response.getOutputStream());
        return null;
    }

    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
