
package org.osanchezhuerta.hospitalbooklet.soa.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.osanchezhuerta.hospitalbooklet.soa.model.Owner;
import org.osanchezhuerta.hospitalbooklet.soa.model.Pet;
import org.springframework.transaction.annotation.Transactional;

public class OwnerTests {

    @Test
    @Transactional
    public void testHasPet() {
        Owner owner = new Owner();
        Pet fido = new Pet();
        fido.setName("Fido");
        assertNull(owner.getPet("Fido"));
        assertNull(owner.getPet("fido"));
        owner.addPet(fido);
        assertEquals(fido, owner.getPet("Fido"));
        assertEquals(fido, owner.getPet("fido"));
    }

}
