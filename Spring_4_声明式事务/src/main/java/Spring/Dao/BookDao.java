package Spring.Dao;


public interface BookDao {
    // 根据id获取图书
    Integer getPriceByBookId(Integer bookId);

    // 更新图书库存
    void updateStock(Integer bookId);

    // 更新用户余额
    void updeBalance(Integer userId,Integer price);
}
