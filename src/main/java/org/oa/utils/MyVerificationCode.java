package org.oa.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MyVerificationCode {
    /**
     *
     * @param lenght 长度
     * @param code 排除的字符
     * @return
     */
    public static String getRamCode(int lenght , String code)
    {
        Random r = new Random();
        StringBuffer buf = new StringBuffer();
        while(true)
        {
            int n = r.nextInt(123);
            if((n > 48 && n < 58) || (n > 64 && n < 91) || (n > 96 && n < 123) )
            {
                char ch = (char)n;
                if(code==null || code.indexOf(ch) < 0)
                    buf.append(ch);
                if(buf.length() == lenght)
                    break;
            }
        }
        return buf.toString();
    }

    /**
     * 生成验证码图片
     * @param verificationCode
     * @param width
     * @param height
     * @param interLine
     * @param backGroungColor
     * @return
     */
    public static BufferedImage getImageFromCode(String verificationCode ,
                                                 int width ,
                                                 int height ,
                                                 int interLine ,
                                                 Color backGroungColor)
    {
        BufferedImage image = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.clearRect(0, 0, width, height);
        g2d.setPaint(backGroungColor==null ? Color.WHITE : backGroungColor);
        g2d.fillRect(0, 0, width, height);
        Random r = new Random();
        //画干扰线
        if(interLine > 0)
        {
            int x = r.nextInt(4) , y=0;
            int x1 = width - x;
            int y1 = 0;
            for(int i=0 ; i<interLine ; i++)
            {
                g2d.setPaint(Color.BLUE);
                y = r.nextInt(height - r.nextInt(4));
                y1 = r.nextInt(height - r.nextInt(4));
                g2d.drawLine(x, y, x1, y1);
            }
        }
        //写验证码
        int fsize = (int)(height * 0.8);
        int fx = 0;
        int fy = fsize;
        g2d.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,fsize));
        //写字符
        for(int i=0;i<verificationCode.length();i++)
        {
            fy=(int)((Math.random()*0.3+0.6)*height);//每个字符高低是否随机
            g2d.setPaint(Color.BLACK);
            g2d.drawString(verificationCode.charAt(i)+"",fx,fy);
            fx+=(width / verificationCode.length()) * (Math.random() * 0.3 + 0.8); //依据宽度浮动
        }
        g2d.dispose();
        return image;
    }
}
