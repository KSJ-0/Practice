package com.codestates.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @PostMapping
    //주문 정보를 등록하는 핸들러 메서드 postOrder
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,   //주문한 회원과
                                    @RequestParam("coffeeId") long coffeeId) { //주문한 메뉴 정보를 서버에서 전달받는다.
        System.out.println("# memberId: " + memberId);
        System.out.println("# coffeeId: " + coffeeId);

        Map<String, Long> map = new HashMap<>();
        map.put("memberID",memberId);
        map.put("coffeeId",coffeeId);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    @GetMapping("/{order-id}") //클라이언트가 서버에 정보를 조회하니 GetMapping
    //주문 정보를 조회하는 핸들러 메서드 getOrder
    public ResponseEntity getOrder(@PathVariable("order-id") long orderID) {
        System.out.println("# orderId: " + orderID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    //주문 목록을 조회하는 핸들러 메서드 getOrders
    public ResponseEntity getOrders() {
        System.out.println("# get Orders");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}