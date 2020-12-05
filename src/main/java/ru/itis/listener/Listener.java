package ru.itis.listener;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.*;
import ru.itis.repositories.productsRepository.*;
import ru.itis.repositories.productsRepository.deprecated.*;
import ru.itis.services.*;
import ru.itis.util.CallsUtil;
import ru.itis.util.ProductsUtil;
import ru.itis.util.SessionUtil;
import ru.itis.util.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1815144981Misha!");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        DoorRepository doorRepository = new DoorRepositoryJdbcTemplateImpl(dataSource);
        CasementRepository casementRepository = new CasementRepositoryJdbcImpl(dataSource);
        PartitionRepository partitionRepository = new PartitionRepositoryJdbcImpl(dataSource);
        ProductsRepository productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
        BasketRepository basketRepository = new BasketRepositoryJdbcImpl(dataSource);
        CallsRepository callsRepository = new CallsRepositoryImpl(dataSource);

        SessionUtil sessionUtil = new SessionUtil(usersRepository);
        UserUtil userUtil = new UserUtil(usersRepository);
        ProductsUtil productsUtil = new ProductsUtil(productsRepository);
        CallsUtil callsUtil = new CallsUtil(callsRepository);

        SignInService signInService = new SignInServiceImpl(usersRepository, passwordEncoder);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository, passwordEncoder);
        BasketService basketService = new BasketServiceImpl(basketRepository, productsRepository);

        servletContext.setAttribute("signInService", signInService);
        servletContext.setAttribute("signUpService", signUpService);
        servletContext.setAttribute("sessionUtil", sessionUtil);
        servletContext.setAttribute("userUtil", userUtil);
        servletContext.setAttribute("productsUtil", productsUtil);
        servletContext.setAttribute("basketService", basketService);
        servletContext.setAttribute("callsUtil", callsUtil);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
