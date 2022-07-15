package com.vrfvitor.alticci.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class Result<T> {
    T result;
}
