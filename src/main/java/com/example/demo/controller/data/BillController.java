package com.example.demo.controller.data;

import com.example.demo.dao.domain.dto.BillDto;
import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.UserService;
import com.example.demo.service.mapper.BillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user/bill")
@RequiredArgsConstructor
public class BillController {

    private final UserService userService;
    private final BillMapper billMapper;

    @GetMapping("/get")
    public ResponseEntity<Set<BillDto>> getBillByCredentional(Principal principal) {

        try {
            UserEntity byLogin = userService.findByLogin(principal.getName());

            return new ResponseEntity<>(
                    billMapper.toSetDto(byLogin.getBills()),
                    HttpStatus.OK
            );
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
