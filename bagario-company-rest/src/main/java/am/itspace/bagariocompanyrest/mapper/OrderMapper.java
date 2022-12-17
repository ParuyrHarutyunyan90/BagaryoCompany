package am.itspace.bagariocompanyrest.mapper;

import am.itspace.bagariocompanyrest.dto.CreateOrderDto;
import am.itspace.bagariocompanyrest.dto.CreateProductDto;
import am.itspace.bagariocompanyrest.dto.OrderResponseDto;
import am.itspace.bagariocompanyrest.dto.ProductResponseDto;
import am.itspace.bagariocompanyrest.model.Order;
import am.itspace.bagariocompanyrest.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order map(CreateOrderDto createOrderDto);

    OrderResponseDto map(Order order);

    List<OrderResponseDto> map(List<Order> orderList);
}
