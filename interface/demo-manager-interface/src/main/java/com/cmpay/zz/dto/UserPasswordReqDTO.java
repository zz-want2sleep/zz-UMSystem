package com.cmpay.zz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordReqDTO {
    private Long id;
    private String oldPassword;
    private String newPassword;
}
