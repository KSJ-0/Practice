package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드 포인트로 동작함을 정의한다.
//해당 클래스를 애플리케이션 로딩 시, Spring Bean으로 등록해준다.
@RestController

//클라이언트의 요청을 처리하는 핸들러 메서드를 매핑해준다.
//또한 클래스 전체에서 사용되는 공통 URL 설정을 한다.
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE}) //JSON 형식으로 응답 데이터를 전송하기 위한 설정

public class MemberController {
    @PostMapping //클라이언트의 request body를 서버에 생성할 때 사용하는 애너테이션

    //회원 정보를 등록하는 핸들러 메서드 postMember
    public ResponseEntity postMember(@RequestParam("email") String email, //핸들러 메서드의 파라미터
                                     @RequestParam("name") String name,   //클라이언트에서 전송하는 요청 데이터를 서버에서 전달받을 때 사용
                                     @RequestParam("phone") String phone) {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        Map<String,String> map = new HashMap<>();
        map.put("email",email);
        map.put("name",name);
        map.put("phone",phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    //클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션
    //클라이언트에서 식별자에 요청을 보내는 URI는 /v1/members/{member-id}가 된다
    @GetMapping("/{member-id}") //회원 식별자인 member-id

    //특정 회원의 정보를 클라이언트에 제공하는 핸들러 메서드 getMember
    //핸들러 메서드의 파라미터 @PathVariable. 애트리뷰트는 GetMapping의 괄호와 같아야한다.
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping //별도의 URI를 지정하지 않으면 클래스 레벨의 URI에 매핑된다.
    //회원 목록을 클라이언트에 제공하는 핸들러 메서드 getMembers
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        return new ResponseEntity(HttpStatus.OK);
    }
}
