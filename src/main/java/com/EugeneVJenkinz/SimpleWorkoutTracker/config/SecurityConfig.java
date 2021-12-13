package com.EugeneVJenkinz.SimpleWorkoutTracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("user").password("user").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("hr").password("hr").roles("HR"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("manager").password("manager").roles("MANAGER", "HR"));*/
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    // /** означает доступ ко всем вложенным адресам
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("USER")
                .antMatchers("/welcome").hasRole("USER")
                .and().formLogin().permitAll();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
