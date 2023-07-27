package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    @PostMapping//서버에 정보 등록하니 postmapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                             @RequestParam("korName") String korName,
                             @RequestParam("price") String price) {
        System.out.println(engName);
        System.out.println(korName);
        System.out.println(price);

        //핸들러 메서드의 리턴 값으로 Map 객체를 리턴하면
        //Spring MVC 내부적으로 데이터를 JSON 형식으로 자동 변환해준다.
        Map<String, String> map = new HashMap<>();
        map.put("engName",engName);
        map.put("korName",korName);
        map.put("price", price);

        //Map 객체로 리턴해도 클라이언트가 JSON 형식으로 받을 수 있지만
        //ResponseEntity 객체로 데이터를 래핑하고 HTTP 응답 상태를 함께 전달하면
        //클라이언트의 요청을 서버가 어떻게 처리했는지 쉽게 알 수 있다
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    @GetMapping({"/coffee-id"})//서버에 정보 조회하니 getmapping
    public ResponseEntity getCoffee(@PathVariable("/coffee-id")long coffeeId) {
        System.out.println("# coffeeId : " + coffeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# getCoffees : ");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
