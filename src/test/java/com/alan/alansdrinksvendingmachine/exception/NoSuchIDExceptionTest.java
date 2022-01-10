package com.alan.alansdrinksvendingmachine.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NoSuchIDExceptionTest {

    @Test
    public void NoSuchIDExceptionUnitTest() {
        Exception e = new NoSuchIDException("testing");
        Assertions.assertEquals("testing", e.getMessage());
    }

}