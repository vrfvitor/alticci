package com.vrfvitor.alticci.resources;

import com.vrfvitor.alticci.core.*;
import com.vrfvitor.alticci.dto.*;
import io.swagger.annotations.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

@CrossOrigin
@RestController
@RequestMapping("/alticci")
@Api(tags = "REST API Alticci")
@RequiredArgsConstructor
public class AlticciResource {

    private final AlticciService alticci;

    @GetMapping("/{n}")
    @ApiOperation(value = "Gets a natural number", notes = "Returns the Alticci sequence for the given number")
    public ResponseEntity<Result<Long>> calculate(
            @PathVariable("n") @ApiParam("Natural number, zero or greater") Integer n
    ) {
        if (n < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to calculate Alticci sequence for input 'n' less than 0");
        }
        Long r = alticci.of(n);
        return ResponseEntity.ok(new Result<>(r));
    }
}
