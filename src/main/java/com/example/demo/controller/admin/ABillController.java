package com.example.demo.controller.admin;

import com.example.demo.dao.domain.dto.BillDto;
import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.BillEntity;
import com.example.demo.dao.domain.model.TourEntity;
import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.dao.json.request.BindUserAndBill;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.BillService;
import com.example.demo.service.domain.TourService;
import com.example.demo.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/bill")
@RequiredArgsConstructor
public class ABillController {

    private final TourService tourService;
    private final UserService userService;
    private final BillService billService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewBill(@RequestBody BindUserAndBill bind) {

        try {
            if (bind.getTour_id()==null || bind.getUser_id()==null)
                return new ResponseEntity<>(
                        "user_id and tour_id required",
                        HttpStatus.BAD_REQUEST
                );
            TourEntity tour = tourService.findById(bind.getTour_id());
            UserEntity user = userService.findById(bind.getUser_id());

            BillEntity bill = new BillEntity();
            bill.setTour(tour);
            bill.setUser(user);
            bill.setApprove(false);

            billService.save(bill);

            return new ResponseEntity<>(
                    "successful added new bill",
                    HttpStatus.OK
            );

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/approve")
    public ResponseEntity<String> setApproveForBillUser(@RequestParam("bill_id") Long billId) {

        try {

            BillEntity byId = billService.findById(billId);
            byId.setApprove(true);
            billService.save(byId);

            return new ResponseEntity<>(
                    "Successful set approve to bill with id: " + billId,
                    HttpStatus.OK
            );

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
