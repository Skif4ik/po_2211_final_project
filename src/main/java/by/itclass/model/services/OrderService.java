package by.itclass.model.services;

import by.itclass.model.dao.FoodDao;
import by.itclass.model.dao.OrderDao;
import by.itclass.model.entities.Order;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Objects;

public class OrderService implements Service{

    private OrderDao dao;

    public OrderService() {
        dao = new OrderDao();
    }


    public boolean saveOrder(HttpSession session, String address) {
        return dao.saveOrder(session, address);
    }

    public List<Order> getOrders(int userId) {
        return dao.getOrders(userId);
    }

    public String buildReceipt(String orderId) {
        return dao.buildReceipt(orderId);
    }
}