package com.danisanga.playground.code.wars.kata.hallway;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HallwayTest {
    @Test
    void testContact() {
        assertEquals(1, Hallway.contact("---><----"));
        assertEquals(1, Hallway.contact("--->-<------->----<-"));
        assertEquals(-1, Hallway.contact("----<----->----"));
        assertEquals(2, Hallway.contact(">-----<-->--<-----"));
        assertEquals(3, Hallway.contact(">>-----<<"));
        assertEquals(5, Hallway.contact(">---------------<--------------------------<-------->---------<------->----------<----<---->>----------<------->>>---------------<<------>"));
    }
}