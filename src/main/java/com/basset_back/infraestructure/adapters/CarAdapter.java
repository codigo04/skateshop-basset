package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.ports.out.CarServOut;
import com.basset_back.infraestructure.dao.CarritoDao;
import com.basset_back.infraestructure.dao.ItemsCarritoDao;
import com.basset_back.infraestructure.dao.ProductoDao;
import com.basset_back.infraestructure.dao.UsuarioDao;
import com.basset_back.infraestructure.entity.Carrito;
import com.basset_back.infraestructure.entity.CarritosItemPK;
import com.basset_back.infraestructure.entity.ItemsCarrito;
import com.basset_back.infraestructure.entity.Producto;
import com.basset_back.infraestructure.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarAdapter implements CarServOut {


    @Autowired
    CarritoDao carritoDao;

    @Autowired
    ItemsCarritoDao itemsCarritoDao;

    @Autowired
    ProductoDao productoDao;

    @Autowired
    CarMapper carMapper;


    @Autowired
    UsuarioDao usuarioDao;


    @Override
    public Optional<Car> createCar(Car car) {
        if (car == null || car.getIdCar() == null) {
            return Optional.empty();
        }
        Carrito carrito = carritoDao.save(carMapper.toCarrito(car));

        return Optional.of(carMapper.toCar(carrito));
    }

    @Override
    public Optional<Car> addProductToCar(long carId, Product product, int cantidad) {
        CarritosItemPK carritosItemPK = new CarritosItemPK();

        Optional<Carrito> carrito = carritoDao.findById(carId);
        Optional<Producto> producto = productoDao.findById(product.getProductId());

        if (carrito.isEmpty() || producto.isEmpty()) {
            return Optional.empty(); // Devuelve vacío si no se encuentra el carrito o el producto
        }

        Carrito carritoExist = carrito.get();
        Producto productoExist = producto.get();

        carritosItemPK.setIdCarrito(carritoExist.getIdCarrito());
        carritosItemPK.setIdProducto(productoExist.getIdProducto());

        ItemsCarrito itemsCarrito = itemsCarritoDao.findById(carritosItemPK).orElseGet(() -> {

            ItemsCarrito newItemCarrito = new ItemsCarrito();
            newItemCarrito.setIdPk(carritosItemPK);

            newItemCarrito.setCarrito(carritoExist);
            newItemCarrito.setProducto(productoExist);

            newItemCarrito.setCantidad(0);

            return newItemCarrito;
        });

        itemsCarrito.setCantidad(itemsCarrito.getCantidad() + cantidad);
        itemsCarritoDao.save(itemsCarrito);

        return Optional.of(carMapper.toCar(carritoDao.findById(carId).get()));
    }

    @Override
    public void removeProductFromCar(long carId, String productName) {
        CarritosItemPK carritosItemPK = new CarritosItemPK();

        Carrito carrito = carritoDao.findById(carId).get();

        carritosItemPK.setIdCarrito(carId);

        ItemsCarrito itemsCarrito = itemsCarritoDao.findById(carritosItemPK).get();
        //itemsCarritoDao.delete();

    }

    @Override
    public void removeAllProductsFromCar(long carId) {

        Optional<Carrito> carrito = carritoDao.findById(carId);


        itemsCarritoDao.deleteByCarrito_IdCarrito(carrito.get().getIdCarrito());
    }

    @Override
    public Optional<List<ItemsCarrito>> searchProductsByCarId(long carId) {
        return itemsCarritoDao.findAllByCarrito_IdCarrito(carId);
    }

    @Override
    public Optional<ItemsCarrito> searchProductByName(long carId, String productName) {

        return itemsCarritoDao.findByProducto_Nombre(productName);
    }

    @Override
    public Optional<ItemsCarrito> increaseProductQuantity(long carId, long productId, int quantity) {
        CarritosItemPK carritosItemPK = new CarritosItemPK();

        Optional<Carrito> carrito=   carritoDao.findById(carId);
        Optional<Producto> producto =productoDao.findById(productId);

        carritosItemPK.setIdCarrito(carrito.get().getIdCarrito());
        carritosItemPK.setIdProducto(producto.get().getIdProducto());

        Optional<ItemsCarrito> itemsCarrito = itemsCarritoDao.findById(carritosItemPK);


        if(itemsCarrito.isPresent()){
            ItemsCarrito newItemsCarrito = itemsCarrito.get();
            newItemsCarrito.setCantidad(itemsCarrito.get().getCantidad() + quantity);

            return  Optional.of(itemsCarritoDao.save(newItemsCarrito));
        }


        return Optional.empty();
    }

    @Override
    public Optional<ItemsCarrito> decreaseProductQuantity(long carId, long productId, int quantity) {
        CarritosItemPK carritosItemPK = new CarritosItemPK();

        Optional<Carrito> carrito=   carritoDao.findById(carId);
        Optional<Producto> producto =productoDao.findById(productId);

        carritosItemPK.setIdCarrito(carrito.get().getIdCarrito());
        carritosItemPK.setIdProducto(producto.get().getIdProducto());

        Optional<ItemsCarrito> itemsCarrito = itemsCarritoDao.findById(carritosItemPK);


        if(itemsCarrito.isPresent()){
            ItemsCarrito newItemsCarrito = itemsCarrito.get();
            newItemsCarrito.setCantidad(itemsCarrito.get().getCantidad() - quantity);

            return  Optional.of(itemsCarritoDao.save(newItemsCarrito));
        }


        return Optional.empty();
    }
}
