package pe.gob.midis.sisfoh.security;

import pe.gob.midis.sisfoh.security.jwt.JwtEntryPoint;
import pe.gob.midis.sisfoh.security.jwt.JwtTokenFilter;
import pe.gob.midis.sisfoh.security.service.CustomAuthenticationProvider;
import pe.gob.midis.sisfoh.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;


    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    
    
    
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.authenticationProvider(new CustomAuthenticationProvider());
    }


    
    
    
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    */
    
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/**").permitAll()
                .antMatchers(HttpMethod.GET,"/general/**").permitAll()
                
                .antMatchers(HttpMethod.GET,"/ahuv/**").permitAll()
                .antMatchers(HttpMethod.POST,"/ahuv/**").permitAll()
                
                .antMatchers(HttpMethod.GET,"/brigada/**").permitAll()
                .antMatchers(HttpMethod.POST,"/brigada/**").permitAll()
                
                
                .antMatchers(HttpMethod.GET,"/brigadaUsuario/**").permitAll()
                .antMatchers(HttpMethod.POST,"/brigadaUsuario/**").permitAll()
                
                
                .antMatchers(HttpMethod.GET,"/geolocalizacion/**").permitAll()
                .antMatchers(HttpMethod.POST,"/geolocalizacion/**").permitAll()
                
                .antMatchers(HttpMethod.GET,"/geolocalizacionImag/**").permitAll()
                .antMatchers(HttpMethod.POST,"/geolocalizacionImag/**").permitAll()
                
                
                .antMatchers(HttpMethod.GET,"/hogar/**").permitAll()
                .antMatchers(HttpMethod.POST,"/hogar/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/hogar/*").permitAll()
                
                
                .antMatchers(HttpMethod.GET,"/zona/**").permitAll()
                .antMatchers(HttpMethod.POST,"/zona/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/zona/**").permitAll()

                
                
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
        http.cors();
    }
    
    */
    
    
    
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
    	 .headers().frameOptions().deny()
    	 .and()
		   .cors().and()
		   .csrf()
		   .disable()
	       .authorizeRequests()
			.antMatchers("/").permitAll()
//			.antMatchers("/hello", "/home","/authenticate").permitAll()
//			.antMatchers("/api/sisconv/**").hasAuthority("administrator")//.authenticated()//.hasRole("administrator")
			.and()
			// make sure we use stateless session; session won't be used to
			// store user's state.
			.exceptionHandling()
			.authenticationEntryPoint(jwtEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
<<<<<<< HEAD
	        .headers().cacheControl()
	        .and()
	        .frameOptions().disable();
    }
    */
    

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.cors()
    	    .and()
		    .csrf().disable().authorizeRequests().antMatchers("/").permitAll()
			.and()
			.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class).headers().cacheControl()
	        .and()
	        .frameOptions().disable()
	        .and()
	        .csrf().disable();
    }
    */
    
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable();
     
   	 http.cors()
	    .and()
	    .csrf().disable().authorizeRequests().antMatchers("/").permitAll()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class).headers().cacheControl();
   	 
        http.headers().frameOptions().sameOrigin();
        
        http.headers().defaultsDisabled().contentTypeOptions();
        
        http.headers()
        	.xssProtection()
        	.block(true)
        	.and().contentSecurityPolicy(""
        			+ "object-src 'self' blob: data:;"
        			+ "frame-ancestors 'none';"
        			+ "form-action 'self';"
        			+ "frame-src 'self' blob:; default-src 'self' 'unsafe-inline' "
        			+ "https://www.google-analytics.com "
        			+ "https://cdnjs.cloudflare.com "
        			+ "https://cdn.jsdelivr.net "
        			+ "https://stackpath.bootstrapcdn.com");
    }
    
    */
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable();
     
   	 http.cors()
//	    .and()
//	    .csrf().disable().authorizeRequests().antMatchers("/").permitAll()
		.and()
		.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class).headers().cacheControl();
   	 
        http.headers().frameOptions().sameOrigin();
        
        http.headers().defaultsDisabled().contentTypeOptions();
        
        http.headers()
        	.xssProtection()
        	.block(true)
        	.and().contentSecurityPolicy(""
        			+ "object-src 'self';"
        			+ "frame-ancestors 'none';"
        			+ "form-action 'self';"
        			+ "frame-src 'self'; default-src 'self' 'unsafe-inline' "
        			);
        
        http.headers()
          .addHeaderWriter(new StaticHeadersWriter("X-Powered-By-Header","Express"));

        
        http.headers()
			.frameOptions().sameOrigin()
			.httpStrictTransportSecurity().disable();
        
        
        
        http.headers()
    		.contentSecurityPolicy("script-src 'self' https://maps.googleapis.com; object-src https://maps.googleapis.com; report-uri/csp-report-endpoint/")
    		.reportOnly();
        
        http.headers(headers ->
            headers
                .contentTypeOptions(contentTypeOptions -> contentTypeOptions.disable())
        );
        
//        http.headers().frameOptions().disable();
        
        http.headers().frameOptions().sameOrigin();
    }
}
