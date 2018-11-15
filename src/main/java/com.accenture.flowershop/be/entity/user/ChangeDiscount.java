package com.accenture.flowershop.be.entity.user;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class ChangeDiscount {

    private Long idUser;
    private BigDecimal discount;

    public ChangeDiscount(){}

    public ChangeDiscount(Long idUser, BigDecimal discount)
    {
        this.idUser = idUser;
        this.discount = discount;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
