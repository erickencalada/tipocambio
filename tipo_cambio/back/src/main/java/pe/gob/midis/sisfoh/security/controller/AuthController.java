package pe.gob.midis.sisfoh.security.controller;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import pe.gob.midis.sisfoh.security.dto.JwtDto;
import pe.gob.midis.sisfoh.security.dto.LoginUsuario;
import pe.gob.midis.sisfoh.security.dto.ModuloDto;
import pe.gob.midis.sisfoh.security.dto.RolDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.security.entity.UsuarioPrincipal;
import pe.gob.midis.sisfoh.security.jwt.JwtProvider;
import pe.gob.midis.sisfoh.security.service.SisfohComunService;
import pe.gob.midis.sisfoh.security.service.UsuarioPropertiesService;
import pe.gob.midis.sisfoh.services.interfaces.TipoCambioServices;
import pe.gob.midis.sisfoh.servlet.CaptchaBean;
import pe.gob.midis.sisfoh.util.Mensaje;
import pe.gob.midis.sisfoh.util.Validador;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
@CrossOrigin(origins = "${client.url}")
@Api("APIS Login seguridad sisfoh")
public class AuthController {
	private final static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
    @Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
	private JwtProvider jwtProvider;
    
    @Autowired
	private UsuarioPropertiesService usuarioPropertiesService;

    @Autowired
	private TipoCambioServices tipoCambioServices;

    @Autowired
	private  SisfohComunService sisfohComunService;
    
    private String codigoCaptcha;
    
    public  String urlUsuarioSeguridad;
    
    public  String idSistema;
    
    
 
    
//    @RequestMapping(value = "/loginusuarioseguridad", method = RequestMethod.POST)
    @PostMapping("/loginusuarioseguridad")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,HttpServletRequest request ,BindingResult bindingResult){
    	logger.info("-INI- loginusuarioseguridad");
    	
    	JwtDto jwtDto = new JwtDto();
    	
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        
        
        String urlS = this.urlUsuarioSeguridad;
        String usernameS = loginUsuario.getNombreUsuario();
        String contrasenaS = loginUsuario.getPassword();
//        Long idSistemaS = 51L;
        
        try {
        	
        	this.sisfohComunService.getUsuarioSeguridadDto( urlS,  usernameS,  contrasenaS, new Long(this.idSistema));
        	
        	Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        	
        	
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal)authentication.getPrincipal();
            UsuarioSeguridadDto usuarioSeguridadDto = usuarioPrincipal.getUsuarioSeguridadDto();
            usuarioSeguridadDto.setContrasena(loginUsuario.getPassword());
            
            jwtDto = new JwtDto(token, userDetails.getUsername(), userDetails.getAuthorities());
            jwtDto.setCoUbigeoUle(usuarioSeguridadDto.getCoUbigeo());
            jwtDto.setCorreoElectronico(usuarioSeguridadDto.getCorreoElectronico());
            jwtDto.setAbreviaturaSistema(usuarioSeguridadDto.getAbreviaturaSistema());
            jwtDto.setDependencia(usuarioSeguridadDto.getDependencia());
            jwtDto.setDiasFaltaCaduca(usuarioSeguridadDto.getDiasFaltaCaduca());
            jwtDto.setIdDependencia(usuarioSeguridadDto.getIdDependencia());
            jwtDto.setIdSistema(usuarioSeguridadDto.getIdSistema());
            jwtDto.setMaternoUsuario(usuarioSeguridadDto.getMaternoUsuario());
            jwtDto.setNombreUsuario(usuarioSeguridadDto.getNombreUsuario());
            jwtDto.setPaternoUsuario(usuarioSeguridadDto.getPaternoUsuario());
            jwtDto.setSistema(usuarioSeguridadDto.getSistema());
            jwtDto.setUbigeo(usuarioSeguridadDto.getUbigeo());
            this.ordenarMenu(usuarioSeguridadDto);
            jwtDto.setListadoRoles(usuarioSeguridadDto.getListadoRoles());
              System.out.println(usuarioSeguridadDto.toString());
		} catch (BadCredentialsException e) {
			logger.error(e.getMessage());//login invalido.
//			 return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.UNAUTHORIZED);
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}catch (Validador e) {
			logger.error(e.getMessage());//problemas en el servicio
//			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.error(e.getMessage());//problemas en el servicio
//			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
			return new ResponseEntity(new Mensaje(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    

    private void ordenarMenu(UsuarioSeguridadDto usuarioSeguridadDto) {
    	List<RolDto> listaRolDto = usuarioSeguridadDto.getListadoRoles();
    	
    	List<String> modulos = new  ArrayList<String>() ;
    	List<ModuloDto> listOrdenadaModuloDto = new  ArrayList<ModuloDto>() ;
    	List<RolDto> listOrdenadaRolDto = new  ArrayList<RolDto>() ;
    	RolDto ordenadarolDto = new RolDto();
    	for(RolDto rolDto :listaRolDto) {
    		for(ModuloDto moduloDto :rolDto.getLstModulo()) {
        		System.out.println("--ANTES--"+moduloDto.getModulo());
        		modulos.add(moduloDto.getModulo());
        	}

    		Collections.sort (modulos);
    		
    		for(String s: modulos) {
    			for(ModuloDto moduloDto :rolDto.getLstModulo()) {
    				if(s.equalsIgnoreCase(moduloDto.getModulo())) {
    					listOrdenadaModuloDto.add(moduloDto);
        			}
            	}
    		}
    		
    		modulos = new  ArrayList<String>() ;
    		ordenadarolDto = new RolDto();
    		BeanUtils.copyProperties(rolDto, ordenadarolDto);
    		ordenadarolDto.setLstModulo(listOrdenadaModuloDto);
    		listOrdenadaRolDto.add(ordenadarolDto);
    		listOrdenadaModuloDto = new  ArrayList<ModuloDto>() ;
    	}
    	
    	
    	
    	
    	
    	for(RolDto rolDto :listOrdenadaRolDto) {
    		for(ModuloDto moduloDto :rolDto.getLstModulo()) {
        		System.out.println("--DESPUES--"+moduloDto.getModulo());
        		modulos.add(moduloDto.getModulo());
        	}
    	}
    	
    	usuarioSeguridadDto.setListadoRoles(listOrdenadaRolDto);
//    	listaRolDto = listOrdenadaRolDto;
    	
    }
    
    
    
    
    @GetMapping(value = "/generarcaptcha")
  	public ResponseEntity<CaptchaBean> generarCaptcha(){
      	logger.info("-INI- generarCaptcha");
      	BufferedImage bufferedImage = this.generarImagenCaptcha();
      	String base64 = this.bufferedImageToBase64AsString(bufferedImage);
      	 
      	CaptchaBean captchaBean = null;
		captchaBean = new CaptchaBean(this.codigoCaptcha, base64);
        return new ResponseEntity(captchaBean, HttpStatus.OK);
      }
    
    private String bufferedImageToBase64AsString(BufferedImage bufferedImage) {
    	logger.info("-INI- BufferedImageToBase64");
    	String base64AsString = null;
	    Base64 base64 = new Base64();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
			 ImageIO.write(bufferedImage, "png", baos);
			 bytes = baos.toByteArray();
//			 bytes = base64.encode(bytes);
			 base64AsString = base64.encodeAsString(bytes);
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	return base64AsString;
    }
    
    
    
    
    
    @RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
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
        System.out.println("this.codigoCaptcha: "+this.codigoCaptcha);
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






	public String getCodigoCaptcha() {
		return codigoCaptcha;
	}

	public void setCodigoCaptcha(String codigoCaptcha) {
		this.codigoCaptcha = codigoCaptcha;
	}

	
	
}