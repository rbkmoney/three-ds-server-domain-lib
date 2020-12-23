package com.rbkmoney.threeds.server.domain.versioning;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rbkmoney.threeds.server.utils.AccountNumberUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)
public class ThreeDsVersionRequest {

    private String accountNumber;

    @Override
    public String toString() {
        return "ThreeDsVersionRequest{" +
                "acctNumber='" + AccountNumberUtils.hideAccountNumber(accountNumber) + '\'' +
                '}';
    }
}
