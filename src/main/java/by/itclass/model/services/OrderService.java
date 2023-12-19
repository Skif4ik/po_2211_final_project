package by.itclass.model.services;

import by.itclass.model.dao.OrderDao;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public class OrderService {
    private static OrderService service;
    private OrderDao dao;

    private OrderService(){
        dao = OrderDao.getInstance();
    }

    public static OrderService getInstance(){
        if(Objects.isNull(service)){
            service = new OrderService();
        }
        return service;
    }

    public boolean saveOrder(HttpSession session, String address){
        return dao.saveOrder(session, address);
    }
}
