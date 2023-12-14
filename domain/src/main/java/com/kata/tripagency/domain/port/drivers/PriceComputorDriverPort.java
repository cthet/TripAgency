package com.kata.tripagency.domain.port.drivers;

import java.math.BigDecimal;

public interface PriceComputorDriverPort {
    BigDecimal priceTrip(String departure, String destination);
}
