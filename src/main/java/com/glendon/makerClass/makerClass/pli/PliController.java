package com.glendon.makerClass.makerClass.pli;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pli")
@CrossOrigin(origins = "*")
public class PliController {

    @Autowired
    private PliService pliService;

    @PostMapping("/solve")
    public ResponseEntity<PliResponse> solve(@Valid @RequestBody PliRequest request) {
        PliResponse response = pliService.solve(request);
        return ResponseEntity.ok(response);
    }
}