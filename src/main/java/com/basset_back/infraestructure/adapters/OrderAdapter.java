package com.basset_back.infraestructure.adapters;


import com.basset_back.dominio.aggretes.dto.Order;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.out.OrderServOut;
import com.basset_back.infraestructure.dao.ItemsOrdenDao;
import com.basset_back.infraestructure.dao.OrdenDao;
import com.basset_back.infraestructure.dao.ProductoDao;
import com.basset_back.infraestructure.entity.ItemsOrden;
import com.basset_back.infraestructure.entity.Orden;
import com.basset_back.infraestructure.entity.Producto;
import com.basset_back.infraestructure.mapper.OrderMapper;
import com.basset_back.infraestructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderAdapter implements OrderServOut {

    @Autowired
    ItemsOrdenDao itemsOrdenDao;
    @Autowired
    OrdenDao ordenDao;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductoDao productoDao;

    @Override
    public Optional<Order> createOrder(Order order) {
        Orden newOrder = new Orden();

        newOrder.setIdOrden(order.getIdUser());
        newOrder.setEstado("pagado");
        newOrder.setFechaCreacion(new Timestamp(System.currentTimeMillis()));


        List<ItemsOrden> items = newOrder.getItemsOrdens().stream().map(itemDto -> {
            ItemsOrden item = new ItemsOrden();
            //OrdenItemPK ordenItemPK = new OrdenItemPK();
            //ordenItemPK.setIdProducto(itemDto.getProducto().getIdProducto());

            item.setProducto(productoDao.findById(itemDto.getProducto().getIdProducto()).get());
            item.setOrden(newOrder);
            item.setPrecio(itemDto.getPrecio());
            item.setCantidad(itemDto.getCantidad());
            return item;

        }).collect(Collectors.toList());

        newOrder.setItemsOrdens(items);
        newOrder.setPrecioTotal(calculateTotalAmount(order));

        return Optional.of(orderMapper.toOrder(ordenDao.save(newOrder)));
    }

    @Override
    public Optional<Order> updateOrder(Order order) {
        Optional<Orden> orderExist = ordenDao.findById(order.getIdOrder());

        if (orderExist.isPresent()) {
            Orden ordenUpdate = orderExist.get();

            ordenUpdate.setPrecioTotal(calculateTotalAmount(order));
            ordenUpdate.setEstado("pagado");
        }


        return Optional.empty();
    }

    @Override
    public void deleteOrder(long orderId) {
         Optional<Orden> orden  =  ordenDao.findById(orderId);
         if (orden.isPresent()) ordenDao.deleteById(orderId);
    }

    @Override
    public Optional<Order> searchOder(long orderId) {
        Optional<Orden> orden  =  ordenDao.findById(orderId);
        if (orden.isPresent()) return Optional.of(orderMapper.toOrder(orden.get()));

        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> searchItemsOrder(long orderId) {
          List<Producto> productos = itemsOrdenDao.findProductosByOrdenId(orderId);

        return Optional.of(productMapper.toProductList(productos));
    }


    private BigDecimal calculateTotalAmount(Order order) {
        BigDecimal total = order.getItemsOrders().stream()
                .map(ItemsOrden::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total;

    }
}
