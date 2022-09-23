package Spring.Service;

public interface CheckoutService {
    // 结账的事务
    void checkout( Integer userId,Integer[] bookIds);
}
