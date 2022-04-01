package pe.gob.midis.sisfoh.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.annotation.ApplicationScope;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@WebServlet({ "/captcha.do", "/captchaCodigo.do", })
//@ApplicationScope
@Component
@CrossOrigin(origins = "${client.url}")
public class Captcha extends HttpServlet {
	/**
	 * 
	 */
	String url = "";
	String codigoCaptcha = "";
	private static final long serialVersionUID = 1580900535464348924L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   url = request.getServletPath();
		   Gson gson = new Gson();
		
		  if(url.equals("/captcha.do")){
			  BufferedImage bufferedImage = this.generarImagenCaptcha();
			  OutputStream os = null;
				try {
					response.setContentType("image/png");
			        os = response.getOutputStream();
			        ImageIO.write(bufferedImage, "png", os);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}finally {
				  os.flush();
				  os.close();
		        }
			  
		  }else if(url.equals("/captchaCodigo.do")){
				CaptchaBean captchaBean = null;
				List<CaptchaBean> listaCaptchaBean = new ArrayList<CaptchaBean>();
				 
				captchaBean = new CaptchaBean(this.codigoCaptcha,"image1");
				listaCaptchaBean.add(captchaBean);
				captchaBean = new CaptchaBean(this.codigoCaptcha,"image2");
				listaCaptchaBean.add(captchaBean);
				captchaBean = new CaptchaBean(this.codigoCaptcha,"image3");
				listaCaptchaBean.add(captchaBean);
				
			    String jsonData = gson.toJson(listaCaptchaBean);
				response.setContentType("application/json;charset=UTF-8");
			    response.setCharacterEncoding("utf-8");
			    response.setHeader("Cache-Control", "no-cache");
			    PrintWriter out = response.getWriter();
			   
				try {
					out.print(jsonData);
					
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}finally {
					out.flush();
		            out.close();
		        }
		  }
		  
	
    }
	
	
	private BufferedImage generarImagenCaptcha() {
	    int width = 150;
        int height = 50;
        List<Character> arrayList = new ArrayList<Character>();
        //String capcode = "abcdefghijklmnopqurstuvwxyzABCDEFGHIJKLMONOPQURSTUVWXYZ0123456789!@#$%&*";
        String capcode = "0123456789";
        for (int i = 1; i < capcode.length() - 1; i++) {
            arrayList.add(capcode.charAt(i));
        }
        
        Collections.shuffle(arrayList);
        Iterator<Character> itr = arrayList.iterator();
        String s = "";
        String s2 = "";
        Object obj;
        
        while (itr.hasNext()) {
            obj = itr.next();
            s = obj.toString();
            s2 = s2 + s;
        }
        String s1 = s2.substring(0, 3);
        char[] s3 = s1.toCharArray();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        Font font = new Font("Georgia", Font.BOLD, 34);
        g2d.setFont(font);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        GradientPaint gp = new GradientPaint(0, 0, new Color (194, 194, 196), 0, height / 2, new Color (194, 194, 196), true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(0, 0, 0));
        Random r = new Random();
        String captcha = String.copyValueOf(s3);
//        request.getSession().setAttribute("captcha", captcha);
//        System.out.println(captcha);
        this.codigoCaptcha = captcha;
        System.out.println(": "+this.codigoCaptcha);

        int x = 0;
        int y = 0;
        for (int i = 0; i < s3.length; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 27;
            g2d.drawChars(s3, i, 1, x, y);
        }
        g2d.dispose();

        return bufferedImage;
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
	
	
}
