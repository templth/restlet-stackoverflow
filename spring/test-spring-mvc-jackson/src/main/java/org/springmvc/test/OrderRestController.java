package org.springmvc.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

    // @Autowired
    //private FoodItemService foodItemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public OrderDto addOrder(OrderDto orderDto) {
        return orderDto;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public OrderDto getOrder() {
        //FoodItem foodItem = foodItemService.findOne(1, Boolean.TRUE);
        FoodItem foodItem = new FoodItem();
        OrderDto orderDto = new OrderDto();
        orderDto.setRoomId(23);
        Map<FoodItem, Integer> orders = new HashMap<FoodItem, Integer>();
        orders.put(foodItem, 3);
        return orderDto;
    }
}